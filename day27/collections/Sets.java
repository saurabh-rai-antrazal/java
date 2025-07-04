package day27.collections;

import java.util.*;

public class Sets {
    public static void main(String[] args) {
        // random order
        Set<Integer> hs = new HashSet<>();

        System.out.println(hs.add(1));
        System.out.println(hs.add(1));
        hs.add(3);
        hs.add(32);
        hs.add(0);
        hs.add(28);

        System.out.println(hs.toString());

        // sorted
        Set<Integer> ts = new TreeSet<>();

        ts.add(38);
        ts.add(0);
        ts.add(3);
        ts.add(1);
        ts.add(9);
        ts.add(2);
        ts.add(38);
        ts.add(29);

        System.out.println(ts.toString());

        // 
        Set<Integer> ls = new LinkedHashSet<>();
        ls.add(0);
        ls.add(2);
        ls.add(-9);
        ls.add(-9);

        System.out.println(ls.toString());
        System.out.println(ls.contains(1));
        System.out.println(ls.contains(2));
    }
}
