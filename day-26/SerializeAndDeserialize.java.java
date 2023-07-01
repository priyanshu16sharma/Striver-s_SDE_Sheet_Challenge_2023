//Problem-Link: https://www.codingninjas.com/studio/problems/serialize-and-deserialize-binary-tree_8230748?challengeSlug=striver-sde-challenge

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    public static void serializeHelper(TreeNode<Integer> root, StringBuilder str){
        if(root==null){
            str.append("N").append(",");
            return ;
        }
        
        str.append(Integer.toString(root.data)).append(",");
        serializeHelper(root.left, str);
        serializeHelper(root.right, str);
    }
    static int idx=0;
    public static TreeNode<Integer> deserializeHelper(Queue<String> q){
        String node = q.remove();
        if(node.equals("N")) return null;

        TreeNode<Integer> root = new TreeNode<Integer>(Integer.parseInt(node));
        root.left = deserializeHelper( q);
        root.right = deserializeHelper( q);

        return root;
    }
    public static String serializeTree(TreeNode<Integer> root)
    {
        //    Write your code here for serialization of the tree.
         StringBuilder str = new StringBuilder("");
        serializeHelper(root, str);
        return str.toString();
    }
    
    public static TreeNode<Integer> deserializeTree(String str)
    {
        //    Write your code here for deserialization of the tree.
        idx=0;
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(str.split(",")));
         return deserializeHelper( q);
        
    }
}
