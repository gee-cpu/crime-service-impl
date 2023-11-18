package com.gonchaba.crimeservice.controller;

import com.gonchaba.crimeservice.dto.CrimeDTO;
import com.gonchaba.crimeservice.dto.PoliceStationResponse;
import com.gonchaba.crimeservice.model.MapUser;
import com.gonchaba.crimeservice.service.CrimeService;
import com.gonchaba.crimeservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crimes")
public class CrimeController {

    private final CrimeService crimeService;

    private final UserService userService;

    public CrimeController(CrimeService crimeService, UserService userService) {
        this.crimeService = crimeService;
        this.userService = userService;
    }

    @GetMapping("/nearest-police-stations")
    public ResponseEntity<List<PoliceStationResponse.PoliceStation>> getNearestPoliceStations(
            @RequestParam double userLat,
            @RequestParam double userLng
    ) {
        var nearestPoliceStations = crimeService.getNearestPoliceStations(userLat, userLng);
        return ResponseEntity.ok(nearestPoliceStations);
    }

    @PostMapping("/report")
    public ResponseEntity<String> reportCrime(
            @RequestBody CrimeDTO crimeDTO,
            @RequestParam Long userId
    ) {
        MapUser user = userService.getUserById(userId);

        if (user != null) {
            crimeService.reportCrime(user, crimeDTO);
            return ResponseEntity.ok("Crime reported successfully.");
        } else {
            return ResponseEntity.badRequest().body("User not found.");
        }
    }


}
