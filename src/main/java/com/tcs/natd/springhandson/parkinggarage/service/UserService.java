package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.User;
import com.tcs.natd.springhandson.parkinggarage.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsers() {
        return this.usersRepository.findAll();
    }

    public User getUserById(Long id) {
        return this.usersRepository.findById(id).orElseGet(User::new);
    }

    public User addUser(User user) {
        return this.usersRepository.save(user);
    }

    public void deleteUser(User user) {
        this.usersRepository.delete(user);
    }
}
