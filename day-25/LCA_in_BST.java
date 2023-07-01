//problem-link: https://www.codingninjas.com/studio/problems/lca-of-two-nodes-in-a-bst_8230778?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 
/*

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

*/

public class Solution 
{
    public static TreeNode<Integer> lca(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q)
    {
         
          if(root==null ){ return null;}
          // path.add(root);
          if (root.data>p.data && root.data>q.data){ 
              return lca(root.left, p, q);
              }

          if(root.data<p.data && root.data<q.data){
              return lca(root.right, p, q);
          }
          

          return root;
    }
	public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) 
    {		
        // Write your code here
        ArrayList<TreeNode<Integer>> path1 = new ArrayList<>();
        ArrayList<TreeNode<Integer>> path2 = new ArrayList<>();

        return lca(root, p, q);

	}
}


// second method:-

import java.util.* ;
import java.io.*; 
/*

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

*/

public class Solution 
{
    public static boolean lca(TreeNode<Integer> root, TreeNode<Integer> target, ArrayList<TreeNode<Integer>> path)
    {
         
          if(root==null ){ return false;}
          // path.add(root);
          if (root.data.equals(target.data)){ 
              path.add(root);
              return true;
              }

          if(root.data>target.data){
              if(lca(root.left, target, path)){ 
                  path.add(root);
                  return  true;}
          }
          else if(root.data<target.data){
              if(lca(root.right, target, path)){ 
                  path.add(root);
                  return true;}
          }

          return false;
    }
	public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) 
    {		
        // Write your code here
        ArrayList<TreeNode<Integer>> path1 = new ArrayList<>();
        ArrayList<TreeNode<Integer>> path2 = new ArrayList<>();
        lca(root, p, path1);
        lca(root, q, path2);

        int i=0;
        for(i=0; i<path1.size() && i<path2.size(); i++){
            if(path1.get(path1.size()-i-1)!=path2.get(path2.size()-i-1)) break;
        }

        return path1.get(path1.size()-i);

	}
}