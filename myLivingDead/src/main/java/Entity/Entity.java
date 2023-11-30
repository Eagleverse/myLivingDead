package Entity;

public abstract class Entity {
    private int health;
    private int damage;
    private boolean isAlive;

    public abstract void doAttack(Entity target);

    public abstract void onAttack(int damage);

    public abstract boolean checkAlive();
}
