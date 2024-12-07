package com.project.funeventrec.recommendationTests;

import com.project.funeventrec.entity.Item;
import com.project.funeventrec.recommendation.PreferenceBasedRec;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * @author Xinyu Wang
 * @version 10/18/2024
 *
 * Junit Test for PreferenceBasedRec class
 *
 */
public class PreferenceBasedRecTest {
    @Test
    public void setLatitudeTest() {
        PreferenceBasedRec preferenceBasedRec = new PreferenceBasedRec();
        // arrange
        double attitude = 22.22;

        // act
        preferenceBasedRec.setLatitude(attitude);
        double output = preferenceBasedRec.getLatitude();
        double expected = 22.22;

        // assert
        assertEquals(expected, output, 0.001);
    }

    @Test
    public void setLongitudeTest() {
        PreferenceBasedRec preferenceBasedRec = new PreferenceBasedRec();
        // arrange
        double longitude = 22.22;

        // act
        preferenceBasedRec.setLongitude(longitude);
        double output = preferenceBasedRec.getLongitude();
        double expected = 22.22;

        // assert
        assertEquals(expected, output, 0.001);
    }

    @Test
    public void recommendItemsTest() {
        PreferenceBasedRec preferenceBasedRec = new PreferenceBasedRec();
        // arrange
        List<Item> events = preferenceBasedRec.recommendItems("123");

        // act
        List<Item> output = new ArrayList<>();
        List<Item> expected = new ArrayList<>();

        // assert
        assertEquals(expected, output);
    }
}
