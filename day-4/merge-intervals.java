//problem: https://www.codingninjas.com/codestudio/problems/merge-intervals_8230700?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    // 1 3 6 8 10
    // 4 5 8 9 12
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            start[i]=intervals[i].start;
            end[i] = intervals[i].finish;
        }
        int i=1;
        Arrays.sort(start);
        Arrays.sort(end);
        int first = start[0];
        ArrayList<Interval> arr = new ArrayList<>();
        while(i<start.length){
            if(start[i]<=end[i-1]){
                i++;
                continue;
            }else{
                Interval temp = new Interval(first, end[i-1]);
                arr.add(temp);
                first = start[i];
                i++;
            }
        }
        Interval temp = new Interval(first, end[i-1]);
        arr.add(temp);
        return arr;

    }
}
