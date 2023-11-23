package com.gonchaba.crimeservice.service;

import com.gonchaba.crimeservice.dto.MapUserDTO;
import com.gonchaba.crimeservice.model.MapUser;
import com.gonchaba.crimeservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public MapUser getUserById(Long userId) {
        Optional<MapUser> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @Override
    public List<MapUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public MapUser createUser(MapUserDTO userDto) {
        MapUser mapUser = MapUser.builder()
                .userName(userDto.getUserName())
                .password(userDto.getPassword()).build();


        return userRepository.save(mapUser);
    }

    @Override
    public boolean loginUser(String userName, String password) {
        MapUser mapUser = userRepository.findByUserName(userName);
        if (mapUser != null && mapUser.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public MapUser updateUser(Long userId, MapUserDTO userDto) {
        Optional<MapUser> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            MapUser existingUser = optionalUser.get();
            existingUser.setUserName(userDto.getUserName());
            existingUser.setPassword(userDto.getPassword());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}


