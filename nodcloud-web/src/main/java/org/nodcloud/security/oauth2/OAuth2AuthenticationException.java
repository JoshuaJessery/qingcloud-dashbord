package org.nodcloud.security.oauth2;

import org.apache.shiro.authc.AuthenticationException;

public class OAuth2AuthenticationException extends AuthenticationException {
    public OAuth2AuthenticationException() {
        super();
    }

    public OAuth2AuthenticationException(String message) {
        super(message);
    }

    public OAuth2AuthenticationException(Throwable cause) {
        super(cause);
    }

    public OAuth2AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
