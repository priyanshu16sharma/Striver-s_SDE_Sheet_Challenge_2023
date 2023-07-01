//problem-link: https://www.codingninjas.com/studio/problems/is-height-balanced-binary-tree_8230771?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/
public class Solution {
    public static class Check{
        int max = 0;
        int checkBalance(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }

        int left = checkBalance(root.left);
        int right = checkBalance(root.right);
        max = Math.max(Math.abs(left-right), max);

        return Math.max(left,right)+1;
        }
    }

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		// Write your code here.
        Check ch = new Check();
        ch.checkBalance(root);
        

        if(ch.max>1) return false;

        return true;
	}
}
