package model;

/*
 *********************************************************************************************************
 *  @Java Class Name :   Cage
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class is used to create a cage.
 *********************************************************************************************************
 */

public class Cage {
    private int maxCapacity;
    private int currentCapacity;
    private String animal_type;
    
    public Cage(int maxCapacity, int currentCapacity, String animal_type) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.animal_type = animal_type;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }
}
