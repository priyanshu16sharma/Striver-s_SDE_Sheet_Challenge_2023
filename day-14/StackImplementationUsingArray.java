//problem-link: https://www.codingninjas.com/codestudio/problems/stack-implementation-using-array_8230854?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 

public class Stack {
    int arr[];
    int i=0;
    int capacity;
    Stack(int n){
        arr = new int[n];
        this.capacity = n;
    }

    void push(int num) {
        // Write your code here.
        arr[i]=num;
        i++;
    }
    int pop() {
        // Write your code here.
        if(i==0) return (int)-1;
        
        return arr[--i];
    }
    int top() {
        // Write your code here.
        if(i==0) return (int)-1;
        return arr[i-1];
    }
    int isEmpty() {
        // Write your code here.
        if(i==0) return (int)1;
        return (int) 0;
    }
    int isFull() {
        // Write your code here.
        if(i==capacity) return (int)1;
        return (int) 0;
    }
}
