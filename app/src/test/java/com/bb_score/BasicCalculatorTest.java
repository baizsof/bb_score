package com.bb_score;

import com.bb_score.calculator.BasicCalculator;
import com.bb_score.industry_facility.IndustryFacilityType;
import com.bb_score.location.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    BasicCalculator basicCalculator;

    @Test
    void whenNullLocationIsGivenThenIllegalArgumentExceptionThrown() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new BasicCalculator(null, new HashSet<>()));
    }

    @Test
    void whenNullLinkIsGivenThenIllegalArgumentExceptionThrown() {
        HashMap<String, Location> usedLocations = new HashMap<>();
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new BasicCalculator(usedLocations, null));
    }

    @Test
    void wheOneMineIsInCoalbrookdale(){
        HashMap<String, Location> usedLocations = new HashMap<>();
        Location location = new Location("COALBROOKDALE", new IndustryFacilityType[][]{{IndustryFacilityType.IRON_WORK, IndustryFacilityType.BREWERY},{IndustryFacilityType.IRON_WORK},{IndustryFacilityType.COAL_MINE}});
        usedLocations.put("COALBROOKDALE", location);
        basicCalculator = new BasicCalculator(usedLocations, new HashSet<>());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        basicCalculator = null;
    }
}