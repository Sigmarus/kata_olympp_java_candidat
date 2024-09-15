package fr.olympp.kata.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "clan")
public class Clan implements Serializable {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "clanId")
    private List<Army> armies;
}
