//problem link: https://www.codingninjas.com/codestudio/problems/stack-using-queue_8230715?challengeSlug=striver-sde-challenge&leftPanelTab=0


import java.util.* ;
import java.io.*; 
public class Stack {

    // Define the data members.
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public Stack() {
        // Implement the Constructor.

    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        // Implement the getSize() function.
        return q1.size();

    }

    public boolean isEmpty() {
        // Implement the isEmpty() function.
        if(q1.isEmpty() && q2.isEmpty()) return true;
        return false;
    }

    public void push(int element) {
        // Implement the push(element) function.
        if(q1.isEmpty() && q2.isEmpty()){ q1.add(element); return;}
        

        while(!q1.isEmpty()){
            q2.add(q1.peek());
            q1.remove();
        }
        q1.add(element);
        while(!q2.isEmpty()){
            q1.add(q2.peek());
            q2.remove();
        }
    }

    public int pop() {
        // Implement the pop() function.
        if(q1.isEmpty()) return (int)-1;
        return q1.remove();
    }

    public int top() {
        // Implement the top() function.
        if(q1.isEmpty()) return (int)-1;
        return q1.peek();
    }
}