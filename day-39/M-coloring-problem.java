// problem-link: https://www.codingninjas.com/studio/problems/m-coloring-problem_8230777?challengeSlug=striver-sde-challenge&leftPanelTab=2

import java.util.* ;
import java.io.*; 
public class Solution {

    public static String graphColoring(int[][] mat, int m) {
        
        int[] vis = new int[mat.length];
        int tempnode = -1;
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < mat.length; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                
                if (mat[i][j] == 1) {
                    if(tempnode==-1) tempnode = i;
                    arr.get(i).add(j);
                    //arr.get(j).add(i);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(tempnode);

        vis[tempnode] = 1;
        

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i: arr.get(node)){

                if(vis[i]==0){
                    int col=0;
                    Set<Integer> st = new HashSet<>();
                    for(int j: arr.get(i) ){
                        if(vis[j]!=0) st.add(vis[j]);
                    }

                    for(int j=1; j<=m; j++){
                        if(!st.contains(j)){
                            col = j;
                            break;
                        }
                    }
                    if(col == 0) return "NO";
                    
                    vis[i]=col;
                    q.add(i);
                }
            }

            

        }

        return "YES";
    }
}