package com.gonchaba.crimeservice.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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






