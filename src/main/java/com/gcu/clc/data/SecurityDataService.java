package com.gcu.clc.data;

import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class SecurityDataService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SecurityDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getByUsername(String username, String password){
        int userId = 0;
        String sql = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?";
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, username, password);
            while (srs.next()){
                userId = srs.getInt("USER_ID");
            }
        }catch (Exception e){
            e.printStackTrace();
            return userId;
        }
        return userId;
    }
}
