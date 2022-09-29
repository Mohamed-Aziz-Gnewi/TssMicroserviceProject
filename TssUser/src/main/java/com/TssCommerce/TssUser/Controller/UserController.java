package com.TssCommerce.TssUser.Controller;

import com.TssCommerce.TssUser.Model.User;
import com.TssCommerce.TssUser.Model.UserDao;
import com.TssCommerce.TssUser.Service.UserServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tssuser")
public class UserController {

    public final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id)
    {
       return userServiceImp.getUserById(id);
    }
    @GetMapping("/userDao/{id}")
    public UserDao getUserDtoById(@PathVariable("id") Long id)
    {
        return userServiceImp.getUserDaoById(id);
    }
}
