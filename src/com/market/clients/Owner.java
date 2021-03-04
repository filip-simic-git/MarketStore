package com.market.clients;

import java.util.Objects;

public class Owner {
    String fullName;
    int ownerID;

    public Owner(String fullName, int ownerID) {
        this.fullName = fullName;
        this.ownerID = ownerID;
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
