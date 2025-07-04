package com.example.Service;



import com.example.Model.Shippable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    public void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        Map<String, Integer> itemCounts = new LinkedHashMap<>();
        Map<String, Double> itemWeights = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();
            itemCounts.put(name, itemCounts.getOrDefault(name, 0) + 1);
            itemWeights.put(name, weight); // safe: all same product has same weight
            totalWeight += weight;
        }

        for (String name : itemCounts.keySet()) {
            int count = itemCounts.get(name);
            double weightGrams = itemWeights.get(name) * 1000 * count;
            System.out.printf("%dx %-13s %.0fg%n", count, name, weightGrams);
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);

    }
}
