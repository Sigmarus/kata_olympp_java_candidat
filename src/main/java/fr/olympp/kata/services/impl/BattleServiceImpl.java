package fr.olympp.kata.services.impl;

import fr.olympp.kata.models.Army;
import fr.olympp.kata.models.BattleReport;
import fr.olympp.kata.models.Clan;
import fr.olympp.kata.models.Turn;
import fr.olympp.kata.services.BattleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class BattleServiceImpl implements BattleService {

    @Override
    public BattleReport battle(final Clan clan1, final Clan clan2) {
        BattleReport report = new BattleReport();
        report.setHistory(new ArrayList<>());
        report.setInitialClans(Arrays.asList(clan1, clan2));
        if (clan1 == null || clan2 == null) return report;
        while (!clan1.getArmies().isEmpty() && !clan2.getArmies().isEmpty()) {
            executeTurn(report, clan1, clan2);
        }
        if (clan1.getArmies().isEmpty() && clan2.getArmies().isEmpty()) {
            report.setStatus(BattleReport.Status.DRAW);
        } else if (!clan1.getArmies().isEmpty()) {
            report.setStatus(BattleReport.Status.ARMY1_WIN);
            report.setWinner(clan1.getName());
        } else {
            report.setStatus(BattleReport.Status.ARMY2_WIN);
            report.setWinner(clan2.getName());
        }
        return report;
    }

    private void executeTurn(BattleReport report, Clan clan1, Clan clan2) {
        Army army1 = clan1.getArmies().get(0);
        Army army2 = clan2.getArmies().get(0);
        int attackArmy1 = army1.getArmyCorps().getNbUnits() * army1.getArmyCorps().getAttack();
        int attackArmy2 = army2.getArmyCorps().getNbUnits() * army2.getArmyCorps().getAttack();
        int defenseArmy1 = army1.getArmyCorps().getNbUnits() * army1.getArmyCorps().getDefense();
        int defenseArmy2 = army2.getArmyCorps().getNbUnits() * army2.getArmyCorps().getDefense();
        int damageToArmy1 = attackArmy2 - defenseArmy1;
        int damageToArmy2 = attackArmy1 - defenseArmy2;
        int soldiersLostByArmy1 = damageToArmy1 / army1.getArmyCorps().getHealth();
        int soldiersLostByArmy2 = damageToArmy2 / army2.getArmyCorps().getHealth();
        int remainingSoldiersArmy1 = army1.getArmyCorps().getNbUnits() - soldiersLostByArmy1;
        int remainingSoldiersArmy2 = army2.getArmyCorps().getNbUnits() - soldiersLostByArmy2;
        if (remainingSoldiersArmy1 <= 0) {
            clan1.getArmies().remove(army1);
        } else {
            army1.getArmyCorps().setNbUnits(remainingSoldiersArmy1);
        }
        if (remainingSoldiersArmy2 <= 0) {
            clan2.getArmies().remove(army2);
        } else {
            army2.getArmyCorps().setNbUnits(remainingSoldiersArmy2);
        }
        report.getHistory().add(new Turn(
                army1.getName(),
                army2.getName(),
                damageToArmy1,
                damageToArmy2,
                remainingSoldiersArmy1,
                remainingSoldiersArmy2
        ));
    }
}
