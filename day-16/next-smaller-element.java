//problem-link: https://www.codingninjas.com/codestudio/problems/1112581?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1


import java.util.*;
import java.io.*;

public class Solution{

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        int arrA[] = new int[arr.size()];
        st.push(-1);

        for(int i=n-1; i>=0; i--){
            int curr = arr.get(i);
            while(st.size()>1 && st.peek()>=curr){
                st.pop();
            }

            arrA[i]=st.peek();
            st.push(curr);
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<arrA.length; i++){
            ans.add(arrA[i]);
        }

        return ans;
        
    }
}