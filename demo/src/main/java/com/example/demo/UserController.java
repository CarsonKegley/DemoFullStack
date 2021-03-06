package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private LoginService loginService;
    LoginRepository repository;

    @GetMapping("/yeet")
    public List<UserCredentials> getControllers() {
        return loginService.getAllControllers();
    }

    @GetMapping("/hellothere")
    public String mrPostMan() {
        return "Hey mister postman wait and see";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Boolean credentialValidation(@RequestBody UserCredentials loginCredentials) {
        loginService.updateLogins();
        return loginService.validateCredentials(loginCredentials);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public Boolean test(@RequestBody UserCredentials credentials) {
        if(loginService.checkUsernameUniqueness(credentials)){
            loginService.addUser(credentials);
            return true;
        }
        return false;
    }
}