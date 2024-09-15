package fr.olympp.kata.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity(name = "foot_soldier_troop")
public class FootSoldierTroop implements Serializable {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long Id;

    @OneToOne
    @Column(name = "army_id")
    private Long armyId;

    @Column(name = "nb_units")
    private Integer nbUnits;

    @Column
    private Integer attack;

    @Column
    private Integer defense;

    @Column
    private Integer health;
}
