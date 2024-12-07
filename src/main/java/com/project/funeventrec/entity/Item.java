package com.project.funeventrec.entity;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
/**
 *
 * @author Xinyu Wang
 * @version 10/18/2024
 * Item class
 * Entity for events
 *
 */
public class Item {
    private String itemId;
    private String name;
    private Set<String> categories;
    private double distance;
    private double rating;
    private String address;
    private String imageUrl;
    private String url;


    public Item(ItemBuilder builder) {
        this.itemId = builder.itemId;
        this.name = builder.name;
        this.categories = builder.categories;
        this.distance = builder.distance;
        this.rating = builder.rating;
        this.address = builder.address;
        this.imageUrl = builder.imageUrl;
        this.url = builder.url;
    }

    public String getItemId() {

        return itemId;
    }
    public String getName() {

        return name;
    }
    public Set<String> getCategories() {
        return categories;
    }
    public double getDistance() {
        return distance;
    }
    public double getRating() {
        return rating;
    }
    public String getAddress() {
        return address;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public String getUrl() {
        return url;
    }

    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        try {
            object.put("item_id", itemId);
            object.put("name", name);
            object.put("categories", new JSONArray(categories));
            object.put("distance", distance);
            object.put("rating", rating);
            object.put("address", address);
            object.put("image_url", imageUrl);
            object.put("url", url);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static class ItemBuilder {
        private String itemId;
        private String name;
        private Set<String> categories;
        private double distance;
        private double rating;
        private String address;
        private String imageUrl;
        private String url;


        public void setItemId(String itemId) {

            this.itemId = itemId;
        }

        public void setName(String name) {

            this.name = name;
        }

        public void setRating(double rating) {

            this.rating = rating;
        }

        public void setAddress(String address) {

            this.address = address;
        }

        public void setCategories(Set<String> categories) {

            this.categories = categories;
        }

        public void setImageUrl(String imageUrl) {

            this.imageUrl = imageUrl;
        }

        public void setUrl(String url) {

            this.url = url;
        }

        public void setDistance(double distance) {

            this.distance = distance;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
