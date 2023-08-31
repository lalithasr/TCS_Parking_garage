package com.tcs.natd.springhandson.parkinggarage.repository;

import com.tcs.natd.springhandson.parkinggarage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository  {
    User getUserByUsername(String username);
    User getUserByEmail(String email);
}
