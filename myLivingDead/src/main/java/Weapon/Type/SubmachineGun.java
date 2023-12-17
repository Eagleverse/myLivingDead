package Weapon.Type;

import Weapon.Gun;

public class SubmachineGun implements Gun {

    public SubmachineGun() {

    }
    private final String type = "submachine gun";
    private final int damage = 12;
    private final int accuracy = 65;
    //Harder to manage
    private int ammo = 17;

    @Override
    public boolean hasAmmo() {
        return ammo > 0;
    }

    @Override
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
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getType() {
        return type;
    }
}
