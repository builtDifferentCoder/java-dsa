class Node{
    int data;
    Node next;
}
public class LinkedList{
    Node head;
    public void insert(int data){
        Node n=new Node();
        n.data=data;
        if(head==null){
            head=n;
        }
        else{
            Node curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=n;
        }
    }
    public int delete(int index){
        Node curr=head;
        for(int i=0;i<index-1;i++){
            curr=curr.next;
        }
        Node temp=curr.next;
        curr.next=temp.next;
        return temp.data;
    }
    public void insertAt(int data,int index){
        Node curr=head;
        Node n=new Node();
        n.data=data;
        if (index==0) {
            n.next=head;
            head=n;
        }
        else{
            for(int i=0;i<index-1;i++){
            curr=curr.next;
        }
        Node temp=curr.next;
        curr.next=n;
        n.next=temp;
        }
    }
    public void reverse(){
        Node prev=new Node();
        Node curr=head;
        Node next=head;
        while(curr!=null){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void show(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
    }
}