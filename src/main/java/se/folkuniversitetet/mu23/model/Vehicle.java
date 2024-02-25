package se.folkuniversitetet.mu23.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getters and setters for all member properties
@AllArgsConstructor // One constructor with all the member properties
@NoArgsConstructor
@Entity(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
    private Long id;
    private String name;
    private String type;
}
