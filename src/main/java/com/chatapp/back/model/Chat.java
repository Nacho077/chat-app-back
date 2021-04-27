package com.chatapp.back.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Chat {

    @Id
    private Integer id;

    private List<User> participants;
    private List<Message> messages;
}
