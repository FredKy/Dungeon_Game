package com.kyptonaut.encounters;

import com.kyptonaut.things.Player;
import com.kyptonaut.game.Visuals;
import com.kyptonaut.things.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This handles the occurrence when the player enters the vendor's room.
 */
public class VendorEncounter {

    private Scanner in = new Scanner(System.in);
    private boolean inShop = true;

    private int number_of_potions = (int) Math.floor(Math.random()*11)+5;
    private ArrayList<Weapon> weaponsOnDisplay = new ArrayList<>();
    private Weapon spear = new Weapon("Spear","Pointy.",20,30);
    private Weapon battleAxe = new Weapon("Battle-axe","Marvelous.",30,40);
    private Weapon chopsticks = new Weapon("Chopsticks","Nice to eat with.",5,7);
    private Weapon morningstar = new Weapon("Morningstar", "Fearsome weapon.",50,70);


    private void buyWeapon(Player player, int i) {
        if (player.getGold() >= weaponsOnDisplay.get(i).getVendorPrice()) {
            player.setGold(player.getGold()-weaponsOnDisplay.get(i).getVendorPrice());
            System.out.println("You bought the " + weaponsOnDisplay.get(i).getName() +  " for "
                    + weaponsOnDisplay.get(i).getVendorPrice() + " gold and equipped it. You threw the old weapon in the trashcan.");
            player.setWeapon(weaponsOnDisplay.get(i));
            weaponsOnDisplay.remove(i);
        } else {
            System.out.println("\t(!) You cannot afford that! (!)");
        }
    }

    private void displayWeapons() {
        for (int i = 0; i < weaponsOnDisplay.size(); i++) {
            System.out.println("Weapon: " + weaponsOnDisplay.get(i).getName() +".   " +
                            "Damage: " + weaponsOnDisplay.get(i).getMinDamage() + "-" + weaponsOnDisplay.get(i).getMaxDamage() + ".   " +
                            "Price: " + weaponsOnDisplay.get(i).getVendorPrice() +" gold.");
        }
    }

    public void shop(Player player) {

        spear.setVendorPrice(150);
        battleAxe.setVendorPrice(300);
        chopsticks.setVendorPrice(500);
        morningstar.setVendorPrice(1000);
        weaponsOnDisplay.add(spear);
        weaponsOnDisplay.add(battleAxe);
        weaponsOnDisplay.add(chopsticks);
        weaponsOnDisplay.add(morningstar);

        do {
            //System.out.println("--------------------------------------------------------------------");
            //System.out.println("HP: " + player.getHitPoints() + "   " + "Strength: " + player.getStrength()
            //        + "   " + "Weapon: " + player.getWeapon().getName() + "   " + "Gold: " + player.getGold()
            //        + "   " + "Potions: " + player.getPotions());
            //System.out.println("--------------------------------------------------------------------");
            Visuals.printStatsBar(player);

            System.out.println("Today's offers:");
            displayWeapons();
            System.out.println("Potion (stock "+number_of_potions+"). Price: 10 gold.\n");


            System.out.println("\tChoose an option: ");
            System.out.println("\t1. Buy weapon.");
            System.out.println("\t2. Buy potion.");
            System.out.println("\t3. Quit shopping.");

            String userOption = in.nextLine();

            switch (userOption) {
                case "1" -> {
                    if (weaponsOnDisplay.size() > 0) {

                        boolean lookingAtWeapons = true;

                        do {
                            Visuals.printStatsBar(player);

                            displayWeapons();


                            System.out.println("\n\tChoose an option: ");

                            for (int i = 1; i < weaponsOnDisplay.size()+1; i++) {
                                System.out.println("\t"+i+". Buy " + weaponsOnDisplay.get(i-1).getName() +".");
                            }
                            System.out.println("\tb. Back.");

                            String weaponOption = in.nextLine();

                            switch (weaponOption) {
                                case "1" -> {
                                    try {
                                        buyWeapon(player, 0);
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                }
                                case "2" -> {
                                    try {
                                        buyWeapon(player, 1);
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                }
                                case "3" -> {
                                    try {
                                        buyWeapon(player, 2);
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                }
                                case "4" -> {
                                    try {
                                        buyWeapon(player, 3);
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                }
                                case "b" -> {
                                    lookingAtWeapons = false;
                                }
                                default -> throw new IllegalStateException("Unexpected value: " + weaponOption);
                            }

                        } while (lookingAtWeapons);

                        if (lookingAtWeapons == false) {
                            break;
                        }

                    } else {
                        System.out.println("\tThere are no more weapons left to buy!");
                    }

                }
                case "2" -> {
                    if (player.getGold() >= 10) {
                        if (number_of_potions > 0) {
                            player.setPotions(player.getPotions()+1);
                            player.setGold(player.getGold()-10);
                            number_of_potions -= 1;
                            System.out.println("\tYou bought a potion for 10 gold.");
                        } else {
                            System.out.println("\tThere are no more potions left to buy!");
                        }
                    } else {
                        System.out.println("\t(!) You cannot afford that! (!)");
                    }

                }


                case "3" -> {
                    System.out.println("\tExiting shop...");
                    inShop = false;
                }
            }

        } while (inShop);
    }

}
