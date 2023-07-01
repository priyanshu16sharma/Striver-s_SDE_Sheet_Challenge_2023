//https://www.codingninjas.com/studio/problems/postorder-traversal_8230858?challengeSlug=striver-sde-challenge


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

    static void postOrder(TreeNode root, List<Integer> arr){
        if(root == null) return;

        postOrder(root.left,arr);
        postOrder(root.right,arr);
        arr.add(root.data);
        return;
    }
    public static List < Integer > getPostOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> arr = new ArrayList<>();
        postOrder(root, arr);
        return arr;
    }
}