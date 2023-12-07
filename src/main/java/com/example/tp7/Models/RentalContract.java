package com.example.tp7.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "rental_contract")

public class RentalContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "contact_information", nullable = false)
    private double contactInformation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_user", nullable=false)
    @JsonIgnore
    private Owner owner;

}
