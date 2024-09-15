package fr.olympp.kata;

import fr.olympp.kata.models.*;
import fr.olympp.kata.services.BattleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class BattleServiceTest {

    @Autowired
    private BattleService battleService;

    @Test
    void clansWithSameArmiesResultInDraw() {
        Clan clan1 = new Clan();
        clan1.setId(1L);
        clan1.setName("Trojans");
        clan1.setArmies(Arrays.asList(
                new Army(
                        10L,
                        1L,
                        "Army 1-A",
                        new FootSoldierTroop(null, 1L, 100, 20, 10, 10)
                ),
                new Army(
                        11L,
                        1L,
                        "Army 1-B",
                        new FootSoldierTroop(null, 1L, 100, 20, 10, 10)
                )
        ));
        Clan clan2 = new Clan();
        clan2.setId(2L);
        clan2.setName("Greeks");
        clan2.setArmies(Arrays.asList(
                new Army(
                        20L,
                        2L,
                        "Army 2-A",
                        new FootSoldierTroop(null, 2L, 100, 20, 10, 10)
                ),
                new Army(
                        21L,
                        2L,
                        "Army 2-B",
                        new FootSoldierTroop(null, 2L, 100, 20, 10, 10)
                )
        ));
        BattleReport report = battleService.battle(clan1, clan2);

        Assertions.assertEquals(BattleReport.Status.DRAW, report.getStatus());
        Assertions.assertNull(report.getWinner());
        Assertions.assertEquals(clan1, report.getInitialClans().get(0));
        Assertions.assertEquals(clan2, report.getInitialClans().get(1));

        Assertions.assertEquals(2, report.getHistory().size());

        Turn reportTurn1 = report.getHistory().get(0);
        Turn reportTurn2 = report.getHistory().get(1);

        Assertions.assertEquals(clan1.getArmies().get(0).getName(), reportTurn1.getNameArmy1());
        Assertions.assertEquals(clan2.getArmies().get(0).getName(), reportTurn1.getNameArmy2());
        Assertions.assertEquals(1000, reportTurn1.getDamageArmy1());
        Assertions.assertEquals(1000, reportTurn1.getDamageArmy2());
        Assertions.assertEquals(0, reportTurn1.getRemainingSoldiersArmy1());
        Assertions.assertEquals(0, reportTurn1.getRemainingSoldiersArmy2());
    }
}
