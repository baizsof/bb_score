package com.bb_score.location;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bb_score.Player;
import com.bb_score.exception.NoMoreIndustryFacilityPlaceAtLocationException;
import com.bb_score.exception.NoOwnerAssignedException;
import com.bb_score.industry_facility.IndustryFacility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Location {
    @JsonProperty("name")
    private String name;
    @JsonProperty("slots")
    private String[][] slots;

    private int currentNumberOfIndustryFacility = 0;
    private final Set<IndustryFacility> industryFacilities = new HashSet<>();

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }



    public Map<Player, Integer> calculateLinkPoints() {
        throw new UnsupportedOperationException();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<Player, Integer> calculateBasePoints() {
        HashMap<Player, Integer> baseScores = new HashMap<>();
        for (IndustryFacility industryFacility : industryFacilities) {
            Player key = industryFacility.getOwner().get();
            Optional<Integer> oldScore = Optional.ofNullable(baseScores.get(key));
            oldScore = Optional.of(oldScore.orElse(0));
            baseScores.put(key, oldScore.get() + industryFacility.getBasePoint());
        }
        return baseScores;
    }

    public String getName() {
        return name;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addIndustryFacility(IndustryFacility facility) throws NoMoreIndustryFacilityPlaceAtLocationException, NoOwnerAssignedException {
        if (facility.getOwner().equals(Optional.empty())) {
            throw new NoOwnerAssignedException();
        }
        if (currentNumberOfIndustryFacility < getMaxNumberOfIndustryFacility()) {
            industryFacilities.add(facility);
            currentNumberOfIndustryFacility++;
        } else {
            throw new NoMoreIndustryFacilityPlaceAtLocationException();
        }
    }

    public Set<IndustryFacility> getIndustryFacilities() {
        return industryFacilities;
    }

    public String getID() {
        return name.toUpperCase();
    }

    public int getMaxNumberOfIndustryFacility() {
        return slots.length;
    }

    public String[][] getSlots() {
        return slots;
    }

    public void setSlots(String[][] slots) {
        this.slots = slots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
