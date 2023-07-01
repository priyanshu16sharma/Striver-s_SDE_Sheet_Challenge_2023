//problem-link: https://www.codingninjas.com/studio/problems/inorder-traversal_8230857?challengeSlug=striver-sde-challenge



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
    static void inOrder(TreeNode root, List<Integer> arr){
        if(root == null) return;
		
        inOrder(root.left,arr);
        arr.add(root.data);
        inOrder(root.right,arr);
        
        return;
    }
    public static List < Integer > getInOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        return arr;
    }
}