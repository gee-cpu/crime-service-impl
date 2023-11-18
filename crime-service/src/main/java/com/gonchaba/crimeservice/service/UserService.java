package com.gonchaba.crimeservice.service;


import com.gonchaba.crimeservice.dto.MapUserDTO;
import com.gonchaba.crimeservice.model.MapUser;

import java.util.List;

public interface UserService {


    MapUser getUserById(Long userId);

    List<MapUser> getAllUsers();

    MapUser createUser(MapUserDTO userDTO);

    boolean loginUser(String userName, String password);

    MapUser updateUser(Long userId, MapUserDTO userDto);

    void deleteUser(Long userId);
}
