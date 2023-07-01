//Problem-link: https://www.codingninjas.com/studio/problems/pair-sum-in-bst_8230756?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/

public class Solution {
	public static class BSTiterator{
		Stack<BinaryTreeNode> st = new Stack<>();
		boolean isReverse;
		BSTiterator(BinaryTreeNode root, Boolean reverse){
			isReverse = reverse;
			fillStack(root);
		}

		int getVal(){
			BinaryTreeNode node = st.pop();
			if(isReverse) fillStack(node.left);
			else fillStack(node.right);

			return node.data;
		}

		void fillStack(BinaryTreeNode root){
			
				while(root!=null){
					st.add(root);
					root = isReverse? root.right : root.left;
				}
		}
	}
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
		// Write your code here.
		BSTiterator i1 = new BSTiterator(root, false);
		BSTiterator i2 = new BSTiterator(root, true);

		int i = i1.getVal();
		int j = i2.getVal();
		while(i<j){
			if(i+j==k) return true;
			else if(i+j>k) j = i2.getVal();
			else i = i1.getVal();
		}

		return false;
	}
}

