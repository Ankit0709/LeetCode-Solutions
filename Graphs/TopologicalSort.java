// /TopologicalSort
//Link : https://www.geeksforgeeks.org/topological-sorting/
import java.util.*;
class TopologicalSort{
	int V;
	ArrayList<Integer> adj[];
	TopologicalSort(int v){
		V=v;
		adj=new ArrayList[V+1];
		for(int i=1;i<=v;i++){
			adj[i]=new ArrayList<>();
		}
	}
	public void addEdge(int src,int dest,boolean bid){
		adj[src].add(dest);
		if(bid){
			adj[dest].add(src);
		}
	}

	
	//1.Approch for Topo Sort Using DFS

	public void topologicalSort(){
		boolean[] vis=new boolean[V+1];
		// LinkedList<Integer> ans=new LinkedList<>();
		Stack<Integer> ans=new Stack<>();
		for(int i=1;i<=V;i++){
			if(!vis[i]){
				dfs(i,vis,ans);
			}
		}
		while(!ans.isEmpty()){
			System.out.print(ans.pop()+" ");
		}
	}
	public void dfs(int src,boolean[] vis,Stack<Integer> ans){
		vis[src]=true;
		for(Integer x:adj[src]){
			if(!vis[x]){
				dfs(x,vis,ans);
			}
		}
		ans.push(src);
	}

	//2.Approach for Topo Sort Using BFS (Kahn's Algo)
	public void topologicalSortBFS(){
		Queue<Integer> queue=new LinkedList<>();
		int[] indegree=new int[V+1];
		for(int i=1;i<=V;i++){
			Iterator<Integer> it=adj[i].listIterator();
			while(it.hasNext()){
				int x=it.next();
				indegree[x]++;
			}
		}

		for(int i=1;i<=V;i++){
			if(indegree[i]==0){
				queue.add(i);
			}
		}

		while(!queue.isEmpty()){
			int rp=queue.poll();
			System.out.print(rp+" ");
			for(Integer x:adj[rp]){
				indegree[x]--;
				if(indegree[x]==0){
					queue.add(x);
				}
			}
		}

	}

}