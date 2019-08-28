package com.marvelfitness.portal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hi";
    }
}
