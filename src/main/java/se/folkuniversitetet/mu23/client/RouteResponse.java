package se.folkuniversitetet.mu23.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getters and setters for all member properties
@AllArgsConstructor // One constructor with all the member properties
@NoArgsConstructor

public class RouteResponse {
    private Long id;
    private String name;
    private String streetName;
    private int distance;
    private int duration;
    private String methodOfTransport;
    private String weather;
}
