//problem-link: https://www.codingninjas.com/studio/problems/min-stack_8230861?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.* ;
import java.io.*; 

public class Solution {

    static class MinStack {
        class pair{
        int val;
        int curmin;
        pair(int val, int curmin){
            this.val = val;
            this.curmin = curmin;
        }
        }
      //int min;
      Stack<pair> st = new Stack<>();

        // Constructor
        MinStack() {
            // Write your code here.
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            // Write your code here.
            
            if(st.isEmpty()){
                st.push(new pair(num, num));
                return;
            }

            int min = Math.min(st.peek().curmin,num);
            st.push(new pair(num, min));
            return;
        }

        // Function to remove the top element of the stack.
        int pop() {
            // Write your code here.
            if(st.isEmpty()) return -1;

            return st.pop().val;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            // Write your code here.
            if(st.isEmpty()) return -1;

            return st.peek().val;
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            // Write your code here.
            if(st.isEmpty()) return -1;

            return st.peek().curmin;
        }
    }
}