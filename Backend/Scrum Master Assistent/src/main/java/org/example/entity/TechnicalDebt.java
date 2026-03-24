package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // This requires the Lombok dependency in pom.xml
public class TechnicalDebt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Fixed the syntax here
    private Long id;

    private String issueType;
    private String severity;

    @Column(length = 1000)
    private String description;
}