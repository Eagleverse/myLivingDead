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
import java.util.*;

/**
 *
 * @author kaifa
 */
public class Main {
    
    private ArrayList<Survivor> survivorList = new ArrayList<>();
    private ArrayList<Zombie> zombieList = new ArrayList<>();
    
    //create random number of survivors
    public void createSurvivor(){
        Random rand = new Random();
        //generate numbers between 1 and 20
        int numOfSurvivor = rand.nextInt(20)+1;
        for(int i=0;i<numOfSurvivor;i++){
            //generate numbers 0 to 2
            int randNum = rand.nextInt(3);
            switch (randNum) {
                case 0://create Soldier survivor if random number is 0
                    survivorList.add(new Soldier());
                    break;
                case 1://create Teacher survivor if random number is 1
                    survivorList.add(new Teacher());
                    break;
                case 2://create Child survivor if random number is 2
                    survivorList.add(new Child());
                    break;
            }
        }
    }
    
    //create random number of zombies
    public void createZombie(){
        Random rand = new Random();
        //generate numbers between 1 and 10;
        int numOfZombie = rand.nextInt(10)+1;
        for(int i=0;i<numOfZombie;i++){
            //generate numbers 0 to 1
            int randNum = rand.nextInt(2);
            switch (randNum) {
                case 0://create Tank zombie if random number is 0
                    zombieList.add(new Tank());
                    break;
                case 1://create CommonInfected zombie if random number is 1
                    zombieList.add(new CommonInfected());
                    break;
            }
        }
    }
    
    //each survivor attacks every zombie
    public void survivorAttack(){
        for(int i=0;i<survivorList.size();i++){
            for(int j=0;j<zombieList.size();j++){
                //if survivor is alive, survivor attacks
                if(survivorList.get(i).checkAlive()==true){
                    survivorList.get(i).doAttack(zombieList.get(j));
                }
            }
        }
    }
    
    //each zombie attacks every survivor
    public void zombieAttack(){
        for(int i=0;i<zombieList.size();i++){
            for(int j=0;j<survivorList.size();j++){
                //if zombie is alive, zombie attacks
                if(zombieList.get(i).checkAlive()==true){
                    zombieList.get(i).doAttack(survivorList.get(j));
                }
            }
        }
    }
    
    //check for number of survivors alive and return number
    public Integer checkSurvivingSurvivors(ArrayList<Survivor> list){
        int survivingSurvivors = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).checkAlive()==true){
                survivingSurvivors++;
            }
        }
        return survivingSurvivors;
    }
    
    //check for number of zombies alive and return number
    public Integer checkSurvivingZombies(ArrayList<Zombie> list){
        int survivingZombies = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).checkAlive()==true){
                survivingZombies++;
            }
        }
        return survivingZombies;
    }
    
    //prints results
    public void printResults(){
        System.out.println("We have " + survivorList.size() + " survivors trying to make it to safety.");
        System.out.println("But there are " + zombieList.size() + " zombies waiting for them.");
        System.out.println("It seems " + checkSurvivingSurvivors(survivorList) + " made it to safety.");
    }
    
    public void run(){
        createSurvivor();
        createZombie();
        int survivorsAlive = checkSurvivingSurvivors(survivorList);
        int zombiesAlive = checkSurvivingZombies(zombieList);
        
        //while there are still more than 0 survivors alive and more than 0 zombies alive, they attack each other
        while(survivorsAlive>0 && zombiesAlive>0){
            survivorAttack();
            zombieAttack();
            survivorsAlive = checkSurvivingSurvivors(survivorList);
            zombiesAlive=checkSurvivingZombies(zombieList);
        }
        printResults();
    }
    
    public static void main(String[] args){
        new Main().run();
        
    }
}
