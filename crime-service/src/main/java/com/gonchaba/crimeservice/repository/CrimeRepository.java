package com.gonchaba.crimeservice.repository;

import com.gonchaba.crimeservice.model.Crime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeRepository extends JpaRepository<Crime, Long> {
}
