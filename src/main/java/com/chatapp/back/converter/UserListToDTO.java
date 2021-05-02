package com.chatapp.back.converter;

import com.chatapp.back.model.User;
import com.chatapp.back.model.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserListToDTO implements Converter<List<User>, List<UserDTO>> {

    private final ModelMapper modelMapper;

    public UserListToDTO(final ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> convert(List<User> src){
        return modelMapper.map(src, new TypeToken<List<UserDTO>>(){}.getType());
    }
}
