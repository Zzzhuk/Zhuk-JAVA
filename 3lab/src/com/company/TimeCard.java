package com.company;

import java.time.LocalDate;

public class TimeCard extends Card {
    public LocalDate getFinalDay() {
        return finalDay;
    }

    private LocalDate finalDay;

    public TimeCard(int period, boolean privileges) {//period1 for 1 day,2 for 1 week, 3 for 1 month
        super(privileges, false);
        switch (period) {
            default:
                this.finalDay = LocalDate.now().plusDays(1);
                break;
            case 2:
                this.finalDay = LocalDate.now().plusWeeks(1);
                break;
            case 3:
                this.finalDay = LocalDate.now().plusMonths(1);
                break;
        }

    }

    public TimeCard(int period, boolean privileges, LocalDate date) {//period1 for 1 day,2 for 1 week, 3 for 1 month
        super(privileges, false);
        switch (period) {
            case 2:
                this.finalDay = date.plusWeeks(1);
                break;
            case 3:
                this.finalDay = date.plusMonths(1);
                break;
            default:
                this.finalDay = date.plusDays(1);
                break;
        }

    }

    @Override
    public void GetInfo() {
        System.out.println(this.isActive() ? "Status: active" : "Status: disabled");

        System.out.println("Type: Card on time duration \n" +
                "ID: " + this.getId() + "\n" +
                "Privelege: " + this.isPrivileges() + "\n" +
                "Day of deactivation: " + this.finalDay + "\n");
    }

    @Override
    public boolean PassCard() {
        if ((finalDay.isAfter(LocalDate.now()))) {
            System.out.println("Passage allowed!");
            return true;
        } else {
            System.out.println("Passage is forbidden! Your card is overdue!");
        }
        return false;
    }
}
