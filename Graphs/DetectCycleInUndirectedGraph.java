//DetectCycleInUndirectedGraph
//Problem Link : https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
import java.util.*;
class DetectCycleInUndirectedGraph{
	int V;
	ArrayList<Integer> adj[];
	DetectCycleInUndirectedGraph(int v){
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

	//Detect Cycle in undirected graph we will check whether that vertex is visited and 
	//it should be not a parent then cycle exists
	public boolean dfs(int src,int par,boolean[] vis){
		vis[src]=true;
		for(Integer child:adj[src]){
			if(!vis[child]){
				if(dfs(child,src,vis)){
					return true;
				}
			}
			else if(child!=par){
				return true;
			}
		}
		return false;
	}
	public boolean cycleExists(){
		boolean[] vis=new boolean[V+1];
		for(int i=1;i<=V;i++){
			if(!vis[i]){
				if(dfs(i,-1,vis)){
					return true;
				}
			}
		}
		return false;
	}



	//2.Using BFS For Detecing Cycle --> We just need to find that whether we are visiting the visited node once again
	// and it is not our parent
	public boolean cycleExistsBFS(){
		boolean[] vis=new boolean[V+1];
		int[] par=new int[V+1];
		Queue<Integer> queue=new LinkedList<>();		
		for(int i=1;i<=V;i++){
			if(!vis[i]){
				if(cycleUtil(i,vis,par)){
					return true;
				}
			}
		}
		return false;
	}
	public boolean cycleUtil(int src,boolean[] vis,int[] par){
		Queue<Integer> queue=new LinkedList<>();
		queue.add(src);
		par[src]=-1;
		vis[src]=true;
		while(!queue.isEmpty()){
			int rp=queue.poll();
			for(Integer child:adj[rp]){
				if(!vis[child]){
					queue.add(child);
					par[child]=rp;
					vis[child]=true;
				}
				else if(child!=par[rp]){
					return true;
				}
			}
		}
		return false;
	}
}