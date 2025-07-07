package view;

import model.*;
import utils.animalEnum.AnimalCategory;
import utils.constant.Const;
import utils.validator.InputValidator;

import java.util.Map;

/*
 *********************************************************************************************************
 *  @Java Class Name :   AnimalView
 *  @Author          :   <Saurabh rai>(Saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class performs CRUD operations on the Zone table.
 *********************************************************************************************************
 */

public class AnimalView {

    public static void printAnimalsName(){
        System.out.println(Const.TABLE_BORDER);
        System.out.println(Const.HEADER_NO_NAME);
        System.out.println(Const.TABLE_BORDER);
        for (int i = 1; i <= Const.ANIMALS_LIST.length; i++) {
            System.out.printf(Const.ROW_FORMAT,i, Const.ANIMALS_LIST[i-1][0]);
        }
        System.out.println(Const.TABLE_BORDER);
    }

    public static Animal addNewAnimal(int zooId){
        Animal animal = null;
        int opt;
        System.out.println(Const.ZOO_MESSAGES[0]);
        printAnimalsName();
        opt = ZooView.chooseOption(Const.ANIMALS_LIST.length + 1);
        String name = Const.ANIMALS_LIST[opt - 1][0];
        String category = Const.ANIMALS_LIST[opt - 1][1];
        String sound = Const.ANIMALS_LIST[opt - 1][2];
        int perCageCapacity = Integer.parseInt(Const.ANIMALS_LIST[opt - 1][3]);
        boolean flag = false;
        int age;
        String ip = "";
        System.out.print(Const.ZOO_MESSAGES[1]);
        while(!flag){
            ip = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidAge(ip) && Integer.parseInt(ip) <= 100);
            if (!flag) {
                System.out.print(Const.ZOO_MESSAGES[2]);
            }
        }
        age = Integer.parseInt(ip);
        flag = false;
        double weight;
        ip = "";
        System.out.print(Const.ZOO_MESSAGES[3]);
        while(!flag){
            ip = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidWeight(ip) && Double.parseDouble(ip) <= 1001);
            if (!flag) {
                System.out.print(Const.ZOO_MESSAGES[4]);
            }
        }
        weight = Math.round(Double.parseDouble(ip) * 100.0) / 100.0;
        if(category.equalsIgnoreCase(AnimalCategory.MAMMAL.toString())) {
            animal = new Mammal(category, name, age, weight, sound, perCageCapacity);
        }
        if(category.equalsIgnoreCase(AnimalCategory.BIRD.toString())) {
            animal = new Bird(category, name, age, weight, sound, perCageCapacity);
        }
        if(category.equalsIgnoreCase(AnimalCategory.REPTILE.toString())) {
            animal = new Reptile(category, name, age, weight, sound, perCageCapacity);
        }
        if(category.equalsIgnoreCase(AnimalCategory.FISH.toString())) {
            animal = new Fish(category, name, age, weight, sound, perCageCapacity);
        }
        return animal;
    }

    public static int removeDeadAnimal(Map<Integer, String> animalList){
        showAnimalList(animalList);
        String animalId = "";
        boolean flag = false;
        System.out.print(Const.ZOO_MESSAGES[8]);
        while (!flag) {
            animalId = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidOptions(animalId) && animalList.get(Integer.parseInt(animalId)) != null);
            if (!flag) {
                System.out.print(Const.ZOO_MESSAGES[9]);
            }
        }
        return Integer.parseInt(animalId);
    }

    public static void showAnimalList(Map<Integer, String> animalList) {
        System.out.println(Const.TABLE_BORDER);
        System.out.println(Const.HEADER_ID_ANIMAL);
        System.out.println(Const.TABLE_BORDER);
        int i = 1;
        animalList.forEach((K, V) -> System.out.printf(Const.ROW_FORMAT, K, V));
        System.out.println(Const.TABLE_BORDER);
    }


    public static void showAnimalCategory(){
        System.out.println(Const.TABLE_BORDER);
        System.out.println(Const.HEADER_NO_OPTION);
        System.out.println(Const.TABLE_BORDER);
        int i = 1;
        for(AnimalCategory animalCategory : AnimalCategory.values()){
            System.out.printf(Const.ROW_FORMAT,i , animalCategory.name());
            i += 1;
        }
        System.out.println(Const.TABLE_BORDER);
    }

    public static void animalListIsEmpty(){
        System.out.println(Const.NO_ANIMALS_MESSAGE);
    }
}
