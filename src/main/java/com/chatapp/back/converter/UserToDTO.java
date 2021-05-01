package com.chatapp.back.converter;

import com.chatapp.back.model.User;
import com.chatapp.back.model.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter;
import org.springframework.stereotype.Component;

@Component
public class UserToDTO implements Converter<User, UserDTO> {

    private final ModelMapper modelMapper;

    public UserToDTO(final ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO convert(final User src){
        return modelMapper.map(src, UserDTO.class);
    }
}
