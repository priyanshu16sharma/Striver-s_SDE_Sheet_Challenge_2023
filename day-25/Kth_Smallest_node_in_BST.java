//problem-link;:https://www.codingninjas.com/studio/problems/kth-smallest-node-in-bst_8230751?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/


public class Solution 
{
	static int K;
	public static int helperfun(TreeNode<Integer> root){
		if(root==null) return -1;

		int left = helperfun(root.left);
		K--;
		if(left != -1) return left;
		if(K==0) return root.data;

		int right = helperfun(root.right);
		return right;
	}
	public static int kthSmallest(TreeNode<Integer> root, int k) 
	{
		//  Write your code here.
		K=k;
		return helperfun(root);
	}

}
