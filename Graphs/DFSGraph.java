// /DFSOfGraph
//Link : https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
import java.util.*;
class DFSGraph{
	int V;
	ArrayList<Integer> adj[];
	DFSGraph(int v){
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

	//1.DFS Of graph T(n)=O(V+E) S(n)=O(V)

	public void dfs(int src){
		boolean[] vis=new boolean[V+1];
		int[] level=new int[V+1];
		dfsUtil(src,-1,vis,level);
	}	
	public void dfsUtil(int src,int par,boolean[] vis,int[] lvl){
		vis[src]=true;
		for(Integer child:adj[src]){
			if(!vis[child]){
				lvl[child]=lvl[par]+1;
				dfsUtil(child,src,vis,lvl);
			}
		}
	}

	//2.DFS Iterative
	public void dfsIter(int src){
		Stack<Integer> stack=new Stack<>();
		boolean[] vis = new boolean[V+1];
		int[] par=new int[V+1];
		stack.push(src);
		vis[src]=true;
		Arrays.fill(par,-1);

		while(!stack.isEmpty()){
		   Integer rp=stack.pop();
		   Iterator<Integer> it=adj[rp].iterator();
		   while(it.hasNext()){
		   	  int nbrs=it.next();
		   	  if(!vis[nbrs]){
		   	  	 par[nbrs]=rp;
	   	  		 stack.push(nbrs);
		   	  }
		   }
		}
	}

	
}


