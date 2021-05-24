package com.axonactive.training.company.employee;

import lombok.val;

public enum Gender {
    MALE(0), FEMALE(1), UNKNOWN(2);

    private int value;

    private Gender(int value) {
        this.value = value;
    }
}