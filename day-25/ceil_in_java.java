//problem-link: https://www.codingninjas.com/studio/problems/ceil-from-bst_8230754?challengeSlug=striver-sde-challenge&leftPanelTab=1
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
    // static int ceilfun(TreeNode<Integer> root, int x, int min){
    //     if(root==null) return min;
    //     if(root.data>=x && root.data<min) min = root.data;

    //     if(root.data>x) min = ceilfun(root.left, x, min);
    //     if(root.data<x) min = ceilfun(root.right, x, min);

    //     return min;
    // }

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
        // int ans = ceilfun(node, x, (int)1e9);
        // if (ans==(int)1e9) return -1;

        // return ans;

        int ans = -1;
        while(node!=null){
            if(node.data == x) return node.data;

            else if(node.data>x){
                ans = node.data;
                node = node.left;

            } else{
                node= node.right;
            }
        }

        return ans;

    }
}
