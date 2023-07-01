//problem-link: https://www.codingninjas.com/codestudio/problems/path-in-a-tree_3843990?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1


import java.util.* ;
import java.io.*; 
/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    public static  boolean tracePath(TreeNode node, int x, ArrayList<Integer> arr){
        if(node==null) return false;
        if(node.data==x){
            arr.add(node.data);
            return true;
        }
        arr.add(node.data);
        if(tracePath(node.left, x, arr)) return true;
        if(tracePath(node.right, x, arr)) return true;
        arr.remove(arr.size()-1);
        return false;
    }
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> arr = new ArrayList<Integer>();
        tracePath(root, x, arr);
        return arr;
    }
}