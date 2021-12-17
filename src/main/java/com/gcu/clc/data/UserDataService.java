package com.gcu.clc.data;

import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDataService implements DataAccessInterface<UserModel> {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDataService(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UserModel> getAll() {
        String sql = "SELECT * FROM USER";
        List<UserModel> users = new ArrayList<>();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
            while (srs.next()){
                users.add(new UserModel(srs.getInt("USER_ID"), srs.getString("FIRST_NAME"),
                        srs.getString("LAST_NAME"), srs.getString("EMAIL"), srs.getString("PHONE_NUMBER"),
                        srs.getString("USERNAME"), srs.getString("PASSWORD"), srs.getBoolean("IS_ACTIVE"),
                        srs.getInt("ROLE")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserModel getById(int id) {
        String sql = "SELECT * FROM USER WHERE USER_ID = ?";
        UserModel user = new UserModel();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
            while (srs.next())
            {
                user.setUserId(id);
                user.setFirstName(srs.getString("FIRST_NAME"));
                user.setLastName(srs.getString("LAST_NAME"));
                user.setEmail(srs.getString("EMAIL"));
                user.setPhoneNumber(srs.getString("PHONE_NUMBER"));
                user.setUsername(srs.getString("USERNAME"));
                user.setPassword(srs.getString("PASSWORD"));
                user.setRoleId(srs.getInt("ROLE"));
                user.setActive(srs.getBoolean("IS_ACTIVE"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public boolean create(UserModel user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        String sql = "INSERT INTO USER(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, USERNAME, PASSWORD) VALUES (?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(),
                    user.getUsername(), hashedPassword);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(UserModel user) {
        String sql = "UPDATE USER SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE_NUMBER = ?, USERNAME = ?, PASSWORD = ? WHERE USER_ID = ?";
        try {
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(),
                    user.getUsername(), user.getPassword(), user.getUserId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(UserModel userModel) {
        String sql = "DELETE FROM USER WHERE USER_ID = ?";
        try {
            jdbcTemplate.update(sql, userModel.getUserId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public LoginModel findByUsername(String username){
        String sql = "SELECT * FROM USER WHERE USERNAME = ?";
        LoginModel loginModel = new LoginModel();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, username);
            while (srs.next()){
                loginModel.setId(srs.getInt("USER_ID"));
                loginModel.setUsername(srs.getString("USERNAME"));
                loginModel.setPassword(srs.getString("PASSWORD"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return loginModel;
    }
}
