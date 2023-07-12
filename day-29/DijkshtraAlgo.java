//problem-link: https://www.codingninjas.com/studio/problems/dijkstra-s-shortest-path_8230755?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
public class Solution {

	static class pair{
		int node;
		int dist;
		pair(int node, int dist){
			this.node = node;
			this.dist = dist;
		}
	}
	
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		// Write your code here.
		ArrayList<ArrayList<pair>> adj = new ArrayList<ArrayList<pair>>();
		for(int i=0; i<vertices+1; i++) adj.add(new ArrayList<pair>());
		for(ArrayList<Integer> it: vec){
			adj.get(it.get(0)).add(new pair(it.get(1), it.get(2)));
			adj.get(it.get(1)).add(new pair(it.get(0), it.get(2)));
		}

		int weight[] = new int[vertices+1];
		int parent[] = new int[vertices+1];
		for(int i=1; i<vertices+1; i++){ 
			weight[i]=Integer.MAX_VALUE;
		    parent[i]=i;
		}
		weight[source]=0;

		PriorityQueue<pair> pq = new PriorityQueue<>((x,y)->x.dist-y.dist);
		pq.add(new pair(source, 0));

		while(!pq.isEmpty()){
			int node = pq.peek().node;
			int dist = pq.peek().dist;
			pq.remove();
			for(pair it: adj.get(node)){
				int adjNode = it.node;
				int adjWeight = it.dist;

				if(dist+adjWeight<weight[adjNode]){
					weight[adjNode] = dist+adjWeight;
					pq.add(new pair(adjNode , dist+adjWeight));
					parent[adjNode] = node;
				}
			}
		}
		 ArrayList<Integer> path = new ArrayList<>();  
		
        
        
        int node = 0;
        
        for(node = 0; node<vertices ; node++) {
			//if(weight[node]==Integer.MAX_VALUE) continue;
            path.add(weight[node]); 
           // node = parent[node]; 
        }
        
        return path;


	}
}