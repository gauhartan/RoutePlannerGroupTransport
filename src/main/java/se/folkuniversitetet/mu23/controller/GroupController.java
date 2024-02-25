package se.folkuniversitetet.mu23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.folkuniversitetet.mu23.model.Group;
import se.folkuniversitetet.mu23.model.User;
import se.folkuniversitetet.mu23.model.Vehicle;
import se.folkuniversitetet.mu23.service.GroupService;
import se.folkuniversitetet.mu23.service.UserService;
import se.folkuniversitetet.mu23.service.VehicleService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public Group createGroup(@RequestParam String name, @RequestParam String type) {
        Group group = new Group();
        group.setName(name);
        group.setType(type);
        return groupService.create(group);
    }

    @PostMapping(value = "/add/user")
    public Group addUserToGroup(@RequestParam Long groupId, @RequestParam Long userId) {
        Optional<Group> group = groupService.fetchById(groupId);
        if (group.isPresent()) {
            Optional<User> user = userService.fetchById(userId);
            group.get().getUsers().add(user.get());
            groupService.update(group.get());
        }
        return group.get();
    }

    @PostMapping(value = "/add/vehicle")
    public Group addVehicleToGroup(@RequestParam Long groupId, @RequestParam Long vehicleId) {
        Optional<Group> group = groupService.fetchById(groupId);
        if (group.isPresent()) {
            Optional<Vehicle> vehicle = vehicleService.fetchById(vehicleId);
            group.get().getVehicles().add(vehicle.get());
            groupService.update(group.get());
        }
        return group.get();
    }

    @DeleteMapping(value = "/delete/vehicle")
    public Group deleteVehicleFromGroup(@RequestParam Long groupId, @RequestParam Long vehicleId) {
        Optional<Group> group = groupService.fetchById(groupId);
        if (group.isPresent()) {
            Optional<Vehicle> vehicle = vehicleService.fetchById(vehicleId);
            group.get().getVehicles().remove(vehicle.get());
            groupService.update(group.get());
        }
        return group.get();
    }
}

