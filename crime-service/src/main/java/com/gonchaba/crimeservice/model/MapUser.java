package com.gonchaba.crimeservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class MapUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @OneToMany(mappedBy = "mapUser", fetch = FetchType.EAGER)
    private List<Crime> crimes;
}
