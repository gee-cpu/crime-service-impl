package com.gonchaba.crimeservice.service;

import com.gonchaba.crimeservice.config.WebClientConfig;
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

    private final WebClientConfig config;

    public CrimeServiceImpl(CrimeRepository crimeRepository, WebClient.Builder webClientBuilder, WebClientConfig config) {
        this.crimeRepository = crimeRepository;
        this.webClientBuilder = webClientBuilder;
        this.config = config;
    }

    @Override
    public void reportCrime(MapUser user, CrimeDTO crimeDTO) {

        Crime crime = Crime.builder().description(crimeDTO.getDescription()).location(crimeDTO.getLocation()).crimeType(crimeDTO.getCrimeType()).evidence(crimeDTO.getEvidence()).witness(crimeDTO.getWitness()).build();
        crime.setMapUser(user);

        crimeRepository.save(crime);
    }

    @Override
    public List<PoliceStationResponse.PoliceStation> getNearestPoliceStations(double userLat, double userLng) {
        PoliceStationResponse response = webClientBuilder.build().get().uri(config.getUri(), userLat, userLng).retrieve().bodyToMono(PoliceStationResponse.class).block();

        if (response != null && response.getResults() != null) {
            return response.getResults();
        } else {
            return Collections.emptyList();
        }
    }
}
