package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public List<UserCredentials> logins = new ArrayList<>(
            Arrays.asList(new UserCredentials("Tyler", "Kay"), new UserCredentials("Rachet", "Wappet")));

    public void onRun() {

    }

    public List<UserCredentials> getAllControllers() {
        return logins;
    }

    public void updateLogins() {
        loginRepository.saveAll(logins);
    }

    public Boolean validateCredentials(@RequestBody UserCredentials loginCreds) {
        Boolean returnValue = false;
        UserCredentials temp = loginRepository.findByUsername(loginCreds.getUsername());

        if (temp != null && temp.getPassword().equals(loginCreds.getPassword())) {
            returnValue = true;
        }
        return returnValue;

    }

    public Boolean checkUsernameUniqueness(@RequestBody UserCredentials credentials){
        boolean returnValue = false;
        UserCredentials temp = loginRepository.findByUsername(credentials.getUsername());
        if (temp == null){
            returnValue = true;
        }
        return returnValue;
    }

    public void addUser(@RequestBody UserCredentials credentials){
        loginRepository.save(credentials);
    }

}