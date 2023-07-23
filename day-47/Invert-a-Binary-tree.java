//problem-link: https://www.codingninjas.com/studio/problems/invert-a-binary-tree_8230838?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {
    public static boolean helper(TreeNode<Integer> root, TreeNode<Integer> leaf, Stack<TreeNode<Integer>> st) {
        st.push(root);
        
        if (root.left == null && root.right == null) {
            if (root.data.equals(leaf.data))
                return true;
            else {
                st.pop();
                return false;
            }
        }
        
        if (root.left != null) {
            if (helper(root.left, leaf, st))
                return true;
        }
        
        if (root.right != null) {
            if (helper(root.right, leaf, st))
                return true;
        }
        
        st.pop();
        return false;
    }
    
    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        if (root == null)
            return null;
        
        Stack<TreeNode<Integer>> st = new Stack<>();
        boolean f = helper(root, leaf, st);
        TreeNode<Integer> new_root = st.peek();
        st.pop();
        TreeNode<Integer> par = new_root;
        
        while (!st.empty()) {
            TreeNode<Integer> cur = st.peek();
            st.pop();
            
            if (cur.left == par) {
                cur.left = null;
                par.left = cur;
            } else {
                cur.right = cur.left;
                cur.left = null;
                par.left = cur;
            }
            
            par = cur;
        }
        
        return new_root;
    }
}