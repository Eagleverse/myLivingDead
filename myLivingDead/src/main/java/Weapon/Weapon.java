/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Weapon;

/**
 *
 * @author kaifa
 */
public class Weapon {

    private final String type;
    private int damage;

    public Weapon(String item, int DMG) {
        this.type = item;
        this.damage = DMG;
    }

    public String getType() {
        return this.type;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int newDamage) {
        //If we want to later add a feature to decreate durabilty over time
        this.damage = newDamage;
    }
    
    public void setDamage(){
        this.damage--;
    }
}
