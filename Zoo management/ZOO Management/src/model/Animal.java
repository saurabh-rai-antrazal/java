package model;

/*
 *********************************************************************************************************
 *  @Java Class Name :   Animal
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This is the Abstract Animal class which is extended by zoo animals.
 *********************************************************************************************************
 */

abstract public class Animal {
    private static int animalsCnt = 1; // Start at 0, increment when creating animals

    // INSTANCE
    private String name;
    private int age;
    private double weight;
    private boolean isAlive = true;
    private int perCageCapacity = 0;

    
    // CONSTRUCTORS
    public Animal(String name, int age, double weight, int perCageCapacity) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.perCageCapacity = perCageCapacity;
        animalsCnt++; // Increment count when an animal is created
    }

    // ABSTRACT METHODS
    public abstract String getSound();
    public abstract String getCategory();


    // GETTERS
    public String getName() {
        return name;
    }  

    public int getAge() {
        return age;
    } 

    public double getWeight() {
        return weight;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public int getPerCageCapacity() {
        return perCageCapacity;
    }

    public static int getAnimalCnt() {
        return animalsCnt;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setPerCageCapacity(int perCageCapacity) {
        this.perCageCapacity = perCageCapacity;
    }
}
