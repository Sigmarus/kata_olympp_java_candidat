package fr.olympp.kata.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity(name = "army")
public class Army implements Serializable {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @OneToOne
    @Column(name = "clan_id")
    private Long clanId;

    @Column(unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "armyId")
    private FootSoldierTroop armyCorps;

    public Integer getArmyAttack() {
        return armyCorps.getAttack() * armyCorps.getNbUnits();
    }

    public Integer getArmyDefense() {
        return armyCorps.getDefense() * armyCorps.getNbUnits();
    }
}
