package li.zhang.app.controller.base;

import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import li.zhang.app.model.base.AbstractAPIResponse;
import li.zhang.app.model.base.AbstractRestMetaData;
import li.zhang.app.model.base.AbstractRestResponse;
import li.zhang.app.services.base.TokenService;
import li.zhang.app.utils.constants.RestParams;
import li.zhang.app.utils.constants.RestResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = RestParams.API_CLIENT_URL)
public class AuthController {

    private final TokenService tokenService;
    private final JWKSource<SecurityContext> jwkSource;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AbstractAPIResponse<String> apiResponseJwt = new AbstractAPIResponse<>();
    private final AbstractAPIResponse<Map<String, Object>> apiResponseJwk = new AbstractAPIResponse<>();


    public AuthController(TokenService tokenService, JWKSource<SecurityContext> jwkSource) {
        this.tokenService = tokenService;
        this.jwkSource = jwkSource;
    }

    @PostMapping(RestParams.AUTH_PATH)
    public ResponseEntity<AbstractRestResponse<String>> token(Authentication authentication) {
        // this will be updated to a authorization token exchange
        String token = this.tokenService.generateAccessToken(authentication);
        logger.info("Generated token: {}", token);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.AUTH_PATH, "token generated for user");
        return apiResponseJwt.createAPIResponse(token , metaData, RestResponseMessage.TOKEN_CREATE_SUCCESS, RestParams.API_STATUS_OK);

    }

    @GetMapping(RestParams.JWKs_PATH)
    public ResponseEntity<AbstractRestResponse<Map<String, Object>>>keys() throws KeySourceException {
        // This converts your key set cleanly into standard JWK JSON format
        JWKSelector selector = new JWKSelector(new JWKMatcher.Builder().build());
        var keys = this.jwkSource.get(selector, null);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.JWKs_PATH, "rsa pub key for user");
        return apiResponseJwk.createAPIResponse(new JWKSet(keys).toJSONObject(), metaData, RestResponseMessage.JWKs_RETURNED_SUCCESS, RestParams.API_STATUS_OK);

    }

}


