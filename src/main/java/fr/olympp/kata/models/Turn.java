package fr.olympp.kata.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Turn implements Serializable {
    private String nameArmy1;
    private String nameArmy2;
    private int damageArmy1;
    private int damageArmy2;
    private int remainingSoldiersArmy1;
    private int remainingSoldiersArmy2;
}
