package com.company;

public class NumberCard extends Card {
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;

    public NumberCard(int number, boolean privileges) {
        super(privileges, false);
        this.number = number;
    }

    @Override
    public void GetInfo() {
        System.out.println(this.isActive() ? "Status: active" : "Status: disabled");

        System.out.println("Type: Card on number of trips \n" +
                "ID: " + this.getId() + "\n" +
                "Privelege: " + this.isPrivileges() + "\n" +
                "Number of trips left: " + this.number + "\n");


    }

    @Override
    public boolean PassCard() {
        if (number >= 1) {
            number = number - 1;
            System.out.println("Passage allowed!");
            return true;
        } else {
            System.out.println("Passage is forbidden! You have run out of trips");
            return false;
        }

    }
}
