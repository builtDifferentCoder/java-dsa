import java.util.HashMap;
import java.util.Map;

class LRUNode{
    int  key;
    int value;
    LRUNode next;
    LRUNode prev;
    public LRUNode(int key, int value){
        this.key = key;
        this.value = value;
        next=null;
        prev=null;
    }
}

class LRU{
    Map<Integer,LRUNode> map;
    LRUNode head;
    LRUNode tail;
    int capacity;
    public LRU(int capacity){
        map=new HashMap<>();
        head=new LRUNode(0,0);
        tail=new LRUNode(0,0);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }
    public void addNode(LRUNode node){
        LRUNode tailPrev=tail.prev;
        node.next=tail;
        node.prev=tailPrev;
        tailPrev.next =node;
        tail.prev=node;
    }
    public void removeNode(LRUNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void moveToTail(LRUNode node){
        removeNode(node);
        addNode(node);
    }
    public int get(int key){
        LRUNode node=map.get(key);
        if(node==null) return -1;
        moveToTail(node);
        return node.value;
    }
    public void set(int key,int value){
        LRUNode node=map.get(key);
        if(node!=null){
            node.value=value;
            moveToTail(node);
        }else{
            if(map.size()>=capacity){
            //remove the node
                LRUNode headNext=head.next;
                removeNode(headNext);
                map.remove(headNext.key);
            }
            //we are going to insert the node
            LRUNode newNode=new LRUNode(key,value);
            map.put(key,newNode);
            addNode(newNode);
        }

    }
}