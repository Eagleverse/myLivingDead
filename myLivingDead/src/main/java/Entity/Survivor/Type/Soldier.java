package Entity.Survivor.Type;

import Entity.Entity;
import Entity.Survivor.Survivor;

public class Soldier extends Survivor {

    private int health = 100;
    private int damage = 10;
    private int accuracy = 100;
    private boolean isAlive = true;
    private int typeCount;

    public Soldier(int num) {
        typeCount = num;
    }

    public void setDamage(int weaponDamage, int weaponAccuracy) {
        //Replace default damage upon recieving item
        //Depends on accuracy roll in doAttack
        this.damage = weaponDamage;
        this.accuracy = weaponAccuracy;
    }

    @Override
    public void doAttack(Entity target) {
        int attackDamage = rollForAccuracy(this.accuracy);
        target.onAttack(attackDamage);
    }

    @Override
    public void onAttack(int damage) {
        health -= damage;
        // if this entities health is 0 or less they are dead
        if (health <= 0) {
            isAlive = false;
        }
    }

    public int rollForAccuracy(int weaponAccuracy) {
        // Binary hit or miss for now.
        int foo = (int) (Math.random() * 100);
        if (foo < weaponAccuracy) // 0-W.A
        {
            //Sweet spot where the weapon hit in the range of W.A% of the time
            return this.damage;
        } else // W.A+1 -> 99
        {
            // Oops, the dice wanted a higher accuracy than the max. 0 damage.
            return 0;
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
