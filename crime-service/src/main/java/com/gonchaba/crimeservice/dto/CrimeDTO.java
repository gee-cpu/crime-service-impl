package com.gonchaba.crimeservice.dto;

import lombok.Data;

@Data
public class CrimeDTO {

    private String crimeType;
    private String description;
    private String location;
    private String evidence;
    private String witness;
}
