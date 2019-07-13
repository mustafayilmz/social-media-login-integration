package com.login.integration.socialmedia.service;

import com.login.integration.socialmedia.dto.facebook.FacebookUserDTO;

public interface FacebookIntegrationService {
    FacebookUserDTO getUser(String facebookReturnCode);
}
