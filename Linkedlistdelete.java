import java.util.Scanner;

public class Linkedlistdelete{
    Node head;
    
    class Node{
        int data;
        Node next;
        //Node head;
        
        Node(int val){
            data = val;
            next = null;
            //head = null;
        }
    }
    Linkedlistdelete(){
        head = null;
    }
    public void insertend(int val){
        Node newnode = new Node(val);
         
        if (head==null){
            head = newnode;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp =  temp.next;       
            }
            temp.next = newnode;
        }
    }
    public void position(int pos , int k){
        Node newnode = new Node(k);
        
        Node temp = head;
        
        for (int i =1;i<pos;i++){
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }
    public void deletebegin(){
        head = head.next;
    }
    public void deleteposition(int d){
        Node temp = head;
        Node prev = null;
        
        for(int i=1;i<d;i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
    }
    public void display(){
        Node temp = head;
        
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.print("Null");
    }
    public static void main(String args[]){
        
        Scanner sc = new Scanner (System.in);
        Linkedlistdelete list = new Linkedlistdelete();
        
        int m = sc.nextInt();
        for (int i =0 ;i<m;i++){
            int val = sc.nextInt();
            list.insertend(val);
        }
        int pos = 2;
        int k = 125;
        
        list.position(2,125);
        
        list.deletebegin();
        
        //list.deleteposition(3);
        
        list.display();
    }
}