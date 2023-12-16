package Weapon.Type;

import Weapon.Weapon;

public class Crowbar implements Weapon {
    private final String type = "crowbar";
    private final int damage = 7;
    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getType() {
        return type;
    }
}
