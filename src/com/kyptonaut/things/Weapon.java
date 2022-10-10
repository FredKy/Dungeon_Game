package com.kyptonaut.things;

import com.kyptonaut.things.Thing;

/**
 * This represents a weapon that the player can wield to deal more damage.
 */

public class Weapon extends Thing {

    private int minDamage = 0;
    private int maxDamage = 0;
    private int vendorPrice = 0;

    public Weapon(String name, String description, int minDamage, int maxDamage) {
        super(name, description);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int rollDamage() {
        return (int) (Math.floor(Math.random()*this.maxDamage)+this.minDamage);
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getVendorPrice() {
        return vendorPrice;
    }

    public void setVendorPrice(int vendorPrice) {
        this.vendorPrice = vendorPrice;
    }
}
