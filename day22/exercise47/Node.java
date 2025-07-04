package day22.exercise47;

import java.util.*;

public class Node extends ListItem{
    // write code here
    
    Node(int obj){
        super(obj);
    }

    @Override
    int compareTo(ListItem obj) {
       if(value > obj.value){
        return 1;
       } 
       if(value < obj.value){
        return -1;
       }
       return 0;
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setNext(ListItem obj) {
        rightLink = obj;
        return obj;
    }

    @Override
    ListItem setPrevious(ListItem obj) {
        leftLink = obj;
        return obj;
        
    }
    
    
    
}
