//Problem-link:  https://www.codingninjas.com/codestudio/problems/implement-a-queue_8230848?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 
public class Queue {
    ArrayList<Integer> arr = new ArrayList<>();
    int i=0;
    Queue() {
        // Implement the Constructor
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        if(arr.size()==i)  return true;
        return false;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        arr.add(data);
    }

    int dequeue() {
        // Implement the dequeue() function
        if(i==arr.size()) return (int)-1;
        return arr.get(i++);
    }

    int front() {
        // Implement the front() function
        if(i==arr.size()) return (int)-1;

        return arr.get(i);
    }

}
