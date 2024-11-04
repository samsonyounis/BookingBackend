package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Builder
public class hotelier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHotelier;
    private String nomHotelier;
}
