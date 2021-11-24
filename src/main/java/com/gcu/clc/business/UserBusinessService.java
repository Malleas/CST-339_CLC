package com.gcu.clc.business;

import com.gcu.clc.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessService {

    public UserModel createUser(String firstName, String lastName, String email, String phoneNumber, String username, String password){
        System.out.println("First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumber+ "\n" +
                "Username: " + username + "\n" +
                "Password: " + password);
        return new UserModel(firstName, lastName, email, phoneNumber, username, password);
    }
}
