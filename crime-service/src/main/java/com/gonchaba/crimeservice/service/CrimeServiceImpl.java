package com.gonchaba.crimeservice.service;

import com.gonchaba.crimeservice.dto.CrimeDTO;
import com.gonchaba.crimeservice.dto.PoliceStationResponse;
import com.gonchaba.crimeservice.model.Crime;
import com.gonchaba.crimeservice.model.MapUser;
import com.gonchaba.crimeservice.repository.CrimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Service
public class CrimeServiceImpl implements CrimeService {
    private final CrimeRepository crimeRepository;
    private final WebClient.Builder webClientBuilder;

    public CrimeServiceImpl(CrimeRepository crimeRepository, WebClient.Builder webClientBuilder) {
        this.crimeRepository = crimeRepository;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public void reportCrime(MapUser user, CrimeDTO crimeDTO) {

        Crime crime = new Crime();
        crime.setDescription(crimeDTO.getDescription());
        crime.setLocation(crimeDTO.getLocation());
        crime.setCrimeType(crimeDTO.getCrimeType());
        crime.setEvidence(crimeDTO.getEvidence());
        crime.setWitness(crimeDTO.getWitness());
        crime.setMapUser(user);

        crimeRepository.save(crime);
    }

    @Override
    public List<PoliceStationResponse.PoliceStation> getNearestPoliceStations(double userLat, double userLng) {
        PoliceStationResponse response = webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/places/police-stations?latitude={latitude}&longitude={longitude}", userLat, userLng)
                .retrieve()
                .bodyToMono(PoliceStationResponse.class)
                .block();

        if (response != null && response.getResults() != null) {
            return response.getResults();
        } else {
            return Collections.emptyList();
        }
    }
}
