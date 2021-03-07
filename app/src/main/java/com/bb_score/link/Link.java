package com.bb_score.link;

import com.bb_score.Element;
import com.bb_score.Player;

public class Link implements Element {
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

    @Override
    public String getID() {
        return id;
    }
}
