package Weapon.Type;

import Weapon.Weapon;

public class Axe implements Weapon {
    private final String type = "axe";
    private final int damage = 10;
    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getType() {
        return type;
    }
}
