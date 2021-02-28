package main.java.com.bb_score;

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
