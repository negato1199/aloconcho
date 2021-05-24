package com.axonactive.training.company.employee;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Team {

    private int id;

    private String name;

    private int capacity = 0;

    private int idCompany;

    private List<Player> playerList;

    public Team() {
    }

    public Team(int id, String name, int idCompany) {
        this.id = id;
        this.name = name;
        this.idCompany = idCompany;
        this.playerList = new ArrayList<Player>();
    }

    public void setTeam(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.idCompany = team.getIdCompany();
        this.playerList = team.getPlayerList();
    }

    public void addPlayer(Player player) {
        playerList = new ArrayList<Player>();
        playerList.add(player);
        this.capacity++;
    }

    public boolean checkValid() {
        return (capacity >= 7 && capacity <= 12) ? true : false;
    }

    public String toString() {
        return "Team : " + id + ", " + name + ", " + capacity;
    }

}
