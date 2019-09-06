package com.marvelfitness.portal.authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicAuthBean() {
        return new AuthenticationBean("You are authenticated");
    }
}
