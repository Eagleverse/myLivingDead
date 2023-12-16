package Entity.Survivor.Type;

import Entity.Entity;
import Entity.Survivor.Survivor;
import Weapon.Weapon;
import Weapon.Gun;

import java.util.Arrays;
import java.util.List;

public class Child extends Survivor {
    private int health = 20;
    private Weapon weapon;
    private boolean isAlive = true;
    private int typeCount;

    public Child(int num, Weapon weapon) {
        typeCount = num;
        this.weapon = weapon;
    }
    
    @Override
    public void doAttack(Entity target) {
        // Get the interfaces that the weapon implements
        List<Class<?>> interfaces = Arrays.asList(weapon.getClass().getInterfaces());
        // If it implements the gun interface
        if (interfaces.contains(Gun.class)) {
            // Cast the weapon to a gun so the fire method is available
            Gun gun = (Gun) weapon;
            // attack target
            target.onAttack(gun.fire());
        } else { // if the weapon is not a gun
            target.onAttack(weapon.getDamage());
        }
    }

    @Override
    public void onAttack(int damage) {
        health -= damage;
        // if this entities health is 0 or less they are dead
        if (health <= 0) {
            isAlive = false;
        }
    }

    @Override
    public boolean checkAlive() {
        return isAlive;
    }

    @Override
    public int getTypeCount() {
        return typeCount;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }
}
