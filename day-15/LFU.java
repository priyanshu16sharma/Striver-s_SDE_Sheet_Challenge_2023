// problem-link:https://www.codingninjas.com/studio/problems/lfu-cache_8230851?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;

import org.w3c.dom.Node;

import java.io.*; 

public class LFUCache {

	class pair{
		int key;
		int val;
		int freq;
		pair next;
		pair prev;
		pair(int key, int val){
			this.key = key;
			this.val = val;
			this.freq=1;
			this.next = null;
			this.prev = null;
		}
	}
	pair head = new pair(-1,-1);
	pair tail = null;
	int capacity;
	int size=0;
	HashMap<Integer, pair> hm = new HashMap<>();

	LFUCache(int capacity) {
		// Write your code here.
		this.capacity = capacity;
	}

	int get(int key) {
		// Write your code here.
		if(hm.containsKey(key)){
			pair temp = hm.get(key);

			temp.freq++;
			pair temp2 = temp.next;
			
			while(temp2!=null && temp2.next!=null && temp2.next.freq<=temp.freq ){
				temp2 = temp2.next;
			}
			if(temp2!=null){
			temp.next = temp2.next;
			temp.prev = temp2;
			if(temp2.next!=null){
			temp2.next.prev = temp;
			}
			temp2.next = temp;
			}
			
			return temp.val;
		}
		return -1;
	}

	void put(int key, int value) {
		// Write your code here.
		if(hm.containsKey(key)){
			pair temp = hm.get(key);

			temp.freq++;
			int num = value;
			temp.val = value;
			pair temp2 = temp.next;
			
			while(temp2!=null && temp2.next!=null && temp2.next.freq<=temp.freq ){
				temp2 = temp2.next;
			}
			if(temp2!=null){
			temp.next = temp2.next;
			temp.prev = temp2;
			if(temp2.next!=null){
			temp2.next.prev = temp;
			}
			temp2.next = temp;
			}
			
			hm.put(key, temp);
			return;
		}

		if(size==capacity){
			hm.remove(head.next.key);
			if(head.next.next!=null){
				head.next.next.prev = head;
			}
			
			head.next = head.next.next;
		}
		
		pair temp = new pair(key, value);
		temp.next = head.next;
		if(head.next!=null){
			head.next.prev = temp;
		}
		head.next = temp;
		temp.prev = head;
		hm.put(key, temp);
		size++;
		return;
	}
}
