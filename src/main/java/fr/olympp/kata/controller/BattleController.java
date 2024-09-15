package fr.olympp.kata.controller;

import fr.olympp.kata.models.BattleReport;
import fr.olympp.kata.models.Clan;
import fr.olympp.kata.services.BattleService;
import fr.olympp.kata.services.ClanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/battles")
public class BattleController {
  private final BattleService battleService;
  private final ClanService clanServices;

  @GetMapping
  public BattleReport battle() throws IllegalArgumentException {
    List<Clan> clans = this.clanServices.getClans();
    if (clans.size() < 2) throw new IllegalArgumentException("Must have at least 2 clans, got " + clans.size());
    return this.battleService.battle(clans.get(0), clans.get(1));
  }
}
