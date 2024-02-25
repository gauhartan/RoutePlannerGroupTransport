package se.folkuniversitetet.mu23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.folkuniversitetet.mu23.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
