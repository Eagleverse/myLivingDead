package Entity.Survivor.Type;

import Entity.Entity;
import Entity.Survivor.Survivor;

public class Teacher extends Survivor {
    private int health = 50;
    private int damage = 5;
    private boolean isAlive = true;

    @Override
    public void doAttack(Entity target) {
        target.onAttack(damage);
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
}
