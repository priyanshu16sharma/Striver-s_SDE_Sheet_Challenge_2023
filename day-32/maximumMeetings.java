//problem.link: https://www.codingninjas.com/studio/problems/maximum-activities_8230800?challengeSlug=striver-sde-challenge&leftPanelTab=1
import java.util.* ;
import java.io.*; 
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
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        //Write your code here
        ArrayList<meeting> meetingar = new ArrayList<>();
        for(int i=0;i<start.length; i++){
            meeting m = new meeting(start[i], end[i], i+1);
            meetingar.add(m);
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(meetingar, mc);
         List<Integer> ans = new ArrayList<>();
         int limit = meetingar.get(0).end;
         ans.add(meetingar.get(0).rank);

         for(int i=1; i<start.length; i++){
             if(meetingar.get(i).start>limit){
                 ans.add(meetingar.get(i).rank);
                 limit = meetingar.get(i).end;
             }
         }
        

        return ans;
    }
}