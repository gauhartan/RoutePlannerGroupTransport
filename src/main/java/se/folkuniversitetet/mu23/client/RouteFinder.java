package se.folkuniversitetet.mu23.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class RouteFinder {
    public List<RouteResponse> getRoute(String endpointUrl, Places from, Places to, String transportMethod) {
        log.info("Sending request to microservice1");
        WebClient webClient = WebClient.builder().build();
        Mono<List<RouteResponse>> response = webClient
                .get()
                .uri(endpointUrl, uriBuilder -> uriBuilder
                        .path("/{from}/{to}/{transportMethod}")
                        .build(from, to, transportMethod))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<RouteResponse>>() {
                });

        List<RouteResponse> respList = response.block();
        log.info("Received response from microservice1");
        return respList.stream()
                .collect(Collectors.toList());
    }
}
