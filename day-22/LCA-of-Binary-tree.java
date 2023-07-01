//problem-link: https://www.codingninjas.com/studio/problems/lca-of-binary-tree_8230760?challengeSlug=striver-sde-challenge


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

public class Solution 
{
    static boolean tracePath(TreeNode<Integer> root, int data, ArrayList<Integer> arr){
        if(root==null) return false;

        arr.add(root.data);
        
        if(root.data==data) return true;

        if(tracePath(root.left, data, arr)) return true;
        if(tracePath(root.right, data, arr)) return true;

        arr.remove(arr.size()-1);
        
        return false;
    }
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 
    {
        //    Write your code here.
        ArrayList<Integer> path1 = new ArrayList<Integer>();
        ArrayList<Integer> path2 = new ArrayList<Integer>();

        tracePath(root, x, path1);
        tracePath(root, y, path2);

        Set<Integer> s = new HashSet<>();
        for(int i: path1){
            s.add(i);
        }

        for(int i=path2.size()-1; i>=0; i--){
            if(s.contains(path2.get(i))) return path2.get(i);
        }

        return -1;
    }
}
