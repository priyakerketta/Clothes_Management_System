package com.cloth_management.Repository;

import com.cloth_management.Models.Employee;
import com.cloth_management.Models.User;
import com.cloth_management.Models.UserPhoneNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public User getUserByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE username=?",
                new BeanPropertyRowMapper<User>(User.class), username);
    }

    @Override
    public void addUser(User user) {

        String password= user.getUser_password();
        password= bCryptPasswordEncoder.encode(password);

        if (user.getUser_type() == null) {
            user.setUser_type("USER");
        }
        jdbcTemplate.update("INSERT INTO users (user_fname, user_lname, username, user_email, " +
                        " user_password, city,  street,  pin) VALUES (?,?,?,?,?,?,?,?)",
                user.getUser_fname(), user.getUser_lname(), user.getUsername(), user.getUser_email(),
                password,  user.getCity(), user.getStreet(), user.getPin());

    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE users SET user_fname=?, user_lname=?, user_email=?, "+
                        " user_password=?, city=?,  street=?,  pin=? WHERE username=? ", user.getUser_fname(), user.getUser_lname(),
                         user.getUser_email(), user.getUser_password(),user.getCity(),user.getStreet(),user.getPin(),user.getUsername());


    }

    @Override
    public List<UserPhoneNo> getPhones(int user_id) {
       return jdbcTemplate.query("SELECT * FROM users_phone_no WHERE user_id = ?", new RowMapper<UserPhoneNo>() {
            @Override
            public UserPhoneNo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new UserPhoneNo(rs.getString("user_phoneno"), rs.getInt("user_id"));
            }
        },user_id);
    }

    @Override
    public Boolean addPhone(int user_id, String user_phoneno) {

        jdbcTemplate.update("INSERT INTO user_phone_no(user_phoneno,user_id) VALUES (?,?)", user_phoneno, user_id);
        return true;
    }

}
