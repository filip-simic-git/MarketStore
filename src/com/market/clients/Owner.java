package com.market.clients;

import com.market.storage.MarketStore;

import java.util.Objects;

public class Owner {
    private String fullName;
    private int ownerID;

    public Owner(String fullName, int ownerID) throws Exception {
        if (fullName.length() < 4 || fullName.length() > 25 || MarketStore.ownersIDList.contains(ownerID)) {
            throw new Exception("Error! Enter the appropriate information. Owner's name must be 4 to 25 characters long and each owner must have unique ID.");
        } else {
            this.fullName = fullName;
            this.ownerID = ownerID;
            MarketStore.ownersIDList.add(ownerID);
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return getOwnerID() == owner.getOwnerID() && Objects.equals(getFullName(), owner.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getOwnerID());
    }

    @Override
    public String toString() {
        return "---Owner information---" +
                "\nFull name: " + getFullName() +
                "\nOwner ID: " + getOwnerID();
    }
}
