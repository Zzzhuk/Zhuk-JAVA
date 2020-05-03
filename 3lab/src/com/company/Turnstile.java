package com.company;

import java.time.LocalDateTime;

public class Turnstile {
    public Turnstile() {
    }


    void Warn(Card card) {
        if (card.isPrivileges()) {
            System.out.println("Check documents!");
        }
    }

    public boolean PassCard(Card card) {
        boolean check = false;
        for (Card elem : Register.register) {
            if (elem.getId() == card.getId()) {
                check = true;
                break;
            }
        }
        if (check) {
            if (card.isActive()) {

                if (card.PassCard()) {
                    Warn(card);
                    card.accepts.add(LocalDateTime.now());
                    return true;
                } else {
                    card.declines.add(LocalDateTime.now());
                }
            } else {
                System.out.println("Passage is forbidden! Your card is unactive!");
                card.declines.add(LocalDateTime.now());
            }
        } else {
            System.out.println("Passage is forbidden! This card isn't registered!");
            card.declines.add(LocalDateTime.now());
        }

        return false;
    }
}
