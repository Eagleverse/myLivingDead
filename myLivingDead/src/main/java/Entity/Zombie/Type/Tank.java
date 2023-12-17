package Entity.Zombie.Type;

import Entity.Entity;
import Entity.Zombie.Zombie;

public class Tank extends Zombie {

    private int health = 150;
    final private int damage = 20;
    private boolean isAlive = true;
    private int typeCount;

    public Tank(int num) {
        typeCount = num;
    }

    @Override
    public void doAttack(Entity target) {
        target.onAttack(this.damage);
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
}
