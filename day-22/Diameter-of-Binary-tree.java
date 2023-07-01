//problem-link: https://www.codingninjas.com/studio/problems/diameter-of-binary-tree_8230762?challengeSlug=striver-sde-challenge

/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

public class Solution {

	public static class calculateDiameter{
		int max = 0;
	    int diameter(TreeNode<Integer> root){
		if(root==null){
			return 0;
		}

		int left = diameter(root.left);
		int right = diameter(root.right);
		max = Math.max(right+left, max);
		
		return Math.max(left, right)+1;
	}
	}
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		// Write your code here.
		calculateDiameter dia = new calculateDiameter();
		dia.diameter(root);

		return dia.max;
	}
}