//problem-link: https://www.codingninjas.com/studio/problems/prim-s-mst_8230809?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.* ;
import java.io.*; 
import java.util.ArrayList;


public class Solution 
{
    static class pair{
        int node;
        int cost;
        int parent;
        pair(int node, int cost, int parent){
            this.node = node;
            this.cost = cost;
            this.parent = parent;
        }
    }

    
    
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        // Write your code here.
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0; i<n+1; i++) adj.add(new ArrayList<ArrayList<Integer>>());

        for(ArrayList<Integer> arr: g){
            ArrayList<Integer> temp1 = new ArrayList<>();
            ArrayList<Integer> temp2 = new ArrayList<>();

            temp1.add(arr.get(1));
            temp1.add(arr.get(2));

            temp2.add(arr.get(0));
            temp2.add(arr.get(2));

            adj.get(arr.get(0)).add(temp1);
            adj.get(arr.get(1)).add(temp2);

        }

        int vis[] = new int[n+1];
        int sum = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y) -> x.cost - y.cost);
        pq.add(new pair(1, 0, -1));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        while(!pq.isEmpty()){
            int parent = pq.peek().parent;
            int node = pq.peek().node;
            int cost = pq.peek().cost;
            pq.remove();
            if(vis[node]==1) continue;
            vis[node] = 1;
            if(parent!=-1){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(parent);
                temp.add(node);
                temp.add(cost);

                ans.add(temp);
            }

            for(ArrayList<Integer> arr: adj.get(node)){
                pq.add(new pair(arr.get(0), arr.get(1), node));
            }
        }

        return ans;

    }
}
