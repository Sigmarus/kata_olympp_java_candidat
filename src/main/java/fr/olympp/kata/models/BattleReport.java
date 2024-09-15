package fr.olympp.kata.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BattleReport {

    public enum Status {
        DRAW,
        ARMY1_WIN,
        ARMY2_WIN
    }

    private String winner;

    private Status status;

    private List<Clan> initialClans;

    private List<Turn> history;
}
