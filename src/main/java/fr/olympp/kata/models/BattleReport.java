package fr.olympp.kata.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class BattleReport implements Serializable {

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
