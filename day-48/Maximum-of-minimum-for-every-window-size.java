//problem-link: https://www.codingninjas.com/studio/problems/maximum-of-minimum-for-every-window-size_8230783?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        
		Stack<Integer> st = new Stack<>();
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        for(int i=0; i<n; i++){

            while(!st.isEmpty() && a[st.peek()]>=a[i]) st.pop();

            if(!st.isEmpty()) left[i]=st.peek();

            st.push(i);
        }

        while(!st.isEmpty()) st.pop();

        for(int i=n-1; i>=0; i--){
             while(!st.isEmpty() && a[st.peek()]>=a[i]) st.pop();

            if(!st.isEmpty()) right[i]=st.peek();

            st.push(i);
        }

        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);

        for(int i=0; i<n; i++){
            int len = right[i]-left[i]-1;

            ans[len-1]=Math.max(ans[len-1], a[i]);

        }

        for(int i=n-2; i>=0; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }

        return ans;
    }
}

