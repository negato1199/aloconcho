package com.axonactive.training.company.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TeamTest {
    @Test
    public void whenTeamIsValid() {
        Team team = new Team(1, "Team 1", 1);
        for (int i = 0; i < 10; i++)
            team.addPlayer(new Player());
        assertEquals(true, team.checkValid());
    }

    @Test
    public void whenTeamIsOverSize() {
        Team team = new Team(1, "Team 1", 1);
        for (int i = 0; i < 20; i++)
            team.addPlayer(new Player());
        assertEquals(false, team.checkValid());
    }

    @Test
    public void whenTeamIsLessSize() {
        Team team = new Team(1, "Team 1", 1);
        for (int i = 0; i < 5; i++)
            team.addPlayer(new Player());
        assertEquals(false, team.checkValid());
    }

}
