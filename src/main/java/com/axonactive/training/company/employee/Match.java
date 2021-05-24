package com.axonactive.training.company.employee;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Match {

    private int id;

    private String name;

    private LocalDateTime startTime;

    private int matchTime;

    private Team team1;

    private int score1;

    private Team team2;

    private int score2;

    public Match() {
    }

    public Match(int id, String name, LocalDateTime startTime, int matchTime, Team team1, int score1, Team team2,
            int score2) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.matchTime = matchTime;
        this.team1 = team1;
        this.score1 = score1;
        this.team2 = team2;
        this.score2 = score2;
    }

    public String toString() {
        return "Match :" + id + ", " + name + ", " + startTime + ", " + matchTime + ", " + team1.getName() + ", "
                + team2.getName() + ", " + score1 + ", " + score2;
    }
}
