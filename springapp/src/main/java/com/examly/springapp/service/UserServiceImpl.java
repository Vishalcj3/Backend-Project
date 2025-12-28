package com.examly.springapp.service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) { return userRepository.save(user); }

    @Override
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @Override
    public User getUserById(Long id) { return userRepository.findById(id).orElse(null); }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(existing -> {
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            if(user.getPassword() != null) existing.setPassword(user.getPassword());
            existing.setRole(user.getRole());
            existing.setPhoneNumber(user.getPhoneNumber());
            existing.setDepartment(user.getDepartment());
            return userRepository.save(existing);
        }).orElse(null);
    }
}
