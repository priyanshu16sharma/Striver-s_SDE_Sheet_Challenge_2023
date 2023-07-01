//problem-link:https://www.codingninjas.com/studio/problems/dfs-traversal_8230690?challengeSlug=striver-sde-challenge

import java.util.*;

public class Solution {
    static ArrayList<Integer> dfs(int v,ArrayList<ArrayList<Integer>> edges, ArrayList<Integer> ans, int vis[]){
        vis[v]=1;
        ans.add(v);
        for(int i: edges.get(v)){
            if(vis[i]==0){
                dfs(i,edges,ans,vis);
            }
        }

        return ans;
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        int vis[] = new int[v];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<v;i++) graph.add(new ArrayList<>());
        for(int i=0; i<e; i++){
            ArrayList<Integer> edge = edges.get(i);
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        // ArrayList<Integer> temp =  new ArrayList<Integer>();

        for(int i=0; i<v; i++){
            if(vis[i]==0){
            ArrayList<Integer> arr = dfs(i, graph, new ArrayList<Integer>(), vis);
            Collections.sort(arr);
            ans.add(arr);
            }

        }

        return ans;

    }
}