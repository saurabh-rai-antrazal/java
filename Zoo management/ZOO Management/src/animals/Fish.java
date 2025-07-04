package animals;

/*
 *********************************************************************************************************
 *  @Java Class Name :   Fish
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This is the Fish class which creates the fish
 *********************************************************************************************************
 */

public class Fish extends Animal {
    private String sound = "";
    private String category = "";

    public Fish(String category, String name, int age, double weight, String sound, int perCageCapacity) {
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