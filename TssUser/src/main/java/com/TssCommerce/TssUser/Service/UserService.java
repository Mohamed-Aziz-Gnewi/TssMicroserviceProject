package com.TssCommerce.TssUser.Service;

import com.TssCommerce.TssUser.Model.User;
import com.TssCommerce.TssUser.Model.UserDao;

public interface UserService {
    public User getUserById(Long id);
    public UserDao getUserDaoById(Long id);
    public User addUser(User user);
    public User updateUser(Long id,User user);
    public User updateUserDao(Long id,UserDao user);
    public void deleteUser(Long id);
}
