package se.folkuniversitetet.mu23.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // getters and setters for all member properties
@AllArgsConstructor // One constructor with all the member properties
@NoArgsConstructor
@Entity(name = "grupp")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupp_seq")
    private Long id;
    private String name;
    private String type;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;
}
