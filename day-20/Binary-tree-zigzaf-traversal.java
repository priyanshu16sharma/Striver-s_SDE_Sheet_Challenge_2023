

import java.util.* ;
import java.io.*; 
/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
		List<Integer> arr = new ArrayList<Integer>();
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		int check = 1;
		while(!q.isEmpty()){
			check = 1-check;
			int size = q.size();
			ArrayList<Integer> tempArr = new ArrayList<Integer>();
			for(int i=0; i<size; i++){
				BinaryTreeNode<Integer> temp = q.peek();
				q.remove();
				if(temp==null) continue;
				if(temp.left !=null){
					q.add(temp.left);
				}
				if(temp.right!=null){
					q.add(temp.right);
				}

				tempArr.add(temp.data);
			}

			if(check==1) Collections.reverse(tempArr);

			arr.addAll(tempArr);
		}

		return arr;

	}
}
