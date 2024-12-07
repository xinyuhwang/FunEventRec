package com.project.funeventrec.recommendation;

import com.project.funeventrec.database.DBConnection;
import com.project.funeventrec.database.DBConnectionSwitch;
import com.project.funeventrec.entity.Item;

import java.util.*;
/**
 *
 * @author Xinyu Wang
 * @version 10/18/2024
 * PreferenceBasedRec class
 * Provide recommendations based on user preference history
 *
 */
public class PreferenceBasedRec implements RecommendationStrategy{

    private double latitude;
    private double longitude;

    @Override
    public List<Item> recommendItems(String userId) {
        List<Item> recommendedItems = new ArrayList<>();

        // Step 1, get all favorited itemids
        DBConnection connection = DBConnectionSwitch.getConnection();
        Set<String> favoritedItemIds = connection.getFavoriteItemIds(userId);

        // Step 2, get all categories,  sort by count
        // {"sports": 5, "music": 3, "art": 2}
        Map<String, Integer> allCategories = new HashMap<>();
        for (String itemId : favoritedItemIds) {
            Set<String> categories = connection.getCategories(itemId);
            for (String category : categories) {
                allCategories.put(category, allCategories.getOrDefault(category, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> categoryList = new ArrayList<>(allCategories.entrySet());
        Collections.sort(categoryList, (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> {
            return Integer.compare(e2.getValue(), e1.getValue());
        });

        // Step 3, search based on category, filter out favorite items
        Set<String> visitedItemIds = new HashSet<>();
        for (Map.Entry<String, Integer> category : categoryList) {
            List<Item> items = connection.searchItems(this.latitude, this.longitude, category.getKey());

            for (Item item : items) {
                if (!favoritedItemIds.contains(item.getItemId()) && !visitedItemIds.contains(item.getItemId())) {
                    recommendedItems.add(item);
                    visitedItemIds.add(item.getItemId());
                }
            }
        }

        connection.close();
        return recommendedItems;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
