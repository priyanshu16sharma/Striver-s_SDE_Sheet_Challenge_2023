//Problem-link:  https://www.codingninjas.com/studio/problems/flood-fill-algorithm_8230806?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.*;

public class Solution
{
    static class pair{
        int x, y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void floodfill(int image[][], int x, int y, int newColor, int oldColor, int drow[], int dcol[]){
        if(x<0 || x>=image.length || y<0 || y>=image[0].length ||image[x][y]!=oldColor || image[x][y]==newColor){
            return;
        }

        image[x][y]=newColor;
        

          floodfill(image, x-1, y+0, newColor, oldColor, drow, dcol);
         floodfill(image, x+0, y+1, newColor, oldColor, drow, dcol);
         floodfill(image, x+1, y+0, newColor, oldColor, drow, dcol);
         floodfill(image, x+0, y-1, newColor, oldColor, drow, dcol);
        return;

    }
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        // Write your code here
        
        // Queue<pair> q = new LinkedList<>();
        // q.add(new pair(x,y));
        int oldColor = image[x][y];
        // image[x][y] = newColor;
         int drow[]= {-1,0,1,0};
         int dcol[] = {0,1,0,-1};

        // while(!q.isEmpty()){
        //     int r = q.peek().x;
        //     int c = q.peek().y;
            

        //     q.remove();

        //     for(int i=0; i<4; i++){
        //         int nrow = r+drow[i];
        //         int ncol = c+dcol[i];

        //         if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length && image[nrow][ncol]==oldColor && image[nrow][ncol]!=newColor){
        //             image[nrow][ncol] = newColor;
        //             q.add(new pair(nrow, ncol));
        //         }

        //     }
        // }
        floodfill(image, x, y, newColor, oldColor, drow, dcol);
        return image;
    }
}

