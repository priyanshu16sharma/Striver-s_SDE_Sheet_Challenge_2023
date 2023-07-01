//problem-link: https://www.codingninjas.com/studio/problems/topological-sort_8230784?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 
public class Solution 
{
    static ArrayList<Integer> toposort(ArrayList<ArrayList<Integer>> graph,int v){
        int count[] = new int[v];
        for(int i=0; i<graph.size(); i++){
            for(int it: graph.get(i)){
                count[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<v; i++){
            if(count[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();

        while(!q.isEmpty()){
            int vertex = q.poll();
            ans.add(vertex);
            for(int i: graph.get(vertex)){
                count[i]--;
                if(count[i]==0){
                    q.add(i);
                }
            }
        }

        return ans;
    }
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<v; i++) graph.add(new ArrayList<Integer>());
        for(int i=0; i<e; i++){
            int p = edges.get(i).get(0);
            int q = edges.get(i).get(1);

            graph.get(p).add(q);
        }

        return toposort(graph,v);
    }
}
