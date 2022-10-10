package com.kyptonaut.things;

import com.kyptonaut.things.Monster;
import com.kyptonaut.things.Thing;

import java.util.ArrayList;

/**
 * This represents a zone where things take place between the player and other entities, such as monsters, vendors etc.
 * The game world is built out of interlinked rooms.
 */

public class Room extends Thing {

    private ArrayList<Monster> habitants;
    private ArrayList<String> items;
    private String typeOfZone = "combat, vendor or friendly zone";

    public Room(String name, String description, ArrayList<Monster> habitants, ArrayList<String> items, String typeOfZone) {
        super(name, description);
        this.habitants = habitants;
        this.items = items;
        this.typeOfZone = typeOfZone;
    }

    public ArrayList<Monster> getHabitants() {
        return habitants;
    }

    public void setHabitants(ArrayList<Monster> habitants) {
        this.habitants = habitants;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public String getTypeOfZone() {
        return typeOfZone;
    }

    public void lootRoom(Player player) {
        System.out.println("\tYou explore the " + this.getName() +".");
        if (this.items.size() == 0) {
            System.out.println("\tThere is nothing to be found here.");
        }
        if (this.items.contains("gold")) {
            int gold = (int) (Math.floor(Math.random()*25)+1) + 25;
            System.out.println("\tYou picked up " + gold + " gold pieces.");
            player.setGold(player.getGold()+gold);
            this.items.remove("gold");
        }
        if (this.items.contains("potion")) {
            player.setPotions(player.getPotions()+1);
            System.out.println("\tYou picked up a potion.");
            this.items.remove("potion");
        }
    }


}
