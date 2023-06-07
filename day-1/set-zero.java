import java.io.*;
import java.util.* ;

public class Solution {
    static void setzero(int matrix[][], int row, int col){
        for(int i=0; i<matrix[row].length; i++){
            matrix[row][i]=0;
        }

        for(int j=0; j<matrix.length; j++){
            matrix[j][col]=0;
        }
    }
    public static void setZeros(int matrix[][]) {
        // Write your code here..
        int matrixcp[][] = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrixcp[i][j] = matrix[i][j];
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrixcp[i][j]==0){
                    setzero(matrix, i, j);
                }
            }
        }

    }

}