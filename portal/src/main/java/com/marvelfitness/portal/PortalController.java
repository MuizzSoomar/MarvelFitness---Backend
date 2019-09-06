package com.marvelfitness.portal;

import com.marvelfitness.portal.authentication.AuthenticationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class PortalController {

//    @GetMapping(path = "/basicauth")
//    public AuthenticationBean basicAuthBean() {
//        return new AuthenticationBean("You are authenticated");
//    }

    @RequestMapping("/hello")
    public String helloBean() {
        return "hello";
    }

    @GetMapping("/hello-bean")
    @Bean
    public HelloBean helloBeanBean() {
        return new HelloBean("Hello there");
    }

    @GetMapping("/hello/path/{name}")
    public HelloBean helloPath(@PathVariable String name) {
//        throw new RuntimeException("Something went wrong");
        return new HelloBean(String.format("Hello there, %s", name));
    }

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

