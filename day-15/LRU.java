import java.util.HashMap;

public class LRUCache
{
    int size=0;
    int capacity=0;
    public class pair{
        int key;
        int value;
        pair next;
        pair prev;
        pair(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev= null;
        }

    }
    pair head = new pair(-1, -1);
    pair tail = null;
    HashMap<Integer,pair> hm = new HashMap<>();
    LRUCache(int capacity)
    {
        // Write your code here
        this.capacity = capacity;
    }

    public int get(int key)
    {
        // Write your code here
        pair temp = hm.get(key);
        if(hm.containsKey(key)){
            if(temp==tail) tail = temp.prev==head? temp:temp.prev;
            if(temp.next!=null){
                temp.next.prev = temp.prev;
            }
            temp.prev.next=temp.next;
        
            temp.next = head.next;
            if(head.next!=null){
            head.next.prev = temp;
            }
            temp.prev = head;
            head.next = temp;
            hm.put(key, temp);

            return temp.value;
        }
        return (int)-1;
       
    }

    public void put(int key, int value)
    {
        pair temp = new pair(key, value);
        if(size==0) tail = temp;
        if(hm.containsKey(key)){
            pair removable = hm.get(key);

            if(removable==tail) tail = removable.prev;

            if(removable.next!=null){
                removable.next.prev = removable.prev;
            }
            removable.prev.next=removable.next;
        
            temp.next = head.next;
            if(head.next!=null){
            head.next.prev = temp;
            }
            temp.prev = head;
            head.next = temp;
            hm.put(key, temp);

            return;
        }

            if(size==capacity)
            {
                hm.remove(tail.key);
                tail.prev.next = null;
                tail = tail.prev;
                size--;
            }
            temp.next = head.next;
            if(head.next!=null){
            head.next.prev = temp;
            }
            temp.prev = head;
            head.next = temp;
            hm.put(key, temp);
            
            size++;
            return;

        

    }
}
 
