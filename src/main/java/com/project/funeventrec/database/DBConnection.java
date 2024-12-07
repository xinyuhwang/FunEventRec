package com.project.funeventrec.database;

import com.project.funeventrec.entity.Item;

import java.util.List;
import java.util.Set;

public interface DBConnection {
    /**
     * Gets categories based on item id
     *
     * @param itemId
     * @return set of categories
     */
    public Set<String> getCategories(String itemId);

    /**
     * Search items near a geolocation and a term (optional).
     *
     * @param latitude
     * @param longitude
     * @param term
     *            (Nullable)
     * @return list of items
     */
    public List<Item> searchItems(double latitude, double longitude, String term);

    /**
     * Save item into db.
     *
     * @param item
     */
    public void saveItem(Item item);

    /**
     * Get the favorite item id for a user.
     *
     * @param userId
     * @return itemIds
     */
    public Set<String> getFavoriteItemIds(String userId);


    /**
     * Get the favorite items for a user.
     *
     * @param userId
     * @return items
     */
    public Set<Item> getFavoriteItems(String userId);

    /**
     * Close the connection.
     */
    public void close();
}
