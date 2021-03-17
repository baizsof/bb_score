package com.bb_score;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    BasicCalculator basicCalculator;

    @Test
    void whenNullLocationIsGivenThenNullPointerExceptionThrown() {
        basicCalculator = new BasicCalculator(null, new HashSet<>());
        Assertions.assertThrows(NullPointerException.class, ()-> basicCalculator.calculatePoints()) ;

    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}