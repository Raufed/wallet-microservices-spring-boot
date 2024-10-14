package by.raufpayzov.repository;

import by.raufpayzov.entity.Piggy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiggyRepository extends JpaRepository<Piggy, Long> {
}
