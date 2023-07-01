

import java.util.* ;
import java.io.*; 
/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/

public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	// Write your code here.
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		BinaryTreeNode<Integer> curr = null;
		while(!q.isEmpty()){
			int size = q.size();
			

			for(int i=0; i<size; i++){
				curr = q.poll();
				if(i==size-1) curr.next=null;
				else curr.next = q.peek();

				if(curr.left!=null){
					q.add(curr.left);
				}
				if(curr.right!=null){
					q.add(curr.right);
				}
			}
		}

		return;
	}
}