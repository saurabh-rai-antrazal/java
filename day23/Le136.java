package day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Le136 {

    public static void display(){
        System.out.println("0 - shutdown\n" +
                "1 - to add items to list\n" +
                "2 - to remove any item\n");
    }


    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int ip;
        boolean flag = true;
        while(flag){
            display();
            ip = sc.nextInt();
            switch (ip){
                case 0 -> flag = false;
                case 1 ->{
                    String item = sc.next().toLowerCase();
                    int idx = items.indexOf(item);
                    if(idx == -1){
                        items.add(item);
                    }
                }
                case 2 ->{
                    int idx = items.indexOf(sc.next());
                    if(idx == -1){
                        System.out.println("Item not found");
                    }

                }
                default -> System.out.println("invalid input");
            }
        }

        System.out.println(items.toString());
    }
}

