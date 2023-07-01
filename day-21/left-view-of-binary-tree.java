//problem-link:  https://www.codingninjas.com/codestudio/problems/920519?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

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

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> arr = new ArrayList<>();
        if(root==null) return arr;

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode<Integer> node = q.poll();
                if(i==0) arr.add(node.data);

                if(node.left!=null) q.add(node.left);

                if(node.right!=null) q.add(node.right);
            }
        }

        return arr;

    }
}
