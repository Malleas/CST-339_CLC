package com.gcu.clc.business;

import com.gcu.clc.data.DataAccessInterface;
import com.gcu.clc.model.ProductModel;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusinessService implements UserBusinessServiceInterface {

    @Autowired
    private DataAccessInterface<UserModel> service;

    public List<UserModel> addUsers();


        return new UserModel(firstName, lastName, email, phoneNumber, username, password);
    }
}
