package com.TssCommerce.TssUser.Service;

import com.TssCommerce.TssUser.Model.User;
import com.TssCommerce.TssUser.Repository.ShipmentRepository;
import com.TssCommerce.TssUser.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ShipmentRepository shipmentRepository;

    UserServiceImp userServiceImp;

    @BeforeEach
    void setUp() {
        userServiceImp = new UserServiceImp(userRepository,shipmentRepository);
    }

    @Test
    void getUserById() {
        User user = new User(1L,"aziz","gnewi","aziz123","Bardo",2000, 26990423,"aziz@gmail.com");
        given(userRepository.findById(1L)).willReturn(Optional.of(user));
        //userServiceImp.getUserById(1L);
        verify(userRepository).findById(1L);
    }

    @Disabled
    @Test
    void getUserDaoById() {
    }

    @Disabled
    @Test
    void addUser() {
    }

    @Disabled
    @Test
    void updateUser() {
    }

    @Disabled
    @Test
    void updateUserDao() {
    }

    @Disabled
    @Test
    void deleteUser() {
    }

    @Disabled
    @Test
    void getShipmentById() {
    }

    @Disabled
    @Test
    void getShipments() {
    }

    @Disabled
    @Test
    void setShipment() {
    }
}