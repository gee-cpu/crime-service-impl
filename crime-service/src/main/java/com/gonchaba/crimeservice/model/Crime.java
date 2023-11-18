package com.gonchaba.crimeservice.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Crime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String location;
    private String crimeType;
    private String evidence;
    private String witness;
    @ManyToOne
    private MapUser mapUser;


}






