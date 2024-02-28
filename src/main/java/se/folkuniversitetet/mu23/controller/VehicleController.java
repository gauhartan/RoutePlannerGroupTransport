package se.folkuniversitetet.mu23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.folkuniversitetet.mu23.model.Group;
import se.folkuniversitetet.mu23.model.Vehicle;
import se.folkuniversitetet.mu23.service.GroupService;
import se.folkuniversitetet.mu23.service.UserService;
import se.folkuniversitetet.mu23.service.VehicleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private VehicleService vehicleService;


    @GetMapping("/group/{id}")
    public List<Vehicle> getVehiclesByGroupId(@PathVariable Long id) {
        Optional<Group> group = groupService.fetchById(id);
        if (group.isPresent()) {
            return group.get().getVehicles();
        }
        return null;
    }

    @PostMapping("/{vehicleId}/group/{groupId}/state")
    public Vehicle setVehicleStateByGroupId(@PathVariable Long vehicleId, @PathVariable Long groupId, @RequestParam Boolean inUse, @RequestParam Integer inUseMinutes) {
        Optional<Group> group = groupService.fetchById(groupId);
        if (group.isPresent()) {
            Optional<Vehicle> vehicle = vehicleService.fetchById(vehicleId);
            if (vehicle.isPresent()) {
                vehicle.get().setInUse(inUse);
                vehicle.get().setInUseMinutes(inUseMinutes);
                vehicleService.update(vehicle.get());
                return vehicle.get();
            }
        }
        return null;
    }
}

