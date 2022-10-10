package com.kyptonaut.things;

import java.util.ArrayList;
/**
 * This is the player controlled adventurer that has the pleasure of traversing the world.
 */
public class Player extends Thing implements IFighter {

    private int health = 100;
    private int strength = 20;
    private Weapon weapon;
    private int gold;
    private int potions;
    private int killCount = 0;

    public Player(String name, String description, int health, int strength, Weapon startingWeapon, int gold, int potions) {
        super(name, description);
        this.health = health;
        this.weapon = startingWeapon;
        this.strength = strength;
        this.gold = gold;
        this.potions = potions;
    }

    @Override
    public int calculateAttackDamage(){

        int weapon_based = this.weapon.rollDamage();
        int strength_based = (int) (Math.floor(Math.random()*this.strength/5)+1);

        return weapon_based + strength_based;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public void drinkPotion() {
        if (this.potions > 0) {
            potions -= 1;
            health += 20;
            ArrayList<String> tastes = new ArrayList<String>();
            tastes.add("strawberries");
            tastes.add("peach");
            tastes.add("blueberries");
            tastes.add("bananas");
            tastes.add("lingonberries");
            tastes.add("passion fruit");
            tastes.add("cucumber");
            int randomIndex = (int) Math.floor(Math.random()*tastes.size());
            String taste1 = tastes.get(randomIndex);
            tastes.remove(taste1);
            String taste2;
            randomIndex = (int) Math.floor(Math.random()*tastes.size());
            taste2 = tastes.get(randomIndex);

            System.out.println("\tYou drank one potion, it had the taste of " +taste1 + " and " + taste2 + "!\n" +
                    "\tYou gained 20 health. (◠﹏◠)");

        } else {
            System.out.println("\tYou're out of potions! (⩾﹏⩽)");
        }
    }
}
