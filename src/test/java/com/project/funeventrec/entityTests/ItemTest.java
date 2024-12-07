package com.project.funeventrec.entityTests;
import com.project.funeventrec.entity.Item;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * @author Xinyu Wang
 * @version 10/18/2024
 *
 * Junit Test for Item class
 *
 */
public class ItemTest {
    @Test
    public void testItemBuilder() {
        Set<String> category = new HashSet<>();
        Item.ItemBuilder itemBuilder = new Item.ItemBuilder();

        // arrange
        itemBuilder.setItemId("1");
        itemBuilder.setName("name");
        itemBuilder.setCategories(category);
        itemBuilder.setDistance(10.9);
        itemBuilder.setRating(3.0);
        itemBuilder.setAddress("address");
        itemBuilder.setImageUrl("imageUrl");
        itemBuilder.setUrl("url");
        Item item = new Item(itemBuilder);

        // act
        String expectedItemId = "1";
        String expectedName = "name";
        Set<String> expectedCategories = category;
        double expectedDistance = 10.9;
        double expectedRating = 3.0;
        String expectedAddress = "address";
        String expectedImageUrl = "imageUrl";
        String expectedUrl = "url";

        // assert
        assertEquals(expectedItemId, item.getItemId());
        assertEquals(expectedName, item.getName());
        assertEquals(expectedCategories, item.getCategories());
        assertEquals(expectedDistance, item.getDistance(), 0.001);
        assertEquals(expectedRating, item.getRating(), 0.001);
        assertEquals(expectedAddress, item.getAddress());
        assertEquals(expectedImageUrl, item.getImageUrl());
        assertEquals(expectedUrl, item.getUrl());
    }
}
