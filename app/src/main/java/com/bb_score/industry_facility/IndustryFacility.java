package com.bb_score.industry_facility;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bb_score.Player;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class IndustryFacility {
    @JsonProperty("type")
    private IndustryFacilityType type;
    @JsonProperty("level")
    private int level;
    @JsonProperty("basePoint")
    private int basePoint;
    @JsonProperty("linkPoint")
    private int linkPoint;
    private Player owner;

    public IndustryFacility() {
    }

    public IndustryFacility(IndustryFacilityType type, int level, int basePoint, int linkPoint) {
        this.type = type;
        this.level = level;
        this.basePoint = basePoint;
        this.linkPoint = linkPoint;
    }

    public IndustryFacilityType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getID() {
        return new StringJoiner("_").add(type.name()).add(String.valueOf(level)).toString();
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndustryFacility that = (IndustryFacility) o;
        return getLevel() == that.getLevel() &&
                getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLevel());
    }

    public int getBasePoint() {
        return basePoint;
    }

    public int getLinkPoint() {
        return linkPoint;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
