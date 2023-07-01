//problen-link: https://www.codingninjas.com/codestudio/problems/span-of-ninja-coin_1475049?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    static class pair{
        int val;
        int span;

        pair(int val, int span){
            this.val = val;
            this.span = span;
        }
    }
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        Stack<pair> st = new Stack<>();
        //st.add(new pair(-1,0));
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<price.size(); i++){
            if(st.isEmpty()){
                st.add(new pair(price.get(i), 1));
                ans.add(1);
                continue;
            }
        
            if(st.peek().val<=price.get(i)){
                int span=0;
                while(!st.isEmpty()&&st.peek().val<=price.get(i)){
                span+=st.peek().span;
                st.pop();
                }
                ans.add(span+1);
            }else{
                ans.add(1);
            }
        

            st.add(new pair((int)price.get(i), (int)ans.get(i)));
        }

        return ans;
    }
}