package day23.Exercise44;

import java.lang.*;
import java.util.ArrayList;

public class MobilePhone {
    // write code here
    private String myNumber;
    private ArrayList<Contact> myContacts;
    
    public MobilePhone(String number){
        this.myNumber = number;
        myContacts = new ArrayList<Contact>();
    }
    
    public boolean addNewContact(Contact contact){
        int idx = this.findContact(contact);
        if(idx >= 0){
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int idx = this.findContact(oldContact);
        if(idx != -1){
            myContacts.set(idx, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        int idx = this.findContact(contact);
        if(idx != -1){
            myContacts.remove(idx);
            return true;
        }
        return false;
    }

    private int findContact(Contact contact){
        return this.findContact(contact.getName());
    }

    private int findContact(String name){
        int idx = 0;
        for(Contact it: myContacts){
            if(name == it.getName()){
                return idx;
            }
            idx += 1;
        }
        return -1;
    }

    public Contact queryContact(String name){
        return findContact(name) == -1 ? null : myContacts.get(findContact(name));
    }
    
    public void printContacts(){
        System.out.println("Contact List:");
        int cnt = 1;
        for(Contact it : myContacts){
            System.out.println(cnt + ". " + it.getName() + " -> " + it.getPhoneNumber());
            cnt += 1;
        }
    }
    
}
