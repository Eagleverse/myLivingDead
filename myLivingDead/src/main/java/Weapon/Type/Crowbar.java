package Weapon.Type;

import Weapon.Weapon;

public class Crowbar implements Weapon {

    private final String type = "crowbar";
    private final int damage = 7;

    @Override
    public int getDamage() {
        // generate random number to determine if the shot hits
        int max = 100;
        int min = 1;
        int randInt = min + (int) (Math.random() * ((max - min) + 1));
        // determine if the shot hits based off accuracy
        if (randInt <= 69) { // the shot hits
            return damage;
        } else { // the shot misses
            return 0;
        }
    }

    @Override
    public String getType() {
        return type;
    }
}
