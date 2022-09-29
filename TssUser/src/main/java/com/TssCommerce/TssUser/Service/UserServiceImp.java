package com.TssCommerce.TssUser.Service;

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
        return userRepository.findById(id).get();
    }

    @Override
    public UserDao getUserDaoById(Long id) {
        User user = userRepository.findById(id).get();
        UserDao userDao = new UserDao(user.getId(), user.getFirstName(), user.getLastName(), user.getAddress(),user.getPostalCode(), user.getPhoneNumber(), user.getEmail());
        return userDao;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {

        User existantUser = userRepository.findById(id).get();
        existantUser.setAddress(user.getAddress());
        existantUser.setFirstName(user.getFirstName());
        existantUser.setLastName(user.getLastName());
        existantUser.setPassword(user.getPassword());
        existantUser.setAddress(user.getAddress());
        existantUser.setPostalCode(user.getPostalCode());
        existantUser.setPhoneNumber(user.getPhoneNumber());
        existantUser.setEmail(user.getEmail());
        existantUser.setProfileImage(user.getProfileImage());

        userRepository.save(existantUser);

        return null;
    }

    @Override
    public User updateUserDao(Long id, UserDao user) {
        User existantUser = userRepository.findById(id).get();
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

    }

    @Override
    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id).get();
    }

    @Override
    public List<Shipment> getShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment setShipment(Shipment shipment, Long userId) {
        User user = userRepository.findById(userId).get();
        shipment.setShipmentUser(user);
        return shipmentRepository.save(shipment);

    }
}
