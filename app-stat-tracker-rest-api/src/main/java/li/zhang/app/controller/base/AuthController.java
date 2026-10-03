package li.zhang.app.controller.base;

import li.zhang.app.model.base.AbstractAPIResponse;
import li.zhang.app.model.base.AbstractRestMetaData;
import li.zhang.app.model.base.AbstractRestResponse;
import li.zhang.app.persistence.dto.base.UserInfoDTO;
import li.zhang.app.services.base.TokenService;
import li.zhang.app.utils.constants.RestParams;
import li.zhang.app.utils.constants.RestResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = RestParams.API_CLIENT_URL)
public class AuthController {

    private final TokenService tokenService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AbstractAPIResponse<String> apiResponseSingleton = new AbstractAPIResponse<>();


    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/auth")
    public ResponseEntity<AbstractRestResponse<String>> token(Authentication authentication) {
        // this will be updated to a authorization token exchange
        String token = this.tokenService.generateAccessToken(authentication);
        logger.info("Generated token: {}", token);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.AUTH_PATH, "token generated for user");
        return apiResponseSingleton.createAPIResponse(token , metaData, RestResponseMessage.TOKEN_CREATE_SUCCESS, RestParams.API_STATUS_OK);

    }



}


