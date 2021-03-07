package com.bb_score;

import com.bb_score.location.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BusinessLogic {
    private final Set<Location> locations;
    private final HashMap<Player, Integer> scores = new HashMap<Player, Integer>();

    public BusinessLogic(Set<Location> locations) {
        this.locations = locations;
    }

    public Map<Player, Integer> calculateScore(){
        return scores;
    }
}
