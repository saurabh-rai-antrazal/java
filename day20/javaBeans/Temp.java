package day20.javaBeans;

// A JavaBean is simply a class that doesn't have any constructor
// All instances of JavaBeans are private
// It must have getter and setter methods for all non-static instance variables
// It must have a no-argument (empty) constructor
// JavaBeans are mostly used with frameworks
class Person {
    private String name;
    private int age;
    private String address;
    private long mobileNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString(){
        return this.name + " " + this.age + " " + this.address + " " + this.mobileNo;
    }
}

public class Temp {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Saurabh");
        p1.setAge(24);
        p1.setAddress("Lucknow");
        p1.setMobileNo(9099090909L);

        System.out.println(p1.toString());
    }
}
