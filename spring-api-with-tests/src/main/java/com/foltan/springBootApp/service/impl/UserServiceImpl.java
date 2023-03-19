package com.foltan.springBootApp.service.impl;

import com.foltan.springBootApp.domain.User;
import com.foltan.springBootApp.domain.dto.UserDto;
import com.foltan.springBootApp.service.UserService;
import com.foltan.springBootApp.repository.UserRepository;
import com.foltan.springBootApp.service.exception.DataIntegrityViolationException;
import com.foltan.springBootApp.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDto dto) {
        findByEmail(dto);
        return userRepository.save(mapper.map(dto, User.class));
    }

    @Override
    public User update(UserDto dto) {
        findByEmail(dto);
        return userRepository.save(mapper.map(dto, User.class));
    }

    @Override
    public void deleteById(Integer id) {
        findById(id);
        userRepository.deleteById(id);
    }

    private void findByEmail(UserDto dto) {
        Optional<User> user = userRepository.findByEmail(dto.getEmail());

        if (user.isPresent() && !user.get().getId().equals(dto.getId())) {
            throw new DataIntegrityViolationException("Email already exists");
        }
    }
}
