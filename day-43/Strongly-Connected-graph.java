//problem-link: https://www.codingninjas.com/studio/problems/strongly-connected-components-tarjan-s-algorithm_8230789?challengeSlug=striver-sde-challenge


import java.util.*;

public class Solution {

    static void toposort(int i, ArrayList<ArrayList<Integer>> adj, int v[], Stack<Integer> st){
        v[i]=1;

        for(int it: adj.get(i)){
            if(v[i]!=1)
            toposort(it, adj, v, st);
        }

        st.push(i);
    }

    static ArrayList<Integer> dfs2(int node,ArrayList<ArrayList<Integer>> adjT, int vis[], ArrayList<Integer> ans){
        vis[node]=1;
        ans.add(node);

        for(int it: adjT.get(node)){
            if(vis[it]==0) dfs2(it, adjT, vis, ans);
        }

        return ans;

    }


    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<n; i++)adj.add(new ArrayList<Integer>());
        

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
        }

        Stack<Integer> st = new Stack<>();
        int vis[] = new int[n];

        for(int i=0; i<n; i++){
        if(vis[i]==0)
        toposort(i,adj, vis, st);
        }

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<n; i++) transpose.add(new ArrayList<Integer>());

        for(int i=0; i<n; i++){
            vis[i]=0;
            for(int it: adj.get(i)){
                transpose.get(it).add(i);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        while(!st.isEmpty()){
            int node = st.pop();

            if(vis[node]==0) ans.add(dfs2(node, transpose,vis, new ArrayList<>()));
        }

        return ans;
   }
}