package com.axonactive.training.company.employee;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScheduleTest {

        // private static ArrayList<Team> teamList;
        // private static ArrayList<Team> teamList1;

        // @BeforeAll
        // private static void getInit() {
        // Team team1 = new Team(1, "Team 1", 1);
        // Team team2 = new Team(2, "Team 2", 2);
        // Team team3 = new Team(3, "Team 3", 3);
        // Team team4 = new Team(4, "Team 4", 4);
        // Team team5 = new Team(4, "Null", 4);
        // teamList = new ArrayList<>(Arrays.asList(team1, team2, team3, team4));
        // teamList1 = new ArrayList<>(Arrays.asList(team1, team2, team3, team5));
        // }

        @BeforeEach
        public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException,
                        IllegalAccessException {
                Field instance = Schedule.class.getDeclaredField("instance");
                instance.setAccessible(true);
                instance.set(null, null);
        }

        @Test
        public void whenGenerateScheduleWithEvenParticipants() {
                Team team1 = new Team(1, "Team 1", 1);
                Team team2 = new Team(2, "Team 2", 2);
                Team team3 = new Team(3, "Team 3", 3);
                Team team4 = new Team(4, "Team 4", 4);
                ArrayList<Team> teamList = new ArrayList<>(Arrays.asList(team1, team2, team3, team4));
                ArrayList<Match> expectedEvenParticipants = new ArrayList<>(Arrays.asList(
                                new Match(1, "Match 1", LocalDateTime.of(2021, 5, 25, 8, 30, 00), 60, teamList.get(0),
                                                0, teamList.get(2), 0),
                                new Match(2, "Match 2", LocalDateTime.of(2021, 5, 25, 8, 30, 00), 60, teamList.get(3),
                                                0, teamList.get(1), 0),
                                new Match(3, "Match 3", LocalDateTime.of(2021, 5, 25, 9, 45, 00), 60, teamList.get(0),
                                                0, teamList.get(1), 0),
                                new Match(4, "Match 4", LocalDateTime.of(2021, 5, 25, 9, 45, 00), 60, teamList.get(2),
                                                0, teamList.get(3), 0),
                                new Match(5, "Match 5", LocalDateTime.of(2021, 5, 25, 11, 00, 00), 60, teamList.get(0),
                                                0, teamList.get(3), 0),
                                new Match(6, "Match 6", LocalDateTime.of(2021, 5, 25, 11, 00, 00), 60, teamList.get(1),
                                                0, teamList.get(2), 0)));

                Schedule.getInstance().makeSchedule(teamList, 60);
                ArrayList<Match> actualEvenParticipants = Schedule.getInstance().getList();
                assertArrayEquals(expectedEvenParticipants.toArray(), actualEvenParticipants.toArray());
        }

        @Test
        public void whenGenerateScheduleWithOddParticipants() {
                Team team1 = new Team(1, "Team 1", 1);
                Team team2 = new Team(2, "Team 2", 2);
                Team team3 = new Team(3, "Team 3", 3);
                Team dummy = new Team(4, "Null", 4);
                ArrayList<Team> teamList = new ArrayList<>(Arrays.asList(team1, team2, team3, dummy));
                ArrayList<Team> teamList1 = new ArrayList<>(Arrays.asList(team1, team2, team3));
                ArrayList<Match> expectedOddParticipants = new ArrayList<>(Arrays.asList(
                                new Match(1, "Match 1", LocalDateTime.of(2021, 5, 25, 8, 30, 00), 60, teamList.get(0),
                                                0, teamList.get(2), 0),
                                new Match(2, "Match 2", LocalDateTime.of(2021, 5, 25, 8, 30, 00), 60, teamList.get(3),
                                                0, teamList.get(1), 0),
                                new Match(3, "Match 3", LocalDateTime.of(2021, 5, 25, 9, 45, 00), 60, teamList.get(0),
                                                0, teamList.get(1), 0),
                                new Match(4, "Match 4", LocalDateTime.of(2021, 5, 25, 9, 45, 00), 60, teamList.get(2),
                                                0, teamList.get(3), 0),
                                new Match(5, "Match 5", LocalDateTime.of(2021, 5, 25, 11, 00, 00), 60, teamList.get(0),
                                                0, teamList.get(3), 0),
                                new Match(6, "Match 6", LocalDateTime.of(2021, 5, 25, 11, 00, 00), 60, teamList.get(1),
                                                0, teamList.get(2), 0)));

                Schedule.getInstance().makeSchedule(teamList1, 60);
                ArrayList<Match> actualOddParticipants = Schedule.getInstance().getList();
                assertArrayEquals(expectedOddParticipants.toArray(), actualOddParticipants.toArray());
        }
}
