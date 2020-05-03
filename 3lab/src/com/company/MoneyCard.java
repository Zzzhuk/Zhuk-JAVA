package com.company;

public class MoneyCard extends Card {

    public static int getPassPrice() {
        return passPrice;
    }

    public static void setPassPrice(int passPrice) {
        MoneyCard.passPrice = passPrice;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private static int passPrice = 8;
    private int money;

    public MoneyCard(int money) {
        super(false, false);
        this.money = money;

    }

    @Override
    public void GetInfo() {
        System.out.println(this.isActive() ? "Status: active" : "Status: disabled");

        System.out.println("Type: Card on money amount \n" +
                "ID: " + this.getId() + "\n" +
                "Money left: " + this.getMoney() + "\n" + this.getPassPrice());

    }

    @Override
    public boolean PassCard() {
        if (money >= passPrice) {
            money = money - passPrice;
            System.out.println("Passage allowed!");
            return true;
        } else {
            System.out.println("Passage is forbidden! Not enough money");
            return false;
        }

    }
}
