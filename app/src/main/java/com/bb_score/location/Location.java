package com.bb_score.location;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bb_score.Element;
import com.bb_score.Player;
import com.bb_score.exception.NoMoreIndustryFacilityPlaceAtLocationException;
import com.bb_score.exception.NoOwnerAssignedException;
import com.bb_score.industry_facility.IndustryFacility;
import com.bb_score.link.Link;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Location {
    @JsonProperty("name")
    private String name;
    @JsonProperty("maxNumberOfIndustryFacility")
    private int maxNumberOfIndustryFacility;

    private final Set<IndustryFacility> industryFacilities = new HashSet<>();

    public Location() {
    }



    private int currentNumberOfIndustryFacility = 0;

    public Location(String name, int maxNumberOfIndustryFacility) {
        this.name = name;
        this.maxNumberOfIndustryFacility = maxNumberOfIndustryFacility;
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
        if (currentNumberOfIndustryFacility < maxNumberOfIndustryFacility) {
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
