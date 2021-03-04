package com.market.cards;

import com.market.clients.Owner;

import java.text.DecimalFormat;
import java.util.Objects;

public class DiscountCard {
    private CardType cardType;  // ovo treba zameniti sa vise odgovarajucih klasa kako bi se resio problem: No inheritance, abstraction and polymorphism!
    private Owner owner;
    private double turnover;
    private double valueOfPurchase;
    private double discountRate;

    public DiscountCard(CardType cardType, Owner owner, double turnover, double valueOfPurchase) throws Exception {
        if (turnover < 0 || valueOfPurchase < 0 || owner == null)
            throw new Exception("Error! Enter the appropriate information. Current purchase and turnover value mustn't be negative and owner must exist.");

        this.cardType = cardType;
        this.owner = owner;
        this.turnover = turnover;
        this.valueOfPurchase = valueOfPurchase;

        switch (cardType) {
            case BRONZE:
                if (turnover < 100)
                    discountRate = 0;
                else if (turnover >= 100 && turnover <= 300)
                    discountRate = 0.01;
                else
                    discountRate = 0.025;
                break;

            case SILVER:
                if (turnover > 300)
                    discountRate = 0.035;
                else
                    discountRate = 0.02;
                break;

            case GOLD:
                double growth = 0;

                while (growth < 0.08) {
                    growth += 0.01;
                    turnover -= 100;
                }
                discountRate = 0.02 + growth;
                break;
        }
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public double getValueOfPurchase() {
        return valueOfPurchase;
    }

    public void setValueOfPurchase(double valueOfPurchase) {
        this.valueOfPurchase = valueOfPurchase;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }

    public double calculateDiscount() {
        return valueOfPurchase * discountRate;
    }

    public double total() {
        return valueOfPurchase - calculateDiscount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountCard)) return false;
        DiscountCard that = (DiscountCard) o;
        return Double.compare(that.getTurnover(), getTurnover()) == 0 && Double.compare(that.getValueOfPurchase(), getValueOfPurchase()) == 0 && Double.compare(that.getDiscountRate(), getDiscountRate()) == 0 && getCardType() == that.getCardType() && Objects.equals(getOwner(), that.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardType(), getOwner(), getTurnover(), getValueOfPurchase(), getDiscountRate());
    }

    @Override
    public String toString() {
        DecimalFormat percentageFormat = new DecimalFormat("0.0%");
        DecimalFormat dollarFormat = new DecimalFormat("$0.00");

        return "\n-----Discount card information-----" +
                "\nCard type: " + cardType +
                "\nOwner: " + owner.getFullName() +
                "\nTurnover: " + dollarFormat.format(turnover) +
                "\nPurchase value: " + dollarFormat.format(valueOfPurchase) +
                "\nDiscount rate: " + percentageFormat.format(discountRate) +
                "\nDiscount: " + dollarFormat.format(calculateDiscount()) +
                "\nTotal: " + dollarFormat.format(total());
    }
}
