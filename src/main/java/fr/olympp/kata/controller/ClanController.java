package fr.olympp.kata.controller;

import fr.olympp.kata.models.Army;
import fr.olympp.kata.models.Clan;
import fr.olympp.kata.services.ClanService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clans")
public class ClanController {
  private final ClanService clanService;

  @GetMapping
  public List<Clan> getClans() {
    return this.clanService.getClans();
  }

  @GetMapping("/{clanName}")
  public Clan getClan(@PathVariable String clanName) {
    return this.clanService.getClan(clanName);
  }

  @Transactional
  @PostMapping("/{clanName}/armies")
  public void addArmy(@PathVariable String clanName, @RequestBody Army army) {
    this.clanService.addArmy(clanName, army);
  }

  @Transactional
  @DeleteMapping("/{clanName}/armies/{armyName}")
  public void removeArmy(@PathVariable String clanName, @PathVariable String armyName) {
    this.clanService.removeArmy(clanName, armyName);
  }
}
