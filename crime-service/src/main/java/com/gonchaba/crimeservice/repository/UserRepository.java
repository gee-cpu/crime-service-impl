package com.gonchaba.crimeservice.repository;

import com.gonchaba.crimeservice.model.MapUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MapUser, Long> {
    MapUser findByUserName(String userName);
}
