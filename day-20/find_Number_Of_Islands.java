//Problem-link: https://www.codingninjas.com/codestudio/problems/630512?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website



import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class Solution 
{
    static class node{
        int r;
        int c;
        
        node(int r, int c){
            this.r = r;
            this.c = c;
            
        }
    }

    static void landcnt (int mat[][], int vis[][], int srcrow, int srccol){
        Queue<node> q = new LinkedList<>();
        q.add(new node(srcrow, srccol));
        
        vis[srcrow][srccol]=1;

        int drow[] = {-1,0,1,0,-1,-1,1,1};
        int dcol[] = { 0,1,0,-1,-1,1,-1,1};
        ArrayList<Integer> temp2 ;
        while(!q.isEmpty()){
            int x = q.peek().r;
            int y = q.peek().c;
            q.remove();

            for(int i=0; i<8; i++){
                int row = x+drow[i];
                int col = y+dcol[i];
                if(row>=0 && row<vis.length && col>=0 && col<vis[0].length && vis[row][col]==0 && mat[row][col]==1){
                    
                    q.add(new node(row, col));
                    vis[row][col]=1;
                    
                }

            }
        }
        
    }
    public static int getTotalIslands(int[][] mat) 
	{
        //Your code goes here
        int vis[][] = new int[mat.length][mat[0].length];
        int cnt=0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1 && vis[i][j]==0){
                    landcnt(mat, vis, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}