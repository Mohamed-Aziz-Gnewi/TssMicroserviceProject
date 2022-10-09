package com.TssCommerce.TssUser.Service;

import com.TssCommerce.TssUser.Controller.Exception.ElementNotFoundException;
import com.TssCommerce.TssUser.Model.Shipment;
import com.TssCommerce.TssUser.Model.User;
import com.TssCommerce.TssUser.Model.UserDao;
import com.TssCommerce.TssUser.Repository.ShipmentRepository;
import com.TssCommerce.TssUser.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    public final UserRepository userRepository;
    public final ShipmentRepository shipmentRepository;

    public UserServiceImp(UserRepository userRepository,ShipmentRepository shipmentRepository ) {
        this.userRepository = userRepository;
        this.shipmentRepository= shipmentRepository;
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new ElementNotFoundException("User with id : "+id+" not found"));
    }

    @Override
    public UserDao getUserDaoById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new ElementNotFoundException("User with id : "+id+" not found"));
        UserDao userDao = new UserDao(user.getId(), user.getFirstName(), user.getLastName(), user.getAddress(),user.getPostalCode(), user.getPhoneNumber(), user.getEmail());
        return userDao;
    }

    @Override
    public User addUser(User user) {
        User newUser = new User(user.getFirstName(), user.getLastName(), user.getPassword(), user.getAddress(), user.getPostalCode(), user.getPhoneNumber(), user.getEmail());
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(Long id, User user) {

        User existantUser = userRepository.findById(id).orElseThrow(()->new ElementNotFoundException("User with id : "+id+" not found"));
        existantUser.setAddress(user.getAddress());
        existantUser.setFirstName(user.getFirstName());
        existantUser.setLastName(user.getLastName());
        existantUser.setPassword(user.getPassword());
        existantUser.setAddress(user.getAddress());
        existantUser.setPostalCode(user.getPostalCode());
        existantUser.setPhoneNumber(user.getPhoneNumber());
        existantUser.setEmail(user.getEmail());
        existantUser.setProfileImage(user.getProfileImage());

        return userRepository.save(existantUser);

    }

    @Override
    public User updateUserDao(Long id, UserDao user) {
        User existantUser = userRepository.findById(id).orElseThrow(()->new ElementNotFoundException("User with id : "+id+" not found"));
        existantUser.setAddress(user.getAddress());
        existantUser.setFirstName(user.getFirstName());
        existantUser.setLastName(user.getLastName());
        existantUser.setAddress(user.getAddress());
        existantUser.setPostalCode(user.getPostalCode());
        existantUser.setPhoneNumber(user.getPhoneNumber());
        existantUser.setEmail(user.getEmail());
        return userRepository.save(existantUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new ElementNotFoundException("User with id : "+id+" not found"));
        userRepository.delete(user);
    }

    @Override
    public Shipment getShipmentById(Long id) {

        return shipmentRepository.findById(id).orElseThrow(()-> new ElementNotFoundException("Shipment with id : "+id+" Not found"));
    }

    @Override
    public List<Shipment> getShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment setShipment(Shipment shipment, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ElementNotFoundException("User with id : "+userId+" Not found"));
        Shipment newShipment = new Shipment(shipment.getCompanyName(),shipment.getAddress(),shipment.getPostalCode(),shipment.getPhoneNumber(),user);
        return shipmentRepository.save(newShipment);

    }
}
