//problem-link: https://www.codingninjas.com/codestudio/problems/799364?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1


import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the BinaryTreeNode class structure:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

*******************************************************/

public class Solution {
    static boolean isIdentical(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2){

        if(root1==null && root2==null) return true;
        else if(root1==null || root2==null || !root1.data.equals(root2.data)) return false;
        

        return (isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
    }
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        // Write you code here.   
        if(isIdentical(root1, root2)) return true;
         return false;
    }

}