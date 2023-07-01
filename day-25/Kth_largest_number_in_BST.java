//problem-link: https://www.codingninjas.com/studio/problems/k-th-largest-number-bst_8230750?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
	static int K;
	public static int helperfun(TreeNode<Integer> root){
		if(root==null) return -1;

		int right = helperfun(root.right);
		K--;
		if(right != -1) return right;
		if(K==0) return root.data;

		int left = helperfun(root.left);
		return left;
	}
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		// Write your code here.
		K=k;
		return helperfun(root);
	}
}