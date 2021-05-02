package com.chatapp.back.service;

import com.chatapp.back.converter.UserListToDTO;
import com.chatapp.back.model.User;
import com.chatapp.back.model.UserDTO;
import com.chatapp.back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserListToDTO userListToDTO;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<UserDTO> getContact(Integer id) {
        return userListToDTO.convert(userRepository.findAll());
    }
}
