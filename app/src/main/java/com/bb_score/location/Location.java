package com.bb_score.location;

import com.bb_score.link.Link;
import com.bb_score.industry_facility.IndustryFacility;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import main.com.bb_score.Player;

public class Location {
    private final String name;
    private final Set<IndustryFacility> industryFacilities;
    private final Set<Link> links;

    public Location(String name, Set<IndustryFacility> industryFacilities, Set<Link> links) {
        this.name = name;
        this.industryFacilities = industryFacilities;
        this.links = links;
    }

    public Map<Player, Integer> calculateScore() {
        return new HashMap<>();
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
}
