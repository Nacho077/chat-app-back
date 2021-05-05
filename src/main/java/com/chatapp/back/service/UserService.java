package com.chatapp.back.service;

import com.chatapp.back.converter.UserToDTO;
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
    private UserToDTO userToDTO;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public UserDTO getDTOById(Integer id){
        return userToDTO.convert(this.getById(id));
    }

    public List<UserDTO> getContact(Integer id) {
        return this.getById(id).getContacts();
    }

    public void addContact(Integer id, Integer idNewContact) {
        User user = this.getById(id);
        UserDTO newContact = this.getDTOById(idNewContact);

        user.getContacts().add(newContact);
        userRepository.save(user);
    }
}
