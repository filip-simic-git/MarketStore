package com.market.test;

import com.market.cards.DiscountCard;
import com.market.storage.MarketStore;
import com.market.cards.CardType;
import com.market.clients.Owner;

public class Main {
    public static void main(String[] args) {
        Owner o1 = null;
        Owner o2 = null;
        Owner o3 = null;
        try {
            o1 = new Owner("Filip Simic", 123);
            o2 = new Owner("Elena Ivanov", 456);
            o3 = new Owner("Daniela Petrov", 789);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DiscountCard dc1 = null;
        DiscountCard dc2 = null;
        DiscountCard dc3 = null;
        try {
            dc1 = new DiscountCard(CardType.BRONZE, o1, 0, 150);
            dc2 = new DiscountCard(CardType.SILVER, o2, 600, 850);
            dc3 = new DiscountCard(CardType.GOLD, o3, 1500, 1300);
        } catch (Exception e) {
            e.printStackTrace();
        }

        MarketStore ms = new MarketStore();
        try {
            ms.insertInDatabase(dc1);
            ms.insertInDatabase(dc2);
            ms.insertInDatabase(dc3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ms.showDatabase();
    }
}
