//Problem-Link: https://www.codingninjas.com/studio/problems/predecessor-and-successor-in-bst_8230742?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Tree node structure

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
import javax.swing.tree.TreeNode;

public class Solution {

	static int m = -1;
	public static void inOrder(BinaryTreeNode<Integer> root, ArrayList<Integer> arr, int key){
		if(root==null) return;

		inOrder(root.left, arr, key);
		arr.add(root.data);
		inOrder(root.right, arr, key);
		
	}
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		inOrder(root, arr, key);
		for(int i=0; i<arr.size(); i++){
			if(arr.get(i)==key){
				if(i-1>=0) ans.add(arr.get(i-1));
				else ans.add(-1);

				if(i+1<arr.size()) ans.add(arr.get(i+1));
				else ans.add(-1);

				break;
			}
		}
		return ans;
	}
}