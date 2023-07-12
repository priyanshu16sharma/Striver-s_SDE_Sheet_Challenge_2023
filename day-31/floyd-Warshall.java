//problem-link: https://www.codingninjas.com/studio/problems/floyd-warshall_8230846?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.ArrayList;

public class Solution {
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    // Write your code here.
    n++;
    int matrix[][] = new int[n][n];
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
          matrix[i][j]=(int)1e9;
      }
      matrix[i][i]=0;
    }

    for(int i=0; i<edges.size(); i++){
      int u = edges.get(i).get(0);
      int v = edges.get(i).get(1);
      int wt = edges.get(i).get(2);

      matrix[u][v]=wt;
    }

    for(int k=0; k<n; k++){
      for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
          if(matrix[i][k]!=1e9 && matrix[k][j]!=1e9){
            matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
          }
        }
      }
    }

    return matrix[src][dest];

  }

}
