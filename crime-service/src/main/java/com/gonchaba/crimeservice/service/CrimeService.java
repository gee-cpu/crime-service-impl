package com.gonchaba.crimeservice.service;


import com.gonchaba.crimeservice.dto.CrimeDTO;
import com.gonchaba.crimeservice.dto.PoliceStationResponse;
import com.gonchaba.crimeservice.model.Crime;
import com.gonchaba.crimeservice.model.MapUser;

import java.util.List;
import java.util.Optional;

public interface CrimeService {
    void reportCrime(MapUser user, CrimeDTO crimeDTO);

    Optional<Crime> getCrimesByUserId(Long userId);

    List<PoliceStationResponse.PoliceStation> getNearestPoliceStations(double userLat, double userLng);
}
