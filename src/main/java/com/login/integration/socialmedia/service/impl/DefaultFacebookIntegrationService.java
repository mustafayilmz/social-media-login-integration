package com.login.integration.socialmedia.service.impl;

import com.login.integration.socialmedia.constants.FacebookConstants;
import com.login.integration.socialmedia.dto.facebook.FacebookOAuthResponseDTO;
import com.login.integration.socialmedia.dto.facebook.FacebookUserDTO;
import com.login.integration.socialmedia.service.FacebookIntegrationService;
import com.login.integration.socialmedia.util.IntegrationRequestUtil;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultFacebookIntegrationService implements FacebookIntegrationService {
    private static final Logger LOG = Logger.getLogger(DefaultFacebookIntegrationService.class);

    private IntegrationRequestUtil integrationRequestUtil;

    @Override
    public FacebookUserDTO getUser(String facebookReturnCode) {
        try {
            String output = integrationRequestUtil.sendGetRequest(
                    FacebookConstants.getTokenURI(FacebookConstants.REDIRECT_URI, facebookReturnCode),
                    FacebookConstants.TOKEN_REQUEST_TIMEOUT);
            String accessToken = new Gson().fromJson(output, FacebookOAuthResponseDTO.class).getAccess_token();

            output = integrationRequestUtil.sendGetRequest(FacebookConstants.getProfileURI(accessToken),
                    FacebookConstants.DEFAULT_REQUEST_TIMEOUT);
            String userId = new Gson().fromJson(output, FacebookUserDTO.class).getId();

            output = integrationRequestUtil.sendGetRequest(FacebookConstants.getUserFieldsURI(accessToken, userId),
                    FacebookConstants.DEFAULT_REQUEST_TIMEOUT);
            return new Gson().fromJson(output, FacebookUserDTO.class);
        } catch (Exception e) {
            LOG.error(e);
        }
        return null;
    }

    @Autowired
    public void setIntegrationRequestUtil(IntegrationRequestUtil integrationRequestUtil) {
        this.integrationRequestUtil = integrationRequestUtil;
    }
}
