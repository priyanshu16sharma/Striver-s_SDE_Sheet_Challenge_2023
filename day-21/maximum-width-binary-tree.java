//problem-link:  https://www.codingninjas.com/codestudio/problems/maximum-width-in-binary-tree_763671?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	   }
	}


************************************************************/

public class Solution {
	public static int getMaxWidth(TreeNode root) {
		// Write your code here.
        if(root==null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
		int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
			max = Math.max(max, size);
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                

                if(node.left!=null) q.add(node.left);

                if(node.right!=null) q.add(node.right);
            }
        }

        return max;
	}
}