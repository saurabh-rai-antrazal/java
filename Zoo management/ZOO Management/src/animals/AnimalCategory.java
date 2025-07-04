package animals;

/*
 *********************************************************************************************************
 *  @Java Class Name :   AnimalCategory
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   Category of animals
 *********************************************************************************************************
 */


public enum AnimalCategory {
    MAMMAL,
    BIRD,
    REPTILE,
    FISH;

    @Override
    public String toString() {
        return name();
    }
}




