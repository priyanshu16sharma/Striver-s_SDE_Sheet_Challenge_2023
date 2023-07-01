//problem-link: https://www.codingninjas.com/studio/problems/preorder-traversal_8230856?challengeSlug=striver-sde-challenge



import java.util.* ;
import java.io.*; 
/*
	
	Following is the Binary Tree node structure:

	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}

*/

public class Solution {
	static void preOrder(TreeNode root, List<Integer> arr){
        if(root == null) return;
		arr.add(root.data);
        preOrder(root.left,arr);
        preOrder(root.right,arr);
        
        return;
    }
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	// Write your code here.
		List<Integer> arr = new ArrayList<>();
        preOrder(root, arr);
        return arr;
    }
}