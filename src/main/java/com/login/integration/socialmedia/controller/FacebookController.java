package com.login.integration.socialmedia.controller;

import com.login.integration.socialmedia.constants.FacebookConstants;
import com.login.integration.socialmedia.facade.FacebookIntegrationFacade;
import com.login.integration.socialmedia.service.FacebookIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/facebook")
public class FacebookController {
    private FacebookIntegrationFacade facebookIntegrationFacade;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        request.setAttribute("facebookLoginUri", FacebookConstants.getFacebookLoginUri(FacebookConstants.REDIRECT_URI));
        return "auth/facebookLogin";
    }

    @RequestMapping(value = "/loginResult", method = RequestMethod.GET)
    public String loginFacebook(HttpServletRequest request) {
        String code = request.getParameter(FacebookConstants.FACEBOOK_RETURN_CODE_PARAM);
        if (code != null) {
            request.setAttribute("user", facebookIntegrationFacade.getUser(code));
        }
        return "auth/facebook";
    }

    @Autowired
    public void setFacebookIntegrationFacade(FacebookIntegrationFacade facebookIntegrationFacade) {
        this.facebookIntegrationFacade = facebookIntegrationFacade;
    }
}
