package com.kyptonaut.game;

import com.kyptonaut.encounters.CombatEncounter;
import com.kyptonaut.encounters.FriendlyEncounter;
import com.kyptonaut.encounters.VendorEncounter;
import com.kyptonaut.things.Monster;
import com.kyptonaut.things.Player;
import com.kyptonaut.things.Room;
import com.kyptonaut.things.Weapon;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class has methods for creating a variety of rooms that can be placed into the world.
 * It also handles the game logic in a method.
 */
public class GameLogic {

    private Scanner in = new Scanner(System.in);
    private String userName = "Zac";




    public ArrayList<Room> createRandomRooms(int number) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        for (int i = 0; i < number; i++) {
            int rand = (int) (Math.floor(Math.random()*3)+1);

            switch (rand) {
                case 1 -> {
                    Room room = createTrollCave();
                    rooms.add(room);
                }
                case 2 -> {
                    Room room = createDwarfRoom();
                    rooms.add(room);
                }
                case 3 -> {
                    Room room = createVendorRoom();
                    rooms.add(room);
                }
                default -> throw new IllegalStateException("Unexpected value: " + rand);
            }
        }
        return rooms;
    }

    public ArrayList<Room> createVendorRooms(int number) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        for (int i = 0; i < number; i++) {
            Room room = createVendorRoom();
            rooms.add(room);
        }
        return rooms;
    }

    public Room createTrollCave() {
        ArrayList<String> loot = new ArrayList<String>();
        loot.add("potion");
        loot.add("gold");
        Monster troll = new Monster("troll","Large and dangerous.",50,10,15, loot);
        ArrayList<Monster> habitants = new ArrayList<Monster>();
        habitants.add(troll);
        Room room = new Room("troll's cave","You enter a cave. Your nose detects something very stinky nearby.\n" +
                "It doesn't take long for you to realize where the foul smell comes from, \n" +
                "a giant troll attacks you with a club.\n", habitants, loot, "combat");
        return room;
    }

    public Room createDwarfRoom() {
        ArrayList<String> loot = new ArrayList<String>();
        loot.add("gold");
        Monster dwarf = new Monster("dwarf","Small and greedy.",20,5,10, loot);
        ArrayList<Monster> habitants = new ArrayList<Monster>();
        habitants.add(dwarf);
        Room room = new Room("dwarven residence","You have entered a clean and tidy room full of shiny things.\n" +
                "The only resident - a fat and grumpy-looking dwarf - is not pleased to see you.\n" +
                "He immediately grabs his axe and lunges towards you.\n", habitants, loot, "combat");
        return room;
    }

    public Room createSkeletonRoom() {
        ArrayList<String> loot = new ArrayList<String>();
        loot.add("potion");
        loot.add("gold");
        Monster skeleton = new Monster("skeleton","The bane of many adventurers.",30,10,15, loot);
        ArrayList<Monster> habitants = new ArrayList<Monster>();
        habitants.add(skeleton);
        Room room = new Room("dark corridor","You hear something that sounds like creaky bones rubbing together.\n" +
                "A skeleton rattles and screams, and then proceeds to point its spear against you.", habitants, loot, "combat");
        return room;
    }

    public Room createWilderness(int tier) {
        ArrayList<String> loot = new ArrayList<String>();
        loot.add("potion");
        loot.add("gold");
        int hp = (int) Math.floor(Math.random()*5)*10+20+tier*10;
        int min = (int) Math.floor(Math.random()*3+1)*5+tier*10;
        int max = (int) Math.floor(Math.random()*3+1)*5+10+tier*10;
        String[] animals = {"wolf","bat","snake","cockatoo","bear","wolverine","panda"};
        String name = animals[(int) Math.floor(Math.random()*animals.length)];
        Monster animal = new Monster(name,"", hp, min, max, loot);
        ArrayList<Monster> habitants = new ArrayList<Monster>();
        habitants.add(animal);
        Room room = new Room("wilderness","You get ambushed by a " + name + "! You draw your weapon and fight.",
                habitants, loot, "combat");
        return room;
    }

    public Room createUnicornRoom() {
        ArrayList<String> loot = new ArrayList<String>();
        Monster unicorn = new Monster("unicorn","A beautiful creature.",20,5,10, loot);
        ArrayList<Monster> habitants = new ArrayList<Monster>();
        habitants.add(unicorn);
        Room room = new Room("clearing in the forest","You enter a little clearing in the forest. The sun shines down on a majestic unicorn.\n"+
                "It seems to have wandered away from its herd by mistake. You spend some time to help it find its way back, and succeed after a while.\n" +
                "The unicorn gifts you something to show its gratitude before it joins its buddies.", habitants, loot, "friendly");
        return room;
    }

    public Room createVendorRoom() {
        ArrayList<String> loot = new ArrayList<String>();
        loot.add("gold");
        Monster goblin = new Monster("goblin","Small and greedy.",20,5,10, loot);
        ArrayList<Monster> habitants = new ArrayList<Monster>();
        habitants.add(goblin);
        Room room = new Room("shop of the goblin","You have entered a tiny shop. It looks well maintained. \n" +
                "A scrawny goblin greets you with a grin. \"Welcome to my humble shop! \n" +
                "Feel free to look around. I hope you find something of interest to you,\" the goblin chuckles. \n" +
                "\"I have the cheapest goods around here!\" the goblin proudly exclaims.\n" +
                "\"Not that there is much of any competition around here,\" you mumble to yourself. \n", habitants, loot, "vendor");
        return room;
    }

    public Room createVendorRoom2() {
        ArrayList<String> loot = new ArrayList<String>();
        loot.add("gold");
        Monster goblin = new Monster("goblin","Small and greedy.",20,5,10, loot);
        ArrayList<Monster> habitants = new ArrayList<Monster>();
        habitants.add(goblin);
        Room room = new Room("shop of the goblin","You walk into the goblin's shop again. You don't understand how he managed to teleport his shop here.\n" +
                "Nor do you understand how he has restocked the same items. Since it's convenient anyway you decide to not think about it any further.\n" +
                "The goblin interrupts your thoughts. \"Oh, I can see that the big spender is back again." +
                "\nYour kind is always welcome here,\" the goblin chuckles.", habitants, loot, "vendor");
        return room;
    }

    public Room createGrendelRoom() {
        ArrayList<String> loot = new ArrayList<String>();
        loot.add("potion");
        loot.add("gold");
        Monster skeleton = new Monster("giant troll \"Grendel\"","The bane of many adventurers.",400,30,40, loot);
        ArrayList<Monster> habitants = new ArrayList<Monster>();
        habitants.add(skeleton);
        Room room = new Room("boss room","You have entered a large hall. You hear boss music.\n" +
                "A big troll approaches and introduces himself as \"Grendel\".\n" +
                "Before you can respond Grendel initiates combat.", habitants, loot, "combat");
        return room;
    }

    public Player generatePlayer() {
        Player player = new Player("A blank slate","Formless",0,0,
                new Weapon("Spoon", "Death by spoon",1,2), 0,0);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\t # What's your name brave adventurer? #");

        this.userName = in.nextLine();
        System.out.println("\t # Greetings " + this.userName + ". #");
        System.out.println("\t # Are you rich or poor? #\n");

        boolean inMenu = true;
        do {
            System.out.println("\tChoose a difficulty:");
            System.out.println("\t1. Rich. (Very easy)");
            System.out.println("\t2. Poor. (Easy)");

            String userOption = in.nextLine();

            switch (userOption) {
                case "1" -> {
                    player.setName(this.userName);
                    player.setDescription("A tall, strong (and rich) warrior.");
                    player.setHealth(100);
                    player.setStrength(20);
                    player.setWeapon(new Weapon("Short sword","A small, light and bladed weapon.",10,20));
                    player.setGold(500);
                    player.setPotions(15);
                    System.out.println("\t # Please, go ahead and step into the dungeon... #\n");
                    System.out.println("\t ***"+ player.getName() + " materializes outside an entrance to a dungeon***");
                    return player;
                }
                case "2" -> {
                    player.setName(this.userName);
                    player.setDescription("A tall, strong (and poor) warrior.");
                    player.setHealth(100);
                    player.setStrength(20);
                    player.setWeapon(new Weapon("Dagger","The thief class' favorite.",10,15));
                    player.setGold(50);
                    player.setPotions(5);
                    System.out.println("\t # Please, go ahead and step into the dungeon... #\n");
                    System.out.println("\t ***"+ player.getName() + " materializes outside an entrance to a dungeon***\n");
                    return player;
                }
                default -> {
                    System.out.println("\tTry again.");
                }
            }

        } while (true);

    }

    /**
     * Here is where the bulk of the action occurs. This method places a player into a dungeon and runs the game.
     * The player makes decisions through a menu. The game is over when this loop stops running.
     */
    public void mainLoop(Player player, ArrayList<Room> list_of_rooms) {

        boolean isPlaying = true;
        Room currentRoom;
        ArrayList<String> startingLoot = new ArrayList<String>();
        startingLoot.add("gold");
        startingLoot.add("potion");
        Room previousRoom = new Room("area outside of the dungeon entrance","",new ArrayList<Monster>(), startingLoot,"start");

        do {

            if (player.getHealth() < 1) {
                System.out.println("You are dead! Better luck next time.");
                System.out.println("Exiting game...");
                break;
            }

            //Print visuals in console.
            Visuals.printStatsBar(player);
            Visuals.printRegularOptions();

            String userOption = in.nextLine();

            switch (userOption) {
                case "1" -> {
                    try {
                        currentRoom = list_of_rooms.get(0);
                        previousRoom = list_of_rooms.get(0);
                        list_of_rooms.remove(0);

                        if (currentRoom.getTypeOfZone().equals("combat")) {
                            Visuals.printCombatPicture();
                            System.out.println(currentRoom.getDescription());
                            CombatEncounter combatEncounter = new CombatEncounter();
                            combatEncounter.fight(player, currentRoom.getHabitants().get(0));
                        } else if (currentRoom.getTypeOfZone().equals("friendly")) {
                            System.out.println(currentRoom.getDescription());
                            FriendlyEncounter friendlyEncounter = new FriendlyEncounter();
                            friendlyEncounter.unicornEvent(player);
                        } else if (currentRoom.getTypeOfZone().equals("vendor")) {
                            System.out.println(currentRoom.getDescription());
                            VendorEncounter vendorEncounter = new VendorEncounter();
                            vendorEncounter.shop(player);
                        }
                    } catch (Exception e) {
                        Visuals.printStatsBar(player);
                        System.out.println("You have reached a vast grassland. You pinch your arm to see if you're alive. Still alive.\n" +
                                "It appears this is the end of the adventure. Celebrate your victory and bask in the glory.\n" +
                                "\n\t#"+player.getKillCount() + " enemies were slain during the run.#");
                        System.out.println("\nExiting game...");
                        isPlaying = false;
                    }

                }
                case "2" -> {
                    player.drinkPotion();
                }
                case "3" -> {
                    previousRoom.lootRoom(player);
                }
                case "x" -> {
                    System.out.println("Exiting game...");
                    isPlaying = false;
                }
            }

        } while (isPlaying);

    }

    public String getUserName() {
        return userName;
    }


}
