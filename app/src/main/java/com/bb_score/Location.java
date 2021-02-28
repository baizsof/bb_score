package main.java.com.bb_score;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
