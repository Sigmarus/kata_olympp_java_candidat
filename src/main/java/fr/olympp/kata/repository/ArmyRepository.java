package fr.olympp.kata.repository;

import fr.olympp.kata.models.Army;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmyRepository extends JpaRepository<Army, Long> {
    Army findByClanIdAndName(Long clanId, String armyName);
}
