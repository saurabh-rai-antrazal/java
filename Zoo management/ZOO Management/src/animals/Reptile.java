package animals;

/*
 *********************************************************************************************************
 *  @Java Class Name :   Reptile
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This is the Reptile class which creates the reptile
 *********************************************************************************************************
 */

public class Reptile extends Animal {
    private String sound = "";
    private String category = "";
    
    public Reptile(String category, String name, int age, double weight, String sound, int perCageCapacity) {
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