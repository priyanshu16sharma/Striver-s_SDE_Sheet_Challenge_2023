//https://www.codingninjas.com/codestudio/problems/reverse-nodes-in-k-group_8230709?challengeSlug=striver-sde-challenge

import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	static Node rotate(Node ptr){
		Node next=null;
		Node prev=null;
		while(ptr!=null){
			next = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = next;
		}
		return prev;
	}
	static Node breakNode(Node next, Node tail, int len){
		Node temp = next;
		while(len>1){
			temp = temp.next;
			len--;
		}
		
		return temp;
	}
	static int size(Node head){
		Node temp = head;
		int cnt =0;
		while(temp!=null){
			cnt++;
			temp = temp.next;
		}
		return cnt;
	}
	static Node merge(Node maintail, Node curr){
		maintail.next = curr;
		Node temp = curr;
		while(temp.next!=null){
			temp = temp.next;
		}
		return temp;
	}
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		// Write your code here.
		Node curr = null;
		Node next = null;
		Node tail = head;
		Node ans = new Node(-1);
		Node maintail = ans;
		int len = size(head);
		int size=0;
		for(int i=0; i<n; i++){
			if(i<n)
			size = b[i]<len? b[i]:len;
			len = len==size? 0: len-b[i];
			if(size!=0){
				next = tail;
				Node temp = breakNode(next,tail,size);
				tail = temp.next;
				temp.next = null;
				curr = rotate(next);
				maintail = merge(maintail,curr);
			}
			//if(i==0)break;
		}
		maintail.next = tail;
		//Node test = new Node(len);
		return ans.next;
	}
}