package com.kyptonaut.things;

public interface IFighter {

    default int calculateAttackDamage() {
        return 0;
    }

}
