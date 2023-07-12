//problem.link: https://www.codingninjas.com/studio/problems/maximum-activities_8230800?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.*;

public class Solution {
    static class meeting{
        int start;
        int end;
        int rank;
        meeting(int start, int end, int rank){
            this.start = start;
            this.end = end;
            this.rank = rank;
        }
    }
    static class meetingComparator implements Comparator<meeting>{
        public int compare(meeting m1, meeting m2){
            if(m1.end<m2.end){
                return -1;
            }else if(m1.end>m2.end){
                return 1;
            }else if(m1.rank<m2.rank) return -1;

            return 1;
        }
    }
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        ArrayList<meeting> meetingar = new ArrayList<>();
        for(int i=0;i<start.size(); i++){
            meeting m = new meeting(start.get(i), end.get(i), i+1);
            meetingar.add(m);
        }
        meetingComparator mc = new meetingComparator();

        Collections.sort(meetingar, mc);
        int limit=meetingar.get(0).end;
        int act=1;

         for(int i=1; i<start.size(); i++){
             if(meetingar.get(i).start>=limit){
                 act++;
                 limit = meetingar.get(i).end;
             }
         }
        

        return act;
    }
}