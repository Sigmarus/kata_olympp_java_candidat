package fr.olympp.kata.services.impl;

import fr.olympp.kata.models.Army;
import fr.olympp.kata.models.Clan;
import fr.olympp.kata.repository.ArmyRepository;
import fr.olympp.kata.repository.ClanRepository;
import fr.olympp.kata.services.ClanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClanServiceImpl implements ClanService {

    private final ClanRepository clanRepository;
    private final ArmyRepository armyRepository;

    @Override
    public Clan getClan(String clanName) {
        return clanRepository.getFirstByName(clanName);
    }

    @Override
    public List<Clan> getClans() {
        return clanRepository.findAll();
    }

    @Override
    public void addArmy(String clanName, Army army) {
        Clan clan = clanRepository.getFirstByName(clanName);
        army.setClanId(clan.getId());
        armyRepository.save(army);
    }

    @Override
    public void removeArmy(String clanName, String armyName) {
        Clan clan = clanRepository.getFirstByName(clanName);
        Army army = armyRepository.findByClanIdAndName(clan.getId(), armyName);
        armyRepository.delete(army);
    }
}
