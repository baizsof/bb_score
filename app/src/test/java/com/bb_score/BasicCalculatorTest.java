package com.bb_score;

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
        basicCalculator = new BasicCalculator(null, new HashSet<>());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> basicCalculator.calculatePoints());
    }

    @Test
    void whenNullLinkIsGivenThenIllegalArgumentExceptionThrown() {
        HashMap<String, Location> usedLocations = new HashMap<>();
        basicCalculator = new BasicCalculator(usedLocations, null);
        Assertions.assertThrows(IllegalArgumentException.class, ()-> basicCalculator.calculatePoints());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        basicCalculator = null;
    }
}