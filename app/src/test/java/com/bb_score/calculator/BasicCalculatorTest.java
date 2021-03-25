package com.bb_score.calculator;

import com.bb_score.Player;
import com.bb_score.calculator.BasicCalculator;
import com.bb_score.exception.NoMoreIndustryFacilityPlaceAtLocationException;
import com.bb_score.exception.NoOwnerAssignedException;
import com.bb_score.exception.NoSuchIndustryFacilityTypeAtLocation;
import com.bb_score.industry_facility.IndustryFacilitiesProvider;
import com.bb_score.industry_facility.IndustryFacility;
import com.bb_score.industry_facility.IndustryFacilityType;
import com.bb_score.location.Location;
import com.bb_score.location.LocationsProvider;
import dalvik.system.PathClassLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    private HashMap<String, Location> usedLocations;
    BasicCalculator basicCalculator;

    @Test
    void whenNullLocationIsGivenThenIllegalArgumentExceptionThrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BasicCalculator(null, new HashSet<>()));
    }

    @Test
    void whenNullLinkIsGivenThenIllegalArgumentExceptionThrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BasicCalculator(usedLocations, null));
    }

    @Test
    void whenOneMineIsInCoalbrookdale() throws NoSuchIndustryFacilityTypeAtLocation, NoMoreIndustryFacilityPlaceAtLocationException, NoOwnerAssignedException {
        IndustryFacility industryFacility = new IndustryFacility(IndustryFacilityType.IRON_WORK, 1, 1, 0);
        industryFacility.setOwner(Player.ORANGE);
        Location location = new Location("COALBROOKDALE", new IndustryFacilityType[][]{{IndustryFacilityType.IRON_WORK, IndustryFacilityType.BREWERY}, {IndustryFacilityType.IRON_WORK}, {IndustryFacilityType.COAL_MINE}});
        location.addIndustryFacility(industryFacility);
        usedLocations.put("COALBROOKDALE", location);
        basicCalculator = new BasicCalculator(usedLocations, new HashSet<>());
        Map<Player, Integer> actual = basicCalculator.calculatePoints();
        Assertions.assertEquals(java.util.Optional.of(1).get(), actual.get((Player) Player.ORANGE));
    }

    @Test
    void moreIndustriesInOneLocation() throws NoSuchIndustryFacilityTypeAtLocation, NoMoreIndustryFacilityPlaceAtLocationException, NoOwnerAssignedException {
        LocationsProvider locationsProvider = new LocationsProvider(new File("Locations.json"));
        IndustryFacilitiesProvider industryFacilitiesProvider = new IndustryFacilitiesProvider(new File("IndustryFacility.json"));
        IndustryFacility industryFacility = industryFacilitiesProvider.get("COAL_MINE_1");
        industryFacility.setOwner(Player.ORANGE);
        Location location = locationsProvider.get("COALBROOKDALE");
        location.addIndustryFacility(industryFacility);
        usedLocations.put("COALBROOKDALE", location);
        basicCalculator = new BasicCalculator(usedLocations, new HashSet<>());
        Map<Player, Integer> actual = basicCalculator.calculatePoints();
        Assertions.assertEquals(java.util.Optional.of(1).get(), actual.get((Player) Player.ORANGE));
    }

    @BeforeEach
    void setUp() {
        this.usedLocations = new HashMap<>();
    }

    @AfterEach
    void tearDown() {
        basicCalculator = null;
        usedLocations = null;
    }
}