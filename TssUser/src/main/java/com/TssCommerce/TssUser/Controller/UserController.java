package com.TssCommerce.TssUser.Controller;

import com.TssCommerce.TssUser.Model.Shipment;
import com.TssCommerce.TssUser.Model.User;
import com.TssCommerce.TssUser.Model.UserDao;
import com.TssCommerce.TssUser.Service.EmailSenderService;
import com.TssCommerce.TssUser.Service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tssuser")
public class UserController {

    public final UserServiceImp userServiceImp;

    @Autowired
    public  EmailSenderService senderService;

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

    @GetMapping("/getShipments")
        public List<Shipment> getShipments()
        {
           return userServiceImp.getShipments();

        }
    @GetMapping("/getShipment/{id}")
    public Shipment getShipments(@PathVariable("id") Long id)
    {
        return userServiceImp.getShipmentById(id);

    }
    @PostMapping("/addShipment/{userId}")
    public Shipment getShipments(@RequestBody Shipment shipment,@PathVariable("userId") Long userId)
    {
        return userServiceImp.setShipment(shipment,userId);

    }
    @PostMapping("/addUser")
    public User createUser(@RequestBody User user){
        return userServiceImp.addUser(user);
    }
    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable("id") Long id,@RequestBody User user){
        return userServiceImp.updateUser(id,user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id")Long id){
        userServiceImp.deleteUser(id);
    }

    @PostMapping("/mail")
    public void sendMail()
    {
        senderService.SendEmail("gnewamedaziz99@gmail.com","SpringEmail","Hello I am here !!");
    }
}
