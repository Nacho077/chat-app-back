package com.chatapp.back.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    private Integer id;

    private String number, firstName, lastName;
    private List<UserDTO> contacts;
}
