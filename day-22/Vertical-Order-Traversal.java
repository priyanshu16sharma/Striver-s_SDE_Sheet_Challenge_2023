//problem-link: https://www.codingninjas.com/studio/problems/vertical-order-traversal_8230758?challengeSlug=striver-sde-challenge&leftPanelTab=1


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
    static class pair{
        TreeNode<Integer> node;
        int rank;
        pair(TreeNode<Integer> node, int rank){
            this.node = node;
            this.rank = rank;
        }
    }
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root==null) return ans;
        Map<Integer,ArrayList<Integer>> hm = new HashMap<>();
        Queue<pair>  q = new LinkedList<>();
        q.add(new pair(root,0));

        hm.put(0, new ArrayList<Integer>());
        hm.get(0).add(root.data);

        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode<Integer> node = q.peek().node;
                int rank = q.peek().rank;
                q.remove();
                min = Math.min(rank,  min);
                max = Math.max(rank, max);

                if(node.left!=null){
                    q.add(new pair(node.left, rank-1));
                    if(hm.containsKey(rank-1)){
                        hm.get(rank-1).add(node.left.data);
                    }else{
                        hm.put(rank-1, new ArrayList<Integer>());
                        hm.get(rank-1).add(node.left.data);
                    }
                }

                if(node.right!=null){
                    q.add(new pair(node.right, rank+1));
                    if(hm.containsKey(rank+1)){
                        hm.get(rank+1).add(node.right.data);
                    }else{
                        hm.put(rank+1, new ArrayList<Integer>());
                        hm.get(rank+1).add(node.right.data);
                    }
                }
            }
        }

        for(int i=min; i<=max; i++){
            ans.addAll(hm.get(i));
        }

        return ans;
    }
}
