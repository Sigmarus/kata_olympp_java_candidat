package fr.olympp.kata.repository;

import fr.olympp.kata.models.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Long> {
    Clan getFirstByName(String name);
}
