package com.findzach.api.service;

import com.findzach.api.v1.model.UserDTO;

import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createNewUser(UserDTO customerDTO);

    UserDTO saveUserByDTO(Long id, UserDTO customerDTO);

    UserDTO patchUser(Long id, UserDTO customerDTO);

    void deleteUserById(Long id);
}
