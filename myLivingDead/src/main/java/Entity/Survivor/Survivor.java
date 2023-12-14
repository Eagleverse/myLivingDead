package Entity.Survivor;

import Entity.Entity;
import Weapon.Weapon;

public abstract class Survivor extends Entity {
    private int health;
    private int damage;
    private boolean isAlive;
    private int countType;
    public Weapon weapon;
}
