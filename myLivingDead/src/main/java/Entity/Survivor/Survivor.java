package Entity.Survivor;

import Entity.Entity;
import Weapon.Weapon;

public abstract class Survivor extends Entity {
    private int health;
    private Weapon weapon;
    private boolean isAlive;
    private int countType;

    public abstract Weapon getWeapon();
}
