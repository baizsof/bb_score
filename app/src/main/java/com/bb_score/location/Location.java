package com.bb_score.location;

import com.bb_score.Element;
import com.bb_score.Player;
import com.bb_score.industry_facility.IndustryFacility;
import com.bb_score.link.Link;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Location implements Element {
    private final String name;
    private final Set<IndustryFacility> industryFacilities;
    private final Set<Link> links;

    public Location(String name, Set<IndustryFacility> industryFacilities, Set<Link> links) {
        this.name = name;
        this.industryFacilities = industryFacilities;
        this.links = links;
    }

    public Map<Player, Integer> calculateLinkPoints() {
        throw new UnsupportedOperationException();
    }

    public Map<Player, Integer> calculateBasePoints() {
        HashMap<Player, Integer> baseScores = new HashMap<>();
        for (IndustryFacility industryFacility : industryFacilities) {
            Player key = industryFacility.getOwner();
            Integer oldScore = baseScores.get(key);
            baseScores.put(key, oldScore + industryFacility.getBasePoint());
        }
        return baseScores;
    }

    public String getName() {
        return name;
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
