import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the TreeNode class:

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


*****************************************************************/
import java.text.Normalizer.Form;
import java.util.ArrayList;

public class Solution {

    public static TreeNode<Integer> formTree( int st, int end, ArrayList<Integer> arr){

        if(st>end) return null;
        int mid = (st+end)/2;
        TreeNode<Integer> root = new TreeNode<Integer>(arr.get(mid));

        root.left = formTree( st, mid-1, arr);
        root.right = formTree( mid+1, end, arr);
        return root;
    }
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        // Write your code here.
        
        return formTree( 0, arr.size()-1, arr);
    }
}