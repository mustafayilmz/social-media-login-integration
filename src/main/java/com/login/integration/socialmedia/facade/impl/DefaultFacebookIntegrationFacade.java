package com.login.integration.socialmedia.facade.impl;

import com.login.integration.socialmedia.dto.facebook.FacebookUserDTO;
import com.login.integration.socialmedia.facade.FacebookIntegrationFacade;
import com.login.integration.socialmedia.service.FacebookIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultFacebookIntegrationFacade implements FacebookIntegrationFacade {
    private FacebookIntegrationService facebookIntegrationService;

    @Override
    public FacebookUserDTO getUser(String facebookReturnCode) {
        return facebookIntegrationService.getUser(facebookReturnCode);
    }

    @Autowired
    public void setFacebookIntegrationService(FacebookIntegrationService facebookIntegrationService) {
        this.facebookIntegrationService = facebookIntegrationService;
    }
}
