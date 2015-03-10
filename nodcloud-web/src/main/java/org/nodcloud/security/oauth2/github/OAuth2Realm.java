package org.nodcloud.security.oauth2.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.GitHubTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.nodcloud.persistent.entity.User;
import org.nodcloud.web.service.AccountService;
import org.nodcloud.utils.Encodes;
import org.nodcloud.security.oauth2.OAuth2AuthenticationException;
import org.nodcloud.security.oauth2.OAuth2Token;
import org.springframework.beans.factory.annotation.Autowired;

import static org.nodcloud.web.service.ShiroDbRealm.ShiroUser;
import static org.nodcloud.security.oauth2.SupportOAuth2Type.GITHUB;

public class OAuth2Realm extends AuthorizingRealm {

    private static final Log logger = LogFactory.getLog(OAuth2Realm.class);

    private String clientId;
    private String clientSecret;
    private String accessTokenUrl;
    private String userInfoUrl;
    private String redirectUrl;

    @Autowired
    protected AccountService accountService;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        OAuth2Token oAuth2Token = (OAuth2Token) token;
        String code = oAuth2Token.getAuthCode(); //获取 auth code
        GithubOAuth2User githubOAuth2User = extractUserinfo(code); // 提取Github用户名

        User user = accountService.findUserByEmail(githubOAuth2User.getEmail());

        if (user == null) {
            user = new User();
            user.setLoginName(githubOAuth2User.getEmail());
            user.setName(githubOAuth2User.getLogin());
            user.setType(GITHUB);
            user.setEmail(githubOAuth2User.getEmail());
            accountService.saveUser(user);
        }
        byte[] salt = null;
        try {
            salt = Encodes.decodeHex(user.getSalt());
        } catch (Exception e) {
            logger.error(e);
        }
        return new SimpleAuthenticationInfo(new ShiroUser(user.getId(), user.getLoginName(), user.getName()), token.getCredentials(),
                ByteSource.Util.bytes(salt), getName());
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    private GithubOAuth2User extractUserinfo(String code) {
        try {
            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
            OAuthClientRequest accessTokenRequest = OAuthClientRequest
                    .tokenLocation(accessTokenUrl)
                            //.setGrantType(GrantType.AUTHORIZATION_CODE)
                    .setClientId(clientId).setClientSecret(clientSecret)
                    .setCode(code).setRedirectURI(redirectUrl)
                    .buildQueryMessage();
            //获取access token
            // GitHubTokenResponse oAuthResponse =
            //        oAuthClient.accessToken(accessTokenRequest, OAuth.HttpMethod.POST);
            GitHubTokenResponse oAuthResponse = oAuthClient.accessToken(accessTokenRequest, GitHubTokenResponse.class);
            String accessToken = oAuthResponse.getAccessToken();
            Long expiresIn = oAuthResponse.getExpiresIn();
            //获取user info
            OAuthClientRequest userInfoRequest =
                    new OAuthBearerClientRequest(userInfoUrl)
                            .setAccessToken(accessToken).buildQueryMessage();
            OAuthResourceResponse resourceResponse = oAuthClient.resource(
                    userInfoRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
            String responseBody = resourceResponse.getBody();
            return new ObjectMapper().readValue(responseBody, GithubOAuth2User.class);
        } catch (Exception e) {
            logger.error(e);
            throw new OAuth2AuthenticationException();
        }
    }

}
