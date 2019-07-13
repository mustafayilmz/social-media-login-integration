package com.login.integration.socialmedia.facade;

import com.login.integration.socialmedia.dto.facebook.FacebookUserDTO;

public interface FacebookIntegrationFacade {
    FacebookUserDTO getUser(String facebookReturnCode);
}
