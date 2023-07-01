//Problem-link: https://www.codingninjas.com/studio/problems/convert-a-given-binary-tree-to-doubly-linked-list_8230744?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 

/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


public class Solution {
	static BinaryTreeNode<Integer> BTtoDLLHelper(BinaryTreeNode<Integer> root ){
		if(root==null) return null;

		BinaryTreeNode<Integer> prev = BTtoDLLHelper(root.left);
		if(prev!=null){
			while(prev.right!=null){
				prev = prev.right;
			}
		prev.right = root;
			 
		}
		root.left = prev;
		
		BinaryTreeNode<Integer> next = BTtoDLLHelper(root.right);
			if(next!=null){
			while(next.left!=null){
				next = next.left;
			}
			next.left = root;
			}
		root.right = next;  


		return root;

	}
	
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		// Write your code here
		if(root==null) return root;
		root = BTtoDLLHelper(root);

		while(root.left!=null) {
			root = root.left;
		}
		return root;
	}
	

}
