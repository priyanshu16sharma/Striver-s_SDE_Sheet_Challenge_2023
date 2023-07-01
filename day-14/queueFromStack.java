//problem-link: https://www.codingninjas.com/codestudio/problems/day-25-queue-using-stack_8230722?challengeSlug=striver-sde-challenge

import java.util.*;
public class Queue {
    // Define the data members(if any) here.
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> outSt = new Stack<Integer>();
    Queue() {
        // Initialize your data structure here.
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        
        while(!st.isEmpty()){
            outSt.push(st.pop());
        }
        st.push(val);
        while(!outSt.isEmpty()){
            st.push(outSt.pop());
        }
        return;
    }

    int deQueue() {
        // Implement the dequeue() function.
        if(st.isEmpty()) return (int) -1;
        return st.pop();
    }

    int peek() {
        // Implement the peek() function here.
        if(st.isEmpty()) return (int) -1;
        return st.peek();

    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        if(st.isEmpty()) return true;
        return false;
    }
}