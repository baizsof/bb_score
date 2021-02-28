package main.java.com.bb_score;

public class IndustryFacility {
    private final IndustryFacilityType type;
    private final int level;
    private final int basePoint;
    private final int linkPoint;
    private final Player owner;

    public IndustryFacility(IndustryFacilityType type, int level, int basePoint, int linkPoint, Player owner) {
        this.type = type;
        this.level = level;
        this.basePoint = basePoint;
        this.linkPoint = linkPoint;
        this.owner = owner;
    }

    public IndustryFacilityType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getBasePoint() {
        return basePoint;
    }

    public int getLinkPoint() {
        return linkPoint;
    }

    public Player getOwner() {
        return owner;
    }
}
