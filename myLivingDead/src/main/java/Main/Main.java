/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Entity.Entity;
import Entity.Survivor.Survivor;
import Entity.Survivor.Type.*;
import Entity.Zombie.Zombie;
import Entity.Zombie.Type.*;
import Weapon.Type.*;
import Weapon.Weapon;
import java.util.*;

/**
 *
 * @author kaifa
 */
public class Main {

    private final ArrayList<Entity> survivorList = new ArrayList<>();
    private final ArrayList<Entity> zombieList = new ArrayList<>();

    private int childCount = 0, soldierCount = 0, teacherCount = 0, commonInfectCount = 0, tankCount = 0;

    //create random number of survivors
    public void createSurvivor() {
        Random rand = new Random();
        //generate numbers between 1 and 20
        int numOfSurvivor = rand.nextInt(20) + 1;
        for (int i = 0; i < numOfSurvivor; i++) {
            //generate numbers 0 to 2
            int randNum = rand.nextInt(3);
            switch (randNum) {
                case 0 -> //create Soldier survivor if random number is 0
                {
                    survivorList.add(new Soldier(soldierCount, createWeapon()));
                    soldierCount++;
                }
                case 1 -> //create Teacher survivor if random number is 1
                {
                    survivorList.add(new Teacher(teacherCount, createWeapon()));
                    teacherCount++;
                }

                case 2 -> //create Child survivor if random number is 2
                {
                    survivorList.add(new Child(childCount, createWeapon()));
                    childCount++;
                }

            }
        }
    }

    public Weapon createWeapon() {
        Weapon thisWeapon = null;
        // generate random number between 1 and 7
        int max = 7;
        int min = 1;
        int randInt = min + (int) (Math.random() * ((max - min) + 1));
        switch (randInt) {
            // Create assault rifle if 1
            case 1 ->
                thisWeapon = new AssaultRifle();
            // Create axe if 2
            case 2 ->
                thisWeapon = new Axe();
            // Create crowbar if 3
            case 3 ->
                thisWeapon = new Crowbar();
            // Create frying pan if 4
            case 4 ->
                thisWeapon = new FryingPan();
            // Create pistol if 5
            case 5 ->
                thisWeapon = new Pistol();
            // Create shotgun if 6
            case 6 ->
                thisWeapon = new Shotgun();
            // Create submachine gun if 7
            case 7 ->
                thisWeapon = new SubmachineGun();
        }
        return thisWeapon;
    }

    //create random number of zombies
    public void createZombie() {
        Random rand = new Random();
        //generate numbers between 1 and 10;
        int numOfZombie = rand.nextInt(10) + 1;
        for (int i = 0; i < numOfZombie; i++) {
            //generate numbers 0 to 1
            int randNum = rand.nextInt(2);
            switch (randNum) {
                case 0 -> //create Tank zombie if random number is 0
                {
                    zombieList.add(new Tank(tankCount));
                    tankCount++;
                }

                case 1 -> //create CommonInfected zombie if random number is 1
                {
                    zombieList.add(new CommonInfected(commonInfectCount));
                    commonInfectCount++;
                }

            }
        }
    }

    //each survivor attacks every zombie
    public void survivorAttack() {

        for (int i = 0; i < survivorList.size(); i++) {
            for (int j = 0; j < zombieList.size(); j++) {
                // store current survivor and zombie to neaten code
                Survivor thisSurvivor = (Survivor) survivorList.get(i);
                Zombie thisZombie = (Zombie) zombieList.get(j);
                //if survivor and zombie is alive, survivor attacks
                if (thisSurvivor.checkAlive() && thisZombie.checkAlive()) {
                    thisSurvivor.doAttack(thisZombie);

                    // Check if the survivor killed the zombie
                    if (!thisZombie.checkAlive()) {
                        System.out.println(thisSurvivor.getClass().getSimpleName() + " " + thisSurvivor.getTypeCount()
                                + " killed " + thisZombie.getClass().getSimpleName() + " " + thisZombie.getTypeCount() + " with a "
                                + thisSurvivor.getWeapon().getType());
                    }
                }
            }
        }
    }

    //each zombie attacks every survivor
    public void zombieAttack() {
        for (int i = 0; i < zombieList.size(); i++) {
            for (int j = 0; j < survivorList.size(); j++) {
                // store current survivor and zombie to neaten code
                Survivor thisSurvivor = (Survivor) survivorList.get(j);
                Zombie thisZombie = (Zombie) zombieList.get(i);
                //if zombie is alive, zombie attacks
                if (thisZombie.checkAlive() && thisSurvivor.checkAlive()) {
                    thisZombie.doAttack(thisSurvivor);

                    // Check if the zombie killed the survivor
                    if (!thisSurvivor.checkAlive()) {
                        System.out.println(thisZombie.getClass().getSimpleName() + " " + thisZombie.getTypeCount()
                                + " killed " + thisSurvivor.getClass().getSimpleName() + " " + thisSurvivor.getTypeCount());
                    }
                }
            }
        }
    }

    //check for number of entities alive and return number
    public Integer checkSurvivingEntities(ArrayList<Entity> list) {
        int survivingSurvivors = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).checkAlive()) {
                survivingSurvivors++;
            }
        }
        return survivingSurvivors;
    }

    //prints results
    public void printResults() {
        System.out.println("It seems " + checkSurvivingEntities(survivorList) + " made it to safety.");
    }

    public void run() {
        createSurvivor();
        createZombie();
        int survivorsAlive = checkSurvivingEntities(survivorList);
        int zombiesAlive = checkSurvivingEntities(zombieList);

        // Print opening message.
        System.out.println("We have " + survivorList.size() + " survivors trying to make it to safety " + childCount + " children, " + teacherCount + " teachers, " + soldierCount + " soldiers)");
        System.out.println("But there are " + zombieList.size() + " zombies waiting for them (" + commonInfectCount + " common infected, " + tankCount + " tanks)");

        //while there are still more than 0 survivors alive and more than 0 zombies alive, they attack each other
        while (survivorsAlive > 0 && zombiesAlive > 0) {
            survivorAttack();
            zombieAttack();
            survivorsAlive = checkSurvivingEntities(survivorList);
            zombiesAlive = checkSurvivingEntities(zombieList);
        }
        printResults();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
