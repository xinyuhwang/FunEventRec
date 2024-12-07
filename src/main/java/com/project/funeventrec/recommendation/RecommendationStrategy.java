package com.project.funeventrec.recommendation;

import com.project.funeventrec.entity.Item;

import java.util.List;

public interface RecommendationStrategy {
    public List<Item> recommendItems(String userId);
}
