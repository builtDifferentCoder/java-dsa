public class Main{
    public static void main(String[] args){
        DoubleLinkedList l=new DoubleLinkedList();
        l.insert(5);
        l.insert(9);
        l.insert(12);
        l.insert(3);
        l.insert(1);
        l.delete(2);
        l.show();
    }
}