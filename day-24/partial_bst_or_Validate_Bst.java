


import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution {

    public static boolean isBst(BinaryTreeNode<Integer> root, int bound){
        if(root==null) return true;
        if(root.left!=null && root.left.data > root.data) return false;
        if(root.right!=null && (root.right.data < root.data || root.right.data>bound)) return false;

        return isBst(root.left, root.data) && isBst(root.right, bound);
    }

    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        if(root==null) return true;
        return isBst(root, (int)1e9);
    }
}
