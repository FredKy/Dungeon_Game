package com.kyptonaut.things;

/**
 * This is a template for things (living or dead) that are present in the game world.
 * Examples are the player, monsters, weapons etc...
 */

public class Thing {

    private String name = "";
    private String description = "";

    public Thing(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Thing(String name) {
        this.name = name;
        this.description = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
