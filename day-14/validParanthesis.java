//problem-link: https://www.codingninjas.com/codestudio/problems/valid-parentheses_8230714?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.*;
public class Solution {
    static boolean checkParanthesis(char first, char second){
        if(first=='(' && second==')') return true;
        else if(first=='{' && second=='}') return true;
        else if(first=='[' && second==']') return true;

        return false;
    }
    public static boolean isValidParenthesis(String expression) {
        // Write your code here.
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch==')' || ch=='}' || ch==']'){
                if(i!=0 && !st.isEmpty() && checkParanthesis(st.peek(), ch)){
                    st.pop();
                    continue;
                }else{
                    return false;
                }
            }
            st.push(ch);
        }

        return st.isEmpty();
    }
}