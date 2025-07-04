package day23.Exercise44;

public class Contact {
    // write code here
    private String name;
    private String phoneNumber;
    
    
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber){
        Contact newContact = new Contact(name, phoneNumber);
        // newContact.name = name;
        // newContact.phoneNumber = phoneNumber;

        return newContact;
    }
    
}