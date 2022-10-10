package com.kyptonaut.things;


import java.util.ArrayList;

/**
 * Monsters deal damage and tries to kill the player. The monsters drop loot when defeated.
 */

public class Monster extends Thing implements IFighter{

    private int health;
    private int minDamage;
    private int maxDamage;
    private ArrayList<String> loot;

    public Monster(String name, String description, int health, int minDamage, int maxDamage, ArrayList<String> loot) {
        super(name, description);
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.loot = loot;
    }

    @Override
    public int calculateAttackDamage() {
        return (int) (Math.floor(Math.random()*this.maxDamage)+this.minDamage);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<String> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<String> loot) {
        this.loot = loot;
    }
}
