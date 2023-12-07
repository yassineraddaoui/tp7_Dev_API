package com.example.tp7.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "properties")

public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "price", nullable = false)
    private double price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "property", cascade = CascadeType.ALL)
    Set<RentalContract> contracts=new HashSet<>();



}
