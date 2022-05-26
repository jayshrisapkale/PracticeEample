package com.user.service;

import com.user.entity.User;
import com.user.repository.UserRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{
@Autowired
    UserRpository userRpository;

    @Override
    public User insertUser(User user) {
        return userRpository.save(user);
    }

    @Override
    public User getUser(Integer id) {
        return userRpository.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRpository.findAll();
    }
}
