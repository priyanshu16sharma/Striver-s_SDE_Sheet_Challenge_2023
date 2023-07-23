//problem-link:  https://www.codingninjas.com/studio/problems/boundary-traversal-of-binary-tree_8230712?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;

//import javax.swing.tree.TreeNode;


public class Solution {
	public static void inorder(TreeNode root, ArrayList<Integer> ans){
		if(root==null) return;

		inorder(root.left, ans);
		if(root.left==null && root.right==null) ans.add(root.data);
		inorder(root.right, ans);
	}
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here
		ArrayList<Integer> ans = new ArrayList<>();
		if(root==null)  return ans;
		if(root.left==null && root.right==null){ ans.add(root.data); return ans;}

		//left traversal
		TreeNode temp = root;
		//left
		while(temp!=null){
			if(temp.left!=null || temp.right!=null) ans.add(temp.data);

			if(temp.left!=null || temp == root) temp = temp.left;
			else temp = temp.right;
		}

		//leaf
		inorder(root, ans);

		//right
		temp = root.right;
		ArrayList<Integer> tempArr = new ArrayList<Integer>();
		while(temp!=null){
			if(temp.left!=null || temp.right!=null) tempArr.add(temp.data);

			if(temp.right!=null || temp==root) temp = temp.right;
			else temp = temp.left;
		}

		for(int i=tempArr.size()-1; i>=0; i--){
			ans.add(tempArr.get(i));
		}
		

		return ans;
	}
}