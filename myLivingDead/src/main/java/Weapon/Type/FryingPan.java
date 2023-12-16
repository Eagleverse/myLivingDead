package Weapon.Type;

import Weapon.Weapon;

public class FryingPan implements Weapon {
    private final String type = "frying pan";
    private final int damage = 4;
    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getType() {
        return type;
    }
}
