package com.bb_score.link;

import main.com.bb_score.Player;

public class Link {
    private final String id;
    private Player owner;

    public Link(String id, Player owner) {
        this.id = id;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
