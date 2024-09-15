package fr.olympp.kata.services.impl;

import fr.olympp.kata.models.BattleReport;
import fr.olympp.kata.models.Clan;
import fr.olympp.kata.services.BattleService;
import org.springframework.stereotype.Service;

@Service
public class BattleServiceImpl implements BattleService {

    @Override
    public BattleReport battle(final Clan clan1, final Clan clan2) {
        if (clan1 == null || clan2 == null) return null;
        BattleReport report = new BattleReport();
        Clan clan1_ = clan1;
        Clan clan2_ = clan2;
        //while () {}
        return report;
    }

    private void executeTurn(BattleReport report, Clan clan1, Clan clan2) {
        //TODO
    }
}
