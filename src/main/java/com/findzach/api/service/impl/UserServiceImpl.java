package com.findzach.api.service.impl;

import com.findzach.api.repository.UserRepository;
import com.findzach.api.service.UserService;
import com.findzach.api.v1.mapper.UserMapper;
import com.findzach.api.v1.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public UserDTO createNewUser(UserDTO customerDTO) {
        return null;
    }

    @Override
    public UserDTO saveUserByDTO(Long id, UserDTO customerDTO) {
        return null;
    }

    @Override
    public UserDTO patchUser(Long id, UserDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
