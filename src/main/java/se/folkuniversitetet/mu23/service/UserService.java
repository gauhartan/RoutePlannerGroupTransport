package se.folkuniversitetet.mu23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.folkuniversitetet.mu23.model.User;
import se.folkuniversitetet.mu23.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> fetchById(Long id) {
        return userRepository.findById(id);
    }
}
