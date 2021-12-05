package com.gcu.clc.business;

import com.gcu.clc.data.SecurityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService {

    @Autowired
    private SecurityDataService service;

    public int authenticate(String username, String password){
        return service.getByUsername(username, password);
    }
}
