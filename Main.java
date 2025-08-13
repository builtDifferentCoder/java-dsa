

public class Main{

    public static void main(String[] args){

        LFU lfu=new LFU(5);
        lfu.set(1, 1);
        lfu.set(2, 2);
        lfu.set(3, 3);
        lfu.set(4, 4);
        lfu.set(5, 5);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(1));
        lfu.set(6, 6);
        System.out.println(lfu.get(6));
    }
}