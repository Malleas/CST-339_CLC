package com.gcu.clc.business;

import com.gcu.clc.data.UserDataService;
import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBusinessService implements UserDetailsService {

    @Autowired
    private UserDataService userDataService;

    public UserBusinessService(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    public boolean createUser(UserModel userModel){
        return userDataService.create(userModel);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginModel user = userDataService.findByUsername(username);
        if(user != null){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUsername(), user.getPassword(), authorities);
        }else {
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
