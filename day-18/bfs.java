//problem-link: https://www.codingninjas.com/studio/problems/bfs-in-graph_8230763?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 


public class Solution {

	static void Bfs(int v, int vis[], ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> graph ){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		vis[v]=1;
		ans.add(q.peek());
		while(!q.isEmpty()){
			
			int vertex = q.peek();
			q.remove();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i: graph.get(vertex)){
				if(vis[i]==0){
				q.add(i);
				vis[i]=1;
				arr.add(i);
				}
			}
			Collections.sort(arr);
			ans.addAll(arr);
		}

		

	}
	public static ArrayList<Integer> BFS(int vertex, int edges[][]){
		// WRITE YOUR CODE HERE
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<vertex; i++){ graph.add(new ArrayList<Integer>());}
		for(int i=0; i<edges[0].length; i++){
				graph.get(edges[0][i]).add(edges[1][i]);
				graph.get(edges[1][i]).add(edges[0][i]);
		}

		int vis[] = new int[vertex];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i=0; i<vertex; i++){
			if(vis[i]==0){
				Bfs(i, vis, ans, graph);
			}
		}
		//Collections.sort(ans);
		return ans;
	}
}

