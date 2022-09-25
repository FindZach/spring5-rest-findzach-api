package com.findzach.api.service.impl;

import com.findzach.api.controller.v1.UserController;
import com.findzach.api.domain.User;
import com.findzach.api.repository.UserRepository;
import com.findzach.api.service.UserService;
import com.findzach.api.v1.mapper.UserMapper;
import com.findzach.api.v1.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserDTO userDTO = userMapper.userToUserDTO(user);
                    userDTO.setUserUrl(getUserURL(user.getId()));
                    return userDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO saveUserByDTO(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO patchUser(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    private String getUserURL(Long id) {
        return UserController.BASE_URL + "/" + id;
    }

    @Override
    public <S extends User> S save(S s) {
        return userRepository.save(s);
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return userRepository.saveAll(iterable);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return userRepository.existsById(aLong);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> iterable) {
        return userRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteAll(Iterable<? extends User> iterable) {
        userRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
