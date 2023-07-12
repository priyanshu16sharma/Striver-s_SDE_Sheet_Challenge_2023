//problem-link: https://www.codingninjas.com/studio/problems/bellman-ford_8230845?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
public class Solution {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
      // Write your code here.

      int dist[] = new int[n+1];
      Arrays.fill(dist, (int)1e9);
      dist[src] = 0;

      for(int i=0; i<n-1; i++){
        for(ArrayList<Integer> arr: edges){
          int u = arr.get(0);
          int v = arr.get(1);
          int wt = arr.get(2);

          if(dist[u]!=(int)1e9 && dist[u]+wt<dist[v]){
            dist[v]=dist[u]+wt;
          }
        }
      }

      for(ArrayList<Integer> arr: edges){
          int u = arr.get(0);
          int v = arr.get(1);
          int wt = arr.get(2);

          if(dist[u]!=(int)1e9 && dist[u]+wt<dist[v]){
            return (int)1e9;
          }
        }

        return dist[dest];
    }
    
}
