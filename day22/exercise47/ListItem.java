package day22.exercise47;

import java.util.*;

public abstract class ListItem {
    // write code here
    protected ListItem leftLink;
    protected ListItem rightLink;
    protected int value;
    
    ListItem(int obj){
        this.value = obj;
    }
    
    abstract ListItem next();
    
    abstract ListItem setNext(ListItem obj);
    
    abstract ListItem previous();
    
    abstract ListItem setPrevious(ListItem obj);
    
    abstract int compareTo(ListItem obj);
    
    public Object getValue(){
        return value;
    }
    
    public void setValue(int obj){
        this.value = obj;
    }
    
}
