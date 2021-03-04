package com.market.storage;

import com.market.tools.DiscountCard;

import java.util.ArrayList;
import java.util.List;

public class MarketStore {
    List<DiscountCard> database = new ArrayList<>();

    public boolean existInDatabase(DiscountCard dc) {
        return database.contains(dc);
    }

    public void insertInDatabase(DiscountCard dc) {
        if (existInDatabase(dc))
            System.out.println("This discount card already exists in the database!");
        else
            database.add(dc);
    }

    public void removeFromDatabase(DiscountCard dc) {
        if (dc != null)
            database.remove(dc);
        else
            System.err.println("Error!");
    }

    public void showDatabase() {
        for (DiscountCard dc : database) {
            System.out.println(dc);
        }
    }
}
