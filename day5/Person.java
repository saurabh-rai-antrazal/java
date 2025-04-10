public class Person {
    // write code here
    private String firstName, lastName;
    private int age;
    
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public int getAge(){
        return this.age;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setAge (int age){
        if(age < 0 || age > 100){
            this.age = 0;
            return;
        }
        this.age = age;
    }
    
    public boolean isTeen(){
        if(this.age > 12 && this.age < 20) return true;
        return false;
    }
    
    public String getFullName (){
        if(this.firstName.length() == 0 && this.lastName.length() == 0) return "";
        if(this.lastName.length() == 0) return firstName;
        if(this.firstName.length() == 0) return lastName;
        
        return firstName + " " + lastName;
    }
}