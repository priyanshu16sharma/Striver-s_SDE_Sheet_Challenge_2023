//problim.link: https://www.codingninjas.com/studio/problems/number-of-distinct-substring_8230842?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
public class Solution {
    public static class Node{
		Node child[] = new Node[26];
		boolean eos = false;

		Node(){
			Arrays.fill(child, null);
		}
	}

	static Node root = new Node();

	public static int insert(Node root, String word) {
        //Write your code here
		int c=0;
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx] = new Node();
				c++;
            }

            curr = curr.child[idx];
        }

        curr.eos = true;
		return c;
    }
    public static int distinctSubstring(String s) {
        // Write your code here.
        int ans=0;
		Node root = new Node();
		for(int i=0; i<s.length(); i++){
			for(int j=i; j<s.length(); j++){
				ans+=insert(root, s.substring(i, j+1));
			}
		}

		return ans;
    }
}
