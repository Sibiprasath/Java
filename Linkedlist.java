import java.util.Scanner;

public class Linkedlist{
    Node head;
    
    class Node{
        int data;
        Linkedlist.Node next;
        //Node head;
        
        Node(int val){
            data = val;
            next = null;
            //head = null;
        }
    }
    Linkedlist(){
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
    public void insertbegin(int s){
        Node newnode = new Node(s);
        
        if (head == null){
            head = newnode;
        }
        else{
            newnode.next = head;
            head = newnode; 
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
    public void sort(){
        if(head==null || head.next==null){
            return;
        }
        else
        {
        Node current,index;
        int temp;
        for(current=head;current.next!=null;current=current.next){
            for(index=current.next ; index !=null ; index=index.next)
                {
                    if(current.data>index.data)
                    {
                        temp = current.data;
                        current.data=index.data;
                        index.data=temp;
                    }
                }
            }
        }
    }
    public void dup(){
        Node current = head;
        while (current!=null && current.next!=null){
            if(current.data==current.next.data){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
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
        Linkedlist list = new Linkedlist();
        
        int m = sc.nextInt();
        for (int i =0 ;i<m;i++){
            int val = sc.nextInt();
            list.insertend(val);
        }
        int s =sc.nextInt();
        list.insertbegin(s);

        int pos=sc.nextInt();
        int k=sc.nextInt();

        list.position(pos,k);

        list.deletebegin();
        //list.deleteposition(3);
        list.sort();
        list.dup();
        list.display();
    }
}