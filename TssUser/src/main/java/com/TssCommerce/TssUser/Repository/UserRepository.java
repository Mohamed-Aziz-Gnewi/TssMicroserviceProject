package com.TssCommerce.TssUser.Repository;

import com.TssCommerce.TssUser.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
