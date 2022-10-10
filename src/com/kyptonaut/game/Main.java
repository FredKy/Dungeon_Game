package com.kyptonaut.game;

import com.kyptonaut.things.Room;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Here a player and a dungeon is created, and then placed into the main game loop.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Application is running...\n");

        GameLogic game = new GameLogic();

        //"Handcrafted" dungeon
        ArrayList<Room> myDungeon = new ArrayList<Room>();
        myDungeon.add(game.createWilderness(0));
        myDungeon.add(game.createSkeletonRoom());
        myDungeon.add(game.createWilderness(0));
        myDungeon.add(game.createTrollCave());
        myDungeon.add(game.createWilderness(0));
        myDungeon.add(game.createVendorRoom());
        myDungeon.add(game.createWilderness(1));
        myDungeon.add(game.createDwarfRoom());
        myDungeon.add(game.createWilderness(1));
        myDungeon.add(game.createUnicornRoom());
        myDungeon.add(game.createWilderness(1));
        myDungeon.add(game.createVendorRoom2());
        myDungeon.add(game.createWilderness(1));
        myDungeon.add(game.createWilderness(1));
        myDungeon.add(game.createGrendelRoom());


        game.mainLoop(game.generatePlayer(), myDungeon);


        //Hjälp till Rolla

        /*ArrayList<String> players = new ArrayList<String>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        scores.add(2);
        scores.add(5);
        players.add("A");
        players.add("B");
        System.out.println(Collections.max(scores));
        Integer maxValue = Collections.max(scores);

        Integer indexOfWinner = scores.indexOf(maxValue);

        System.out.println(scores.indexOf(maxValue));

        System.out.println(players.get(indexOfWinner));*/


    }

}
