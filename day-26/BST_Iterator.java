//problem-link: https://www.codingninjas.com/studio/problems/bst-iterator_8230815?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
/*
    Definition of Node class for reference

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

*/
public class Solution {

    static class BSTIterator{
        Stack<TreeNode<Integer>> st = new Stack<>();
        BSTIterator(TreeNode<Integer> root){
            // Write your code here
           addNode(root);
        }

        int next(){
            TreeNode<Integer> node = st.pop();
            addNode(node.right);
            return node.data;

        }

        boolean hasNext(){
            // Write your code here
            return !st.isEmpty();
        }

        void addNode(TreeNode<Integer> root){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
        }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
