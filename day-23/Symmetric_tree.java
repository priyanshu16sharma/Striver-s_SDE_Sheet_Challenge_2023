//problem-link: https://www.codingninjas.com/studio/problems/symmetric-tree_8230686?challengeSlug=striver-sde-challenge

/*****************************************************************

    Following is the representation for the Binary Tree Node:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

****************************************************************/

public class Solution {

    static boolean mirror(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2){
        if(root1==null && root2==null) return true;

        if(root1==null || root2==null|| !root1.data.equals(root2.data)) return false;

        
        return mirror(root1.left, root2.right) && mirror(root1.right, root2.left);
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {

        // Write your code here.
        if(root==null) return true;
        return mirror(root.left, root.right);
    }
}