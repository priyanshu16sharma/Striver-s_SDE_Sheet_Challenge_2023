//problem-link: https://www.codingninjas.com/studio/problems/size-of-largest-bst-in-binary-tree_8230743?challengeSlug=striver-sde-challenge
import java.util.* ;
import java.io.*; 
/*************************************************************************

    Following is the class structure of the Node class:

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

*************************************************************************/

public class Solution {
	public static class info{
		int min; int max; int size;
		info(int min, int max, int size){
			this.min = min;
			this.max = max;
			this.size = size;
		}
	}

	public static info findLargestBst(TreeNode<Integer> root){
		if(root==null) return new info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

		info left = findLargestBst(root.left);
		info right = findLargestBst(root.right);

		int min = Math.min(root.data, left.min);
		int max = Math.max(root.data, right.max);
		int size = left.size + right.size +1;
		if(root.data>left.max && root.data<right.min){
			return new info(min, max, size);
		}

		return new info(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
	}
	public static int largestBST(TreeNode<Integer> root) {
		// Write your code here.
		return findLargestBst(root).size;
	}
}
