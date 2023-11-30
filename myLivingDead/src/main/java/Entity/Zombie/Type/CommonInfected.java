package Entity.Zombie.Type;
import Entity.Entity;
import Entity.Zombie.Zombie;

public class CommonInfected extends Zombie {
    private int health = 30;
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
