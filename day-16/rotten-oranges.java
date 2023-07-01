import java.util.*;

public class Solution {
	static class node{
		int row;
		int col;
		int time;
		node(int row, int col, int time){
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	public static int minTimeToRot(int[][] grid, int n, int m) {
		// Write your code here.
		Queue<node> q = new LinkedList<>();
		int count =0;
		int vis[][] = new int[n][m];
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j]==2){
					q.add(new node(i,j,0));
					//vis[i][j]=2;
				}

				if(grid[i][j]==1){
					count++;
				}
			}
		}

		int drow[] = {-1,0,1,0};
		int dcol[] = {0,1,0,-1};
		int max = 0;
		int cnt = 0;


		while(!q.isEmpty()){
			int row = q.peek().row;
			int col = q.peek().col;
			int t = q.peek().time;
			max = Math.max(max, t);
			q.remove();
			
			for(int i=0; i<4; i++){
				int currow = row+drow[i];
				int curcol = col+dcol[i];
		
				if(currow>=0 && currow<grid.length && curcol>=0 && curcol<grid[0].length && grid[currow][curcol]==1){
					grid[currow][curcol] = 2;
					q.add(new node(currow, curcol,t+1));
					cnt++;
				}
			}

		}
		if(count!=cnt) return -1;
		return max;
	}

}