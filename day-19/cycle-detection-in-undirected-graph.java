//problem-link:https://www.codingninjas.com/studio/problems/cycle-detection-in-undirected-graph_8230798?challengeSlug=striver-sde-challenge

import java.util.*;

public class Solution {
    static class pair{
        int parent;
        int vertex;
        pair(int parent, int vertex){
            this.parent = parent;
            this.vertex = vertex;

        }
    }

    static boolean bfs(int vis[], int v, ArrayList<ArrayList<Integer>> graph){
        Queue<pair> q = new LinkedList<>();
        vis[v]=1;
        q.add(new pair(-1,v));

        while(!q.isEmpty()){
            int vertex = q.peek().vertex;
            int parent = q.peek().parent;
            q.remove();
            for(int i: graph.get(vertex)){
                if(vis[i]==0){
                    q.add(new pair(vertex, i));
                    vis[i]=1;
                }else if(vis[i]==1 && i!=parent){
                    return true;
                }
            }
        }

        return false;
    }


    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){graph.add(new ArrayList<Integer>()); }

        for(int i=0; i<m; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int vis[] = new int[n+1];

        for(int i=1; i<=n; i++){
            if(vis[i]==0){
                if(bfs(vis, i, graph)){
                    return new String("Yes");
                }
            }
        }

        return new String("No");

    }
    
}