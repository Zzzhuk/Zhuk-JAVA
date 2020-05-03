package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class Register {
    static ArrayList<Card> register = new ArrayList<Card>();

    public Register() {

    }

    void CreateCard(Card card) {
        card.setActive(true);
        register.add(card);
    }

    void CancelCard(Card card) {
        card.setActive(false);
    }

    void PassInfo(Card card) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Amount of accepts: " + card.accepts.size() + "\n" +
                "Amount of declines: " + card.declines.size() + "\n" + "Accepts: \n");
        for (LocalDateTime elem : card.accepts) {
            System.out.println(elem.format(formatter));
        }
        System.out.println("Declines:\n");
        for (LocalDateTime elem : card.declines) {
            System.out.println(elem.format(formatter));
        }
    }

    void GetInfo(UUID Id) {
        for (Card card : register) {
            if (card.getId() == Id) {
                card.GetInfo();

                break;
            }
        }
    }
}
