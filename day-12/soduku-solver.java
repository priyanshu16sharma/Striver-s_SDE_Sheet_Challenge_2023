//question-link: https://www.codingninjas.com/codestudio/problems/valid-sudoku_8230704?challengeSlug=striver-sde-challenge&leftPanelTab=1


public class Solution {
	 public static boolean sudokoSolver(int matrix[][], int row, int col, int val){
		for(int j=0; j<9; j++){
			//if(j==col) continue;
			if(matrix[row][j]==val) return false;
			 if(matrix[j][col]==val) return false; 
			int rowNew = (3*(row/3)+j/3);
			int colNew = (3*(col/3)+j%3);
		    if(matrix[rowNew][colNew]==val)return false;
		}

		return true;
	}
	public static boolean isItSudoku(int matrix[][]) {

		// Write your code here.
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(matrix[i][j]==0){
				for(int k=1; k<=9; k++){
					if(sudokoSolver(matrix, i, j, k)){
						matrix[i][j]=k;
						
						if (isItSudoku(matrix))
                            return true;
                        else
                           matrix[i][j] = 0;
						
					}
				}
				return false;				}
			}
		}
		
		return true;
	}
}
