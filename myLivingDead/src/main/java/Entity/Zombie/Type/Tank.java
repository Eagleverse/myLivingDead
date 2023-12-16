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

    private int hit() {
        // generate random number to determine if the zombie hits.
        int max = 100;
        int min = 1;
        int randInt = min + (int) (Math.random() * ((max - min) + 1));
        //These guys are heavy but can't swing their arms too well.
        if (randInt <= 75) { //Their arms meet their target 75% of the time.
            return damage;
        } else { // Missed.
            return 0;
        }
    }

    @Override
    public void doAttack(Entity target) {
        target.onAttack(hit());
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
