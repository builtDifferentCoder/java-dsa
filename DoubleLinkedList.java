class DNode{
    int data;
    DNode prev;
    DNode next;
}

public class DoubleLinkedList {
    
    DNode head;
    public void insert(int data){
        DNode node=new DNode();
        node.data=data;
        if(head==null){
            head=node;
            head.next=null;
            head.prev=null;
        }
        else{
            DNode curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=node;
            node.prev=curr;
        }
    }
    public void delete(int index){
        DNode curr=head;
        for(int i=0;i<index-1;i++ ){
            curr=curr.next;
        }
        DNode temp=curr.next;
        curr.next=temp.next;
        temp.next.prev=curr;
        }
    public void show(){
         DNode curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
    }
}
