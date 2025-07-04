package day21.List;

class Node{
    public int val;
    public Node next;

    Node(int val, Node obj){
        this.val = val;
        this.next = obj;
    }

    Node(int val){
        this.val = val;
        this.next = null;
    }

    Node(){
        this.val = 0;
        this.next = null;
    }
}

public class LinkList {

    public static void main(String[] args) {
        Node root = new Node(0);
        root.next = new Node(1);
        root.next.next = new Node(2);
        root.next.next.next = new Node(3);
        root.next.next.next.next = new Node(4);
        
        Node ll2 = new Node();
        ll2.val = 7;
        ll2.next = new Node(8, root);


        Node crawler = ll2;
        while(crawler != null){
            System.out.println(crawler.val);
            crawler = crawler.next;
        }
    }

}
