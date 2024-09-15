package fr.olympp.kata.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity(name = "clan")
public class Clan {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column
    private String name;

    @JoinColumn(name = "clanId")
    private List<Army> armies;
}
