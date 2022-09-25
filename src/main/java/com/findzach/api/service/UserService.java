package com.findzach.api.service;

import com.findzach.api.domain.UserLegacy;
import com.findzach.api.v1.model.UserDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
public interface UserService extends CrudRepository<UserLegacy, Long> {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createNewUser(UserDTO userDTO);

    UserDTO saveUserByDTO(Long id, UserDTO userDTO);

    UserDTO patchUser(Long id, UserDTO userDTO);

    void deleteUserById(Long id);
}
