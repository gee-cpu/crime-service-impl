package com.gonchaba.crimeservice.repository;

import com.gonchaba.crimeservice.model.MapUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MapUser, Long> {
    MapUser findByUserName(String userName);

    @EntityGraph(attributePaths = "crimes")
    Optional<MapUser> findById(Long id);
}
