package com.adithya.MAMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adithya.MAMS.entity.User;
import com.adithya.MAMS.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User updateUser(Long id, User updatedUser) {
        User existing = getUserById(id);
        existing.setUsername(updatedUser.getUsername());
        existing.setPassword(updatedUser.getPassword());
        existing.setRole(updatedUser.getRole());
        existing.setBase(updatedUser.getBase());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
