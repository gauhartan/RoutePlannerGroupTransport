package se.folkuniversitetet.mu23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.folkuniversitetet.mu23.model.Group;
import se.folkuniversitetet.mu23.repository.GroupRepository;

import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group create(Group group) {
        return groupRepository.save(group);
    }

    public Optional<Group> fetchById(Long id) {
        return groupRepository.findById(id);
    }

    public Group update(Group group) {
        return groupRepository.save(group);
    }
}
