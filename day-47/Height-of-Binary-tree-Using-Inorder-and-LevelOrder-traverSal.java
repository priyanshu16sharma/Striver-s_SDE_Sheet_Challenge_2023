//problem-link: https://www.codingninjas.com/studio/problems/height-of-the-binary-tree-from-inorder-and-level-order-traversal_8230730?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 

class Temp {
    int height;
    int leftIndex;
    int rightIndex;

    Temp(int h, int li, int ri) {
        height = h;
        leftIndex = li;
        rightIndex = ri;
    }
}
public class Solution {
    

	public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N){
		// Write your code here.
		
        int maxHeight = 0;
        Queue<Temp> q = new LinkedList<>();

        if (N >= 1) {
            Temp temp = new Temp(0, 0, N - 1);
            q.add(temp);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(inorder[i], i);
        }

        for (int i = 0; i < N; i++) {
            Temp temp = q.poll();

            maxHeight = Math.max(temp.height, maxHeight);

            int li = temp.leftIndex;
            int ri = temp.rightIndex;
            int rootIndex = map.get(levelOrder[i]);

            if (rootIndex - 1 >= li) {
                Temp leftSubTree = new Temp(temp.height + 1, li, rootIndex - 1);
                q.add(leftSubTree);
            }

            if (rootIndex + 1 <= ri) {
                Temp rightSubTree = new Temp(temp.height + 1, rootIndex + 1, ri);
                q.add(rightSubTree);
            }
        }

        return maxHeight;
    }
        
}