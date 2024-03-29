package com.bb_score.deserializer;

import com.bb_score.industry_facility.IndustryFacility;
import com.bb_score.industry_facility.IndustryFacilityType;
import com.bb_score.industry_facility.IndustryFacilityType.*;
import com.bb_score.link.Link;
import com.bb_score.location.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.bb_score.industry_facility.IndustryFacilityType.*;

class JacksonDeserializerTest {
    private JacksonDeserializer<?> deserializer;
    private IndustryFacility expected;


    @AfterEach
    void tearDown() {
        deserializer = null;
    }

    @Test
    void testPOJOReturnedAfterLocationsJsonParsed() {
        IndustryFacilityType[][] slots = {{COTTON_MILL, MANUFACTURER}, {POTTERY, IRON_WORK}, {MANUFACTURER}};
        assertListFirstELementWithGivenPOJO("Locations.json", Location.class, new Location("STOKE-ON-TRENT", slots));
    }

    @Test
    void testPOJOReturnedAfterLinksJsonParsed() {
        assertListFirstELementWithGivenPOJO("Links.json", Link.class, new Link("1"));
    }

    @Test
    void testPOJOReturnedAfterIndustryFacilitiesJsonParsed() {
        expected = new IndustryFacility(IndustryFacilityType.MANUFACTURER, 1, 3, 2);
        assertListFirstELementWithGivenPOJO("IndustryFacility.json", IndustryFacility.class, expected);
    }


    private <T> void assertListFirstELementWithGivenPOJO(String pathname, Class<T> clazz, T expected) {
        deserializer = new JacksonDeserializer<>(new File(pathname), clazz);
        List list = deserializer.get();
        Assertions.assertEquals(expected, list.get(0));
    }


}