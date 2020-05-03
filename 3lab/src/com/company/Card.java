package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public abstract class Card {
    private UUID id;
    public UUID getId() {
        return id;
    }

    public boolean isPrivileges() {
        return privileges;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    private boolean privileges;//false for usual card, true for preferences
    private boolean active;
    ArrayList<LocalDateTime> accepts=new ArrayList<LocalDateTime>();
    ArrayList<LocalDateTime> declines = new ArrayList<LocalDateTime>();

    public Card(boolean privileges,boolean active) {
        id=UUID.randomUUID();
        this.privileges=privileges;
        this.active=active;
    }

    abstract void GetInfo();

    abstract boolean PassCard();


}
