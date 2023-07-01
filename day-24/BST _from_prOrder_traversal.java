import java.util.* ;

import javax.swing.tree.TreeNode;

import java.io.*; 
 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
public class Solution {
	static class tree{
	  int index = 1;
	  public void construction(TreeNode<Integer> root, int preOrder[], TreeNode<Integer> parent){
		  
		  if(root.data>preOrder[index]){
			  root.left = new TreeNode<Integer>(preOrder[index++]);
			  construction(root.left, preOrder, root);
		  }

		  if(root.data<preOrder[index] && (parent.data>preOrder[index] || parent.data == preOrder[0])){
			  root.right =  new TreeNode<Integer>(preOrder[index++]);
			  construction(root.right, preOrder, root);
		  }

		  return;
	  }
	}
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 		// Write your code here
		 TreeNode<Integer> root = new TreeNode<Integer>(preOrder[0]);

		 tree.construction(root, preOrder, root);

	}

}
