package com.example.AlkemyChallenge.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "character_table")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "weight")
    private String weight;

    @Column(name = "history")
    private String history;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            joinColumns = @JoinColumn(name = "character_table_id"),
            inverseJoinColumns = @JoinColumn(name = "movieorseries_id")
    )
    private Set<MovieOrSeries> moviesOrSeries = new HashSet<>();

}
