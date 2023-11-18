package com.gonchaba.crimeservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class PoliceStationResponse {
    private List<PoliceStation> results;

    @Data
    public static class PoliceStation {
        private String formattedAddress;
        private Geometry geometry;

        @Data
        public static class Geometry {
            private Location location;

            @Data
            public static class Location {
                private double lat;
                private double lng;
            }
        }
    }
}

