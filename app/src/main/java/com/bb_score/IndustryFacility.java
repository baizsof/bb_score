package main.java.com.bb_score;

public class IndustryFacility {
    private final IndustryFacilityType type;
    private final int level;
    private final int point;
    private final Player owner;

    public IndustryFacility(IndustryFacilityType type, int level, int point, Player owner) {
        this.type = type;
        this.level = level;
        this.point = point;
        this.owner = owner;
    }

    public IndustryFacilityType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getPoint() {
        return point;
    }

    public Player getOwner() {
        return owner;
    }
}
