//problem-link: https://www.codingninjas.com/studio/problems/floor-in-bst_8230753?challengeSlug=striver-sde-challenge&leftPanelTab=0


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

    // static int floorfun(TreeNode<Integer> root, int x, int max){
    //     if(root==null) return max;
    //     if(root.data<=x && root.data>max) max = root.data;

    //     if(root.data>x) max = floorfun(root.left, x, max);
    //     if(root.data<x) max = floorfun(root.right, x, max);

    //     return max;
    // }

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        //return floorfun(root, X, -1);
        int max=-1;
        while(root!=null){
            if(root.data==X) return X;
            else if(root.data>X) root = root.left;
            else{
                max = root.data;
                root = root.right;
            }
        }
        return max;
    }
}