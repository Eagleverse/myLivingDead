package Entity;

public abstract class Entity {
    private int health;
    private int damage;
    private boolean isAlive;
    private int typeCount;

    public abstract void doAttack(Entity target);

    public abstract void onAttack(int damage);

    public abstract boolean checkAlive();

    public abstract int getTypeCount();

    public void setDamage(int damage1, int accuracy) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
