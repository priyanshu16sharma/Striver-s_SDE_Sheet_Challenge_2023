//problem-link: https://www.codingninjas.com/studio/problems/detect-cycle-in-a-directed-graph_8230794?challengeSlug=striver-sde-challenge

import java.util.*;
public class Solution {

  static boolean bfs(int vis[], int v, ArrayList<ArrayList<Integer>> graph){
    Queue<Integer> q = new LinkedList<>();
    int count[] = new int[graph.size()];
    for(int i=1;i<graph.size(); i++){
      for(int it: graph.get(i)){
        count[it]++;
      }
    }

    for(int i=1; i<graph.size(); i++){
      if(count[i]==0){ q.add(i); vis[i]=1;}
    }
    int n=0;
    while(!q.isEmpty()){
      int vertex = q.peek();
      n++;
      q.remove();
      for(int i: graph.get(vertex)){
        count[i]--;
        if(count[i]==0){
            q.add(i);
            vis[i]=1;
        }
      }
    }
      if(n==v) return false;

      return true;
    
  }
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){graph.add(new ArrayList<Integer>()); }

        for(int i=0; i<edges.size(); i++){
          int u = edges.get(i).get(0);
          int v = edges.get(i).get(1);
            graph.get(u).add(v);
        }

        int vis[] = new int[n+1];

                if(bfs(vis, n, graph)){
                    return true;
                }
      

    return false;
  }
}