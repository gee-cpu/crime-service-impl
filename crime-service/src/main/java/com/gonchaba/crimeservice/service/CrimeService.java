package com.gonchaba.crimeservice.service;


import com.gonchaba.crimeservice.dto.CrimeDTO;
import com.gonchaba.crimeservice.dto.PoliceStationResponse;
import com.gonchaba.crimeservice.model.MapUser;

import java.util.List;

public interface CrimeService {
    void reportCrime(MapUser user, CrimeDTO crimeDTO);

    List<PoliceStationResponse.PoliceStation> getNearestPoliceStations(double userLat, double userLng);
}
