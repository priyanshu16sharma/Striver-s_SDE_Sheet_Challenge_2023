//problem-link:   https://www.codingninjas.com/codestudio/problems/893110?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1


import java.util.* ;
import java.io.*; 
/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/


public class Solution {
    static class pair{
        BinaryTreeNode bt;
        int rank;
       
        pair(BinaryTreeNode bt, int rank){
            this.bt = bt;
            this.rank = rank;
        }
    }
    
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
         // Write your code here.         
         ArrayList<Integer> arr = new ArrayList<Integer>();
         if(root==null) return arr;

         HashMap<Integer,Integer> hm = new HashMap();
         Queue<pair> q = new LinkedList<pair>();

         hm.put(0,root.val);

         q.add(new pair(root,0));
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         
         while(!q.isEmpty()){
             int size = q.size();
             for(int i=0; i<size; i++){

                 BinaryTreeNode node = q.peek().bt;
                 int rank = q.peek().rank;
                 q.remove();
                 min = Math.min(min,rank);
                 max = Math.max(max,rank);

                 if(node.left!=null){
                     q.add(new pair(node.left, rank-1));
                     hm.put(rank-1, node.left.val);
                 }

                 if(node.right!=null){
                     q.add(new pair(node.right, rank+1));
                     hm.put(rank+1, node.right.val);
                 }
             }

         }

         for(int i=min; i<=max; i++){
             arr.add(hm.get(i));
         }

         return arr;
    }
}
