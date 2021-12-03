package com.gcu.clc.business;

import com.gcu.clc.data.UserDataService;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessService {

    @Autowired
    private UserDataService userDataService;

    public boolean createUser(UserModel userModel){
        return userDataService.create(userModel);
    }
}
