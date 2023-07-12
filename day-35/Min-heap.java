//problem-link: https://www.codingninjas.com/studio/problems/min-heap_8230863?challengeSlug=striver-sde-challenge&leftPanelTab=1



import java.util.* ;
import java.io.*; 

public class Solution {
    static class Heap{
         ArrayList<Integer> heap = new ArrayList<>();

         void add(int x){
            heap.add(x);
            int index = heap.size()-1;
            int par = (index-1)/2;

            while(heap.get(index)<heap.get(par)){
                int temp = heap.get(index);
                heap.set(index, heap.get(par));
                heap.set(par, temp);
                index = par;
                par = (index-1)/2;
            }


        }

         void heapify(int i){
            int min = i;
            int left = 2*min +1;
            int right = 2*min +2;

            if(left<heap.size()&&heap.get(left)<heap.get(min)){
                min = left;
            }

            if(right<heap.size()&&heap.get(right)<heap.get(min)){
                min = right;
            }

            if(min!=i){
                int temp = heap.get(i);
                heap.set(i, heap.get(min));
                heap.set(min, temp);
                 heapify(min);}
        }

         int remove(){
            int temp = heap.get(heap.size()-1);
                heap.set(heap.size()-1, heap.get(0));
                heap.set(0, temp);

            int a = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            heapify(0);

            return a;
        }
    }

    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        int arrSize = 0;
        for(int i=0; i<n; i++) {if(q[i][0]==1) arrSize++;}

        int ans[] = new int[arrSize];

        Heap hp = new Heap();
        int ansCount = 0;

        for(int i=0; i<q.length; i++){
            if(q[i][0]==0) hp.add(q[i][1]);
            else{  ans[ansCount]=hp.remove(); ansCount++;}
        }

        return ans;

    }
}