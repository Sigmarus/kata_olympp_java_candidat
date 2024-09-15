package fr.olympp.kata.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity(name = "army")
public class Army {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column
    private Long clanId;

    @Column(unique = true)
    private String name;

    @Column
    private ArmyCorps armyCorps;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer armyAttack;

    public Integer getArmyAttack() {
        return armyCorps.getAttack() * armyCorps.getNbUnits();
    }

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer armyDefense;

    public Integer getArmyDefense() {
        return armyCorps.getDefense() * armyCorps.getNbUnits();
    }
}
