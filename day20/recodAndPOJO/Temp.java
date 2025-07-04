package day20.recodAndPOJO;

import java.util.*;
import java.lang.*;
import java.io.*;



record Student (String name, int age){
    Student(String name,int age){
        if(age < 0){
            System.out.println("age can not be negative, enter valid age");
        }
        this.name = name;
        this.age = age;
    }
    
    // public void setAge(int age){
    //     this.age = age;
    // }
    // all the instance of pojo is final so it is immutable
}


class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        
        Student s = new Student("saurbh", 24);
        System.out.println(s.name());
        System.out.println(s.age());
        
        Student s2 = new Student("saurbh", -2);
        System.out.println(s2.name());
        System.out.println(s2.age());
        s2.setAge(20);
        System.out.println(s2.age());
    }
}
