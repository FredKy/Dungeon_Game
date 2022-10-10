package com.kyptonaut.game;

import com.kyptonaut.things.Player;

/**
 * Here are methods for printing out "graphics" such as a stats bar.
 */
public class Visuals {

    static public void printStatsBar(Player player) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Health: " + player.getHealth() + "   " + "Strength: " + player.getStrength()
                + "   " + "Weapon: " + player.getWeapon().getName()
                + " ("+ player.getWeapon().getMinDamage()+"-"  + player.getWeapon().getMaxDamage()+")"
                + "   " + "Gold: " + player.getGold() + "   " + "Potions: " + player.getPotions());
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    static public void printRegularOptions() {
        System.out.println("\tChoose an option: ");
        System.out.println("\t1. Move forward to the next area.");
        System.out.println("\t2. Drink potion.");
        System.out.println("\t3. Explore current area.");
        System.out.println("\tx. Exit game.");
    }

    static public void printCombatOptions() {
        System.out.println("\tChoose an option: ");
        System.out.println("\t1. Attack! ");
        System.out.println("\t2. Drink potion.");
        System.out.println("\t3. Try to run away!");
    }

    static public void printCombatPicture() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                  \\                     ");
        System.out.println("                   \\    O                 ");
        System.out.println("                   _\\|  |  }             ");
        System.out.println("      `o^            M_/|\\_|}            ");
        System.out.println("    ^\\/0\\_+---          |  }           ");
        System.out.println("      /O\\              / \\             ");
        System.out.println("     _| /_           _/   \\_             ");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

}
