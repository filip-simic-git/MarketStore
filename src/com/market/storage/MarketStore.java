package com.market.storage;

import com.market.cards.DiscountCard;

import java.util.ArrayList;
import java.util.List;

public class MarketStore {
    public static List<DiscountCard> database = new ArrayList<>();
    public static List<Integer> ownersIDList = new ArrayList<>();

    public boolean existInDatabase(DiscountCard dc) {
        return database.contains(dc);
    }

    public void insertInDatabase(DiscountCard dc) throws Exception {
        if (existInDatabase(dc) || dc == null)
            throw new Exception("Error! Enter the appropriate information. Discount card must be unique and mustn't be null.");
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
