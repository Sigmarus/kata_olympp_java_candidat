package fr.olympp.kata.models;

import lombok.Data;

@Data
public abstract class ArmyCorps {
    protected int nbUnits;
    protected int attack;
    protected int defense;
    protected int health;
}
