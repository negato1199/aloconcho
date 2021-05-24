package com.axonactive.training.company.employee;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player extends Employee{

    private int number;

    private int idTeam;

    public Player() {
        super();
    }

    public Player(int id, String fullName, int age, Gender gender, int idCompany, int number, int idTeam) {
        super(id, fullName, age, gender, idCompany);
        this.number = number;
        this.idTeam = idTeam;
    }
}
    

    
