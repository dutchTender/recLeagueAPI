package li.zhang.app.controller.base;

import li.zhang.app.services.base.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final TokenService tokenService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/auth")
    public ResponseEntity<String> token(Authentication authentication) {
        // this will be updated to a authorization token exchange
        var token = this.tokenService.generateAccessToken(authentication);
        logger.info("Generated token: {}", token);
        return ResponseEntity.ok(token);

    }



}


