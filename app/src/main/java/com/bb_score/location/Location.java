package com.bb_score.location;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bb_score.Element;
import com.bb_score.NoOwnerAssignedException;
import com.bb_score.Player;
import com.bb_score.industry_facility.IndustryFacility;
import com.bb_score.link.Link;

import java.util.*;

public class Location implements Element {
    private final String name;
    private final Set<IndustryFacility> industryFacilities;
    private final Set<Link> links;
    private final int maxNumberOfIndustryFacility;
    private int currentNumberOfIndustryFacility = 0;

    public Location(String name, Set<Link> links, int maxNumberOfIndustryFacility) {
        this.name = name;
        this.maxNumberOfIndustryFacility = maxNumberOfIndustryFacility;
        this.links = links;

        industryFacilities = new HashSet<>();
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

    public Set<Link> getLinks() {
        return links;
    }

    @Override
    public String getID() {
        return name.toUpperCase();
    }
}
