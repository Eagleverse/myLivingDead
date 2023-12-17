package Weapon.Type;

import Weapon.Weapon;

public class Axe implements Weapon {

    private final String type = "axe";
    private final int damage = 10;

    @Override
    public int getDamage() {

        // generate random number to determine if the shot hits
        int max = 100;
        int min = 1;
        int randInt = min + (int) (Math.random() * ((max - min) + 1));
        // determine if the shot hits based off accuracy
        if (randInt <= 75) { // the shot hits
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
/*
  public int fire() {
        // if the gun has ammo
        if (hasAmmo()) {
            // generate random number to determine if the shot hits
            int max = 100;
            int min = 1;
            int randInt = min + (int) (Math.random() * ((max - min) + 1));
            // determine if the shot hits based off accuracy
            if (randInt <= accuracy) { // the shot hits
                ammo--;
                return damage;
            } else { // the shot misses
                ammo--;
                return 0;
            }
        } else { // if it doesn't have ammo gun does 0 damage
            return 0;
        }
    }*/
