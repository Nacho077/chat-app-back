package com.chatapp.back.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class UserDTO {

    @Id
    private Integer id;

    private String firstName, lastName;
}
