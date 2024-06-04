package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.UserRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.UserResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.User;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.repositories.UserRepository;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.IUserService;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers.UserMapper;
import com.riwi.filtro.hector.filtro_riwi_hector.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService  implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        User savedUser = userRepository.save(user);

        return userMapper.toUserResponse(savedUser);
    }


    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
    Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::toUserResponse);
    }

    @Override
    public Optional<UserResponse> getById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) throw new IdNotFoundException("USER", id);

        return user.map(userMapper::toUserResponse);
    }

    @Override
    public UserResponse update(UserRequest userRequest, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("USER", id));
        userMapper.updateFromUserRequest(userRequest, user);

        User userSaved = userRepository.save(user);
        return userMapper.toUserResponse(userSaved);
    }
}
