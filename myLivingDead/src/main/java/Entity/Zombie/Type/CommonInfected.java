package Entity.Zombie.Type;

import Entity.Entity;
import Entity.Zombie.Zombie;

public class CommonInfected extends Zombie {

    private int health = 30;
    final private int damage = 5;
    private boolean isAlive = true;
    private int typeCount;

    public CommonInfected(int num) {
        typeCount = num;
    }

    private int hit() {
        // generate random number to determine if the zombie hits.
        int max = 100;
        int min = 1;
        int randInt = min + (int) (Math.random() * ((max - min) + 1));
        //These guys are accurate but not too strong.
        if (randInt <= 95) { //Their arms meet their target 95% of the time.
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
