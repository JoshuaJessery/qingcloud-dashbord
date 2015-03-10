package org.nodcloud.web.controller;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.nodcloud.persistent.entity.User;
import org.nodcloud.web.common.page.model.UserRegister;
import org.nodcloud.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.nodcloud.web.common.NodCloudConstruct.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController extends AbstractController {

    @Autowired
    private AccountService accountService;

    @RequestMapping({URL_ROOT, URL_MAP_INDEX})
    public String index(Model model) {
        populateUser(model);
        return MODEL_AND_VIEW_INDEX;
    }


    @RequestMapping(URL_MAP_RGGC)
    public String rggc(Model model) {
        populateUser(model);
        return MODEL_AND_VIEW_RGGC;
    }

    @RequestMapping(URL_MAP_RGFBH)
    public String rgfbh(Model model) {
        populateUser(model);
        return MODEL_AND_VIEW_RGFBH;
    }


    @RequestMapping(value = URL_MAP_LOGIN, method = GET)
    public String login() {
        return MODEL_AND_VIEW_LOGIN;
    }

    @RequestMapping(value = URL_MAP_REGISTER, method = GET)
    public String register() {
        return MODEL_AND_VIEW_REGISTER;
    }

    @RequestMapping(value = URL_MAP_REGISTER, method = POST)
    public String submitRegister(@ModelAttribute UserRegister user, Model model) {

        User dbUser = accountService.findUserByLoginName(user.getEmail());
        if (null == dbUser) {
            createDefaultUser(user);
        } else {
            return "redirect:" + MODEL_AND_VIEW_REGISTER;
        }
        return "redirect:" + MODEL_AND_VIEW_LOGIN;
    }

    private User createDefaultUser(UserRegister userRegister) {
        User user = new User();
        user.setLoginName(userRegister.getEmail());
        user.setPlainPassword(userRegister.getPassword());
        user.setName(userRegister.getUsername());
        user.setFullname(userRegister.getFullName());
        accountService.saveUser(user);
        return user;
    }

    @RequestMapping(value = URL_MAP_LOGIN, method = POST)
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        return MODEL_AND_VIEW_LOGIN;
    }

    private void populateUser(Model model) {

        try {
            Long id = getCurrentUserId();
            User user = accountService.getUser(id);
            model.addAttribute("user", user);
        } catch (Exception ignored) {
        }
    }


}

