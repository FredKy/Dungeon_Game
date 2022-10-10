package com.kyptonaut.encounters;

import com.kyptonaut.things.Monster;
import com.kyptonaut.things.Player;
import com.kyptonaut.game.Visuals;

import java.util.Scanner;

/**
 * This represents a combat zone where a player and a monster fight until one is victorious.
 */
public class CombatEncounter {

    private Scanner in = new Scanner(System.in);
    private boolean inCombat = true;

    public void fight(Player player, Monster monster) {
        do {

            if (player.getHealth() < 1) {
                System.out.println("You have lost the fight.");
                return;
            } else if (monster.getHealth() < 1) {
                System.out.println("You have won the fight! Your strength increased slightly.");
                player.setStrength(player.getStrength()+1);
                player.setKillCount(player.getKillCount()+1);
                if (monster.getLoot().contains("gold")) {
                    int gold = (int) (Math.floor(Math.random()*25)+1) + 25;
                    System.out.println("You picked up " + gold + " gold pieces.");
                    player.setGold(player.getGold()+gold);

                }
                if (monster.getLoot().contains("potion")) {
                    player.setPotions(player.getPotions()+1);
                    System.out.println("You picked up a potion.");
                }
                return;

            }
            System.out.println("-----------------------------------------------------------------------------------------");
            //System.out.println("\tIN COMBAT");
            //Visuals.printCombatPicture();
            System.out.println("<<< I N   C O M B A T >>>         \n");
            System.out.println("\tEnemy: "+monster.getName());
            System.out.println("\tEnemy health: " + monster.getHealth());
            Visuals.printStatsBar(player);
            Visuals.printCombatOptions();

            String userOption = in.nextLine();

            switch (userOption) {
                case "1" -> {
                    System.out.println("-----------------------------------------------------------------------------------------");
                    int damage_dealt = player.calculateAttackDamage();
                    System.out.println(player.getName() + " dealt " + damage_dealt + " damage to the " + monster.getName() + ".");
                    monster.setHealth(monster.getHealth()-damage_dealt);
                    //System.out.println("The " + monster.getName() + " has " + monster.getHitPoints() + " HP left.\n");

                    int monster_damage = monster.calculateAttackDamage();
                    System.out.println("The " + monster.getName() + " dealt " + monster_damage + " damage in retaliation.");
                    player.setHealth(player.getHealth() -monster_damage);
                    //System.out.println("Your HP is now " + player.getHitPoints() + ".\n");
                }
                case "2" -> player.drinkPotion();
                case "3" -> {
                    if (Math.random() > 0.6) {
                        System.out.println(player.getName() + " chickened out from the fight successfully.");
                        System.out.println("Exiting combat...");
                        inCombat = false;
                    } else {
                        int monster_damage = monster.calculateAttackDamage();
                        System.out.println("The " + monster.getName() + " punishes your cowardly attempt at escaping by getting in a free hit!");
                        System.out.println("The " + monster.getName() + " dealt " + monster_damage + " damage to "+ player.getName() + ".\n");
                        player.setHealth(player.getHealth() -monster_damage);
                    }

                }
            }

        } while (inCombat);
    }

}
