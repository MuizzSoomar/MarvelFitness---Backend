package com.marvelfitness.portal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {

    @RequestMapping(method= RequestMethod.GET, value="/hello")
    public String sayHello() {
        return "Hi";
    }
}
