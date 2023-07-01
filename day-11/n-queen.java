//problem-link: https://www.codingninjas.com/codestudio/problems/n-queens_8230707?challengeSlug=striver-sde-challenge


import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> addList(int row[][]){
      ArrayList<Integer> arr = new ArrayList<>();
      for(int i=0; i<row.length; i++){
          for(int j=0; j<row[0].length; j++){
              arr.add(row[i][j]);
          }
      }

      return arr;
    }
    public static void queen(int j, int row[][], int n, ArrayList<ArrayList<Integer>> ans){
        if(j==n){ 
            ans.add(addList(row));
            return;
        }

        for( int i=0; i<n; i++){
            if(isValid(row,i,j)){
            row[i][j]=1;
            queen( j+1,row, n, ans);
            row[i][j]=0;
            }
        }
    }

    public static boolean isValid(int row[][], int i, int j){
        int duprow = i;
        int dupcol = j;
        while(i>=0 && j>=0){
            if(row[i][j]==1) return false;
            i--;
            j--;

        }

        i=duprow;
        j = dupcol;

        while(j>=0){
            if(row[i][j]==1) return false;
            j--;
        }

        j = dupcol;
        while(i<row.length && j>=0){
            if(row[i][j]==1) return false;
            i++; j--;
        }

        return true;
    }
    
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int row[][] = new int[n][n];
        int vis[] = new int[n];
        
            
            queen( 0, row, n, ans);
            
        

        return ans;

    }
}