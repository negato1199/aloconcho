package com.axonactive.training.company.employee;

import java.util.ArrayList;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class Elemination {

    public static void tournamentGenerator() {
        for (int i = 0; i < teamList.size(); i++) {
            System.out.println("Match " + ": " + teamList.get(i) + " VS " + teamList.get(++i));
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> teamList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            teamList.add(i);
        }

        tournamentGenerator();

    }
}
