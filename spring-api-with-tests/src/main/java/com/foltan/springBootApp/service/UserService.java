package com.foltan.springBootApp.service;

import com.foltan.springBootApp.domain.User;
import com.foltan.springBootApp.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDto dto);
    User update(UserDto dto);
    void deleteById(Integer id);

}
