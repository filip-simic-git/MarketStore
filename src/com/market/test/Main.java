package com.market.test;

import com.market.tools.DiscountCard;
import com.market.storage.MarketStore;
import com.market.tools.CardType;
import com.market.clients.Owner;

public class Main {
    public static void main(String[] args) {
        Owner o1 = new Owner("Filip Simic", 123);
        Owner o2 = new Owner("Elena Ivanov", 456);
        Owner o3 = new Owner("Daniela Petrov", 789);

        DiscountCard dc1 = new DiscountCard(CardType.BRONZE, o1, 0, 150);
        DiscountCard dc2 = new DiscountCard(CardType.SILVER, o2, 600, 850);
        DiscountCard dc3 = new DiscountCard(CardType.GOLD, o3, 1500, 1300);

        MarketStore ms = new MarketStore();
        ms.insertInDatabase(dc1);
        ms.insertInDatabase(dc2);
        ms.insertInDatabase(dc3);

        ms.showDatabase();
    }
}
