package com.findzach.api.service.impl;

import com.findzach.api.controller.v1.UserController;
import com.findzach.api.domain.UserLegacy;
import com.findzach.api.repository.UserLegacyRepository;
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
    private final UserLegacyRepository userLegacyRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserLegacyRepository userLegacyRepository) {
        this.userMapper = userMapper;
        this.userLegacyRepository = userLegacyRepository;
    }


    @Override
    public List<UserDTO> getAllUsers() {
        return userLegacyRepository.findAll()
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
    public <S extends UserLegacy> S save(S s) {
        return userLegacyRepository.save(s);
    }

    @Override
    public <S extends UserLegacy> Iterable<S> saveAll(Iterable<S> iterable) {
        return userLegacyRepository.saveAll(iterable);
    }

    @Override
    public Optional<UserLegacy> findById(Long aLong) {
        return userLegacyRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return userLegacyRepository.existsById(aLong);
    }

    @Override
    public Iterable<UserLegacy> findAll() {
        return userLegacyRepository.findAll();
    }

    @Override
    public Iterable<UserLegacy> findAllById(Iterable<Long> iterable) {
        return userLegacyRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return userLegacyRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        userLegacyRepository.deleteById(aLong);
    }

    @Override
    public void delete(UserLegacy userLegacy) {
        userLegacyRepository.delete(userLegacy);
    }

    @Override
    public void deleteAll(Iterable<? extends UserLegacy> iterable) {
        userLegacyRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        userLegacyRepository.deleteAll();
    }
}
