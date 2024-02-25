package se.folkuniversitetet.mu23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.folkuniversitetet.mu23.model.Group;
import se.folkuniversitetet.mu23.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
