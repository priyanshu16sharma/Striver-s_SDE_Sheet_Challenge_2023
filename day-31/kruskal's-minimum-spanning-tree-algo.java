//problem-link:  https://www.codingninjas.com/studio/problems/kruskal-s-minimum-spanning-tree-algorithm_8230804?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
public class Solution {

    public static class disjoint{
        ArrayList<Integer> parent = new ArrayList<Integer>();
        ArrayList<Integer> size = new ArrayList<>();
        disjoint(int n){
            for(int i=0; i<n+1; i++){
                parent.add(i);
                size.add(1);
            }
        }

        int findpar(int node){
            if(parent.get(node)==node) return node;

            int parentnode = findpar(parent.get(node));
            parent.set(node, parentnode);
            return parentnode;

        }

        void unionBySize(int u, int v){
            int uparent = findpar(u);
            int vparent = findpar(v);

            if(uparent == vparent) return;
            if(size.get(uparent)>size.get(vparent)){
                parent.set(vparent, uparent);
                size.set(uparent, size.get(uparent)+size.get(vparent));
            }else{
                parent.set(uparent, vparent);
                size.set(vparent, size.get(vparent)+size.get(uparent));
            }
        }
    }
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        // Write your code here.
        disjoint dj = new disjoint(n);
        graph.sort(Comparator.comparingInt(a->a.get(2)));
        int ans = 0;
        for(int i=0; i<graph.size(); i++){
            int u = graph.get(i).get(0);
            int v = graph.get(i).get(1);
            int wt = graph.get(i).get(2);

            if(dj.findpar(u)!=dj.findpar(v)){
                ans+=wt;
                dj.unionBySize(u, v);
            }
        }

        return ans;
    }
}