//problem-link: https://www.codingninjas.com/studio/problems/maximum-path-sum-between-two-leaves_8230713?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Tree node structure
	
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

public class Solution {
	static class solve{
		long max=0;
	 long maxSum(TreeNode root, long val){
		if(root==null) return 0;

		long left = maxSum(root.left, val);
		long right = maxSum(root.right, val);
		val = left+right+root.data;
		max = Math.max(max, val);
		return Math.max(left, right)+root.data;
	}
	}
	public static long findMaxSumPath(TreeNode root) {
		// Write your code here.
		if(root==null || root.left==null || root.right==null) return -1;
		long val = 0;
		solve ans = new solve();
		ans.maxSum(root, val);

		return ans.max;
	}
}