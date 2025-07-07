package model;

/*
 *********************************************************************************************************
 *  @Java Class Name :   Bird
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This is the Bird class which creates the bird
 *********************************************************************************************************
 */

public class Bird extends Animal {
    private String sound = "";
    private String category = "";

    public Bird(String category, String name, int age, double weight, String sound, int perCageCapacity) {
        super(name, age, weight, perCageCapacity);
        this.category = category;
        this.sound = sound;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public String getSound() {
        return this.sound;
    }
}