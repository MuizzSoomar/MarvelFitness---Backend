package com.marvelfitness.portal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {

    @GetMapping("/")
    public String sayHello() {
        return "Hi";
    }

    @GetMapping("/customer")
    public String customerHome() {
        return ("Hello customer");
    }

    @GetMapping("/employee")
    public String employeeHome() {
        return ("Hello employee");
    }
}
