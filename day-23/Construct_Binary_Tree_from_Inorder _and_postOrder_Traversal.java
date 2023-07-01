import java.util.HashMap;

/************************************************************
  
   Following is the TreeNode class structure
   
   class TreeNode<T> { 
        T data; 
        TreeNode<T> left;
        TreeNode<T> right;
  
        TreeNode(T data) { 
            this.data = data; 
            left = null; 
            right = null; 
        }
   }
    
 ************************************************************/

public class Solution {
  public static TreeNode<Integer> formTree(HashMap<Integer, Integer> hm,int inOrder[], int instart, int inend, int postOrder[], int poststart, int postend){
    if(instart>inend || poststart>postend) return null;
    
    TreeNode<Integer> root = new TreeNode<Integer>(postOrder[postend]); 
    int inroot = hm.get(postOrder[postend]);
    int rightlen = inend-inroot;
    int leftlen = inroot-instart;

    root.left = formTree(hm, inOrder, instart, inroot-1, postOrder, poststart, poststart+leftlen-1);
    root.right = formTree(hm, inOrder, inroot+1, inend, postOrder, postend-rightlen, postend-1);
   
    return root;
  }
	public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
		// Write your code here.
    TreeNode<Integer> root = null;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i=0; i<inOrder.length; i++) hm.put(inOrder[i], i);
    return formTree(hm,inOrder, 0, inOrder.length-1,postOrder,0, postOrder.length-1);
	}
}
