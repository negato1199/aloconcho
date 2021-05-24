package com.axonactive.training.company.employee;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Schedule {

    private static Schedule instance = null;

    private ArrayList<Match> list;

    private Schedule() {
        list = new ArrayList<Match>();
    }

    public static Schedule getInstance() {
        if (instance == null)
            instance = new Schedule();

        return instance;
    }

    /**
     * Using Round Robin to generate Match for each pair of Team. If number of
     * participants is odd -> add a null team.
     * 
     * @param teamList
     */
    public void makeSchedule(ArrayList<Team> teamList, int matchtime) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Team team : teamList) {
            temp.add(team.getId());
        }
        LocalDateTime time = LocalDateTime.of(2021, 5, 25, 8, 30, 00);
        int numberOfMatch = 0;
        if (temp.size() % 2 == 1) {
            Team dummy = new Team(temp.size() + 1, "Null", temp.size() + 1);
            teamList.add(dummy);
            temp.add(dummy.getId());
        }
        int numberOfRound = temp.size() - 1;
        // Swap array without first element
        for (int i = 0; i < numberOfRound; i++) {
            int team = temp.get(1);
            for (int j = temp.size() - 1; j > 0; j--) {
                if (j == temp.size() - 1) {
                    temp.set(1, temp.get(j));
                } else {
                    temp.set(j + 1, temp.get(j));
                }
            }
            temp.set(2, team);
            numberOfMatch = makeOneRound(numberOfMatch, temp, time, teamList, matchtime);
            time = time.plusMinutes(matchtime + 15);
        }

        for (Match match : list) {
            System.out.println(match.toString());
        }
    }

    /**
     * Get team pair by collecting the 1st element of Array with the last element of
     * Array. Generate Match for each team pair -> add to Schedule
     * 
     * @param numberOfMatch
     * @param temp
     * @param time
     * @param teamList
     * @return
     */
    public int makeOneRound(int numberOfMatch, ArrayList<Integer> temp, LocalDateTime time, ArrayList<Team> teamList,
            int matchtime) {

        int mid = temp.size() / 2;

        for (int i = 0; i < mid; i++) {
            Team t1 = teamList.get(temp.get(i) - 1);
            Team t2 = teamList.get(temp.get(temp.size() - i - 1) - 1);
            Match match = new Match(++numberOfMatch, "Match " + Integer.toString(numberOfMatch), time, matchtime, t1, 0,
                    t2, 0);
            list.add(match);

        }
        return numberOfMatch;

    }

}
