package com.kyptonaut.encounters;

import com.kyptonaut.things.Player;

/**
 * Contains methods for a variety of possible friendly encounters for the player.
 */

public class FriendlyEncounter {
    public void unicornEvent(Player player) {
        player.setPotions(player.getPotions()+10);
        System.out.println("\n\tYou have received 10 potions.");
    }
}
