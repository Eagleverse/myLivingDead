/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Weapon.Gun;

import Weapon.Weapon;

/**
 *Extra feature for fancy gun item
 * @author kaifa
 */
public class Gun extends Weapon {
    private int ammo;
    public Gun(String item, int DMG,int ammo) {
        super(item, DMG);
        this.ammo = ammo;
    }
    public boolean hasAmmo(){
        return this.ammo<0;
    }
    public int fire(){
        if(hasAmmo()){
            this.ammo--;
            return this.getDamage();
        }else{
            System.out.println("Out of ammo.");
            return 0;
        }
    }
    
}
