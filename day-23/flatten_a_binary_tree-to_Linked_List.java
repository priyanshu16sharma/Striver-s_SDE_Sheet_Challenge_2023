//problem-link: https://www.codingninjas.com/studio/problems/flatten-binary-tree-to-linked-list_8230817?challengeSlug=striver-sde-challenge&leftPanelTab=1
import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure.

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
	static class ans{
	TreeNode<Integer> prev = null;
	public void linkedList(TreeNode<Integer> root){
		if(root==null) return;

		linkedList(root.right);
		linkedList(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
		return;
	}
	}
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root)
    {
        // Write your code here.
		ans a = new ans();
		a.linkedList(root);
		return root;
    }
}