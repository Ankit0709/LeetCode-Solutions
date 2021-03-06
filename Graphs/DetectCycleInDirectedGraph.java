// /DetectCycleInDirectedGraph
//Problem Link : https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
import java.util.*;
class DetectCycleInDirectedGraph{
	int V;
	ArrayList<Integer> adj[];
	DetectCycleInDirectedGraph(int v){
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
	//we  have to check if a node is visited and it is in the stack so means 
	//there is cycle in the graph else not
	public boolean cycleExists(){
		boolean[] vis=new boolean[V+1];
		boolean[] stack=new boolean[V+1];
		for(int i=1;i<=V;i++){
			if(!vis[i]){
				if(dfs(i,-1,vis,stack)){
					return true;
				}
			}
		}
		return false;
	}
	public boolean dfs(int src,int par,boolean[] vis,boolean[] stack){
		if(stack[src]){
			return true;
		}
		if(vis[src]){
			return false;
		}
		stack[src]=true;
		for(Integer child:adj[src]){			
			if(dfs(child,par,vis,stack)){
				return true;
			}						
		}
		stack[src]=false;
		return false;
	}

	//2.BFS Approach for Directed Graph we will use khan's algo for that and check all nodes are visited or not
	public boolean cycleExistsBFS(){		
		int[] indegree=new int[V+1];		
		int vis=0;
		for(int i=1;i<=V;i++){
			Iterator<Integer> it=adj[i].listIterator();
			while(it.hasNext()){
				indegree[it.next()]++;
			}
		}
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1;i<=V;i++){
			if(indegree[i]==0){
				queue.add(i);
				vis++;
			}
		}
		while(!queue.isEmpty()){
			int rp=queue.poll();
			for(Integer nbrs:adj[rp]){
				indegree[nbrs]--;
			    if(indegree[nbrs]==0){
			    	queue.add(nbrs);
			    	vis++;
			    }				
			}
		}
		return vis!=V;
	}

	
}