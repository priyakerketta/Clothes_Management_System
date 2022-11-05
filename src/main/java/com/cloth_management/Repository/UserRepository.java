package com.cloth_management.Repository;

import com.cloth_management.Models.User;
import com.cloth_management.Models.UserPhoneNo;

import java.util.List;

public interface UserRepository {
    User getUserByUsername(String username);

    public void addUser(User user) ;

    public void updateUser(User user) ;

    public List<UserPhoneNo> getPhones(int user_id) ;

    public Boolean addPhone(int user_id, String user_phoneno) ;


}
