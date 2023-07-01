//problem-link: https://www.codingninjas.com/studio/problems/tree-traversals_8230775?challengeSlug=striver-sde-challenge



import java.util.* ;

import javax.swing.tree.TreeNode;

import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
	static void preOrder(BinaryTreeNode<Integer> root, ArrayList<Integer> arr){
		if(root==null) return;

		arr.add(root.data);
		preOrder(root.left, arr);
		preOrder(root.right, arr);
		return;
	}

	static void inOrder(BinaryTreeNode<Integer> root, ArrayList<Integer> arr){
		if(root==null) return;

		inOrder(root.left, arr);
		arr.add(root.data);
		inOrder(root.right, arr);
		
		return;
	}
	static void postOrder(BinaryTreeNode<Integer> root, ArrayList<Integer> arr){
		if(root==null) return;

		postOrder(root.left, arr);
		
		postOrder(root.right, arr);
		arr.add(root.data);
		
		return;
	}

    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
		List<List<Integer>> arr = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();

		inOrder(root, temp);
		arr.add(temp);
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		preOrder(root,temp1);
		arr.add(temp1);
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		postOrder(root, temp2);
		arr.add(temp2);

		return arr;
    }
}
