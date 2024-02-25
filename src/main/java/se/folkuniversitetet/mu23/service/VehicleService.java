package se.folkuniversitetet.mu23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.folkuniversitetet.mu23.model.Vehicle;
import se.folkuniversitetet.mu23.repository.VehicleRepository;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Optional<Vehicle> fetchById(Long id) {
        return vehicleRepository.findById(id);
    }
}
