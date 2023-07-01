//Problem-link: https://www.codingninjas.com/studio/problems/kth-largest-element-in-a-stream_8230728?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
public class Kthlargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Comparator comp = pq.comparator();
    int k;
    Kthlargest(int k, int[] arr) {
        // Write your code here.
        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);
        }
        this.k = k;
    }

    void add(int num) {
        // Write your code here.
        pq.add(num);
        if(pq.size()>k) pq.poll();
    }

    int getKthLargest() {
        // Write your code here.
        return pq.peek();
    }
}
