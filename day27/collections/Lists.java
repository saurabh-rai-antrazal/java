package day27.collections;

import java.util.*;

public class Lists {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        // initial capacity : 10;
        li.add(1);
        li.add(1, 3);
        li.add(9); // tc : o(n)

        li.set(0, 2); // tc : o(1)
        li.add(0);
        li.add(3);

        System.out.println(Integer.parseInt(li.contains((Integer) 0)));


        System.out.println(li.toString());


        // List<Integer> li1 = List.of(1, 2, 3, 4); // immutable list
        List<Integer> li2 = Arrays.asList(1, 2, 3, 4); // mutable but size is fixed

        // System.out.println(li1.toString());
        // li2.add(0); // length is fixed
        li2.set(0, 9);
        li2.remove(0); // length is fixed
        System.out.println(li2.toString());


        List<Integer> ll = new LinkedList<>();
        ll.add(e);
        ll.add(0, List.of(1, 2, 3));


    }
    

}
