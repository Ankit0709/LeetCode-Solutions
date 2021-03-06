// /ConnectedComponents
//Link : https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/
class ConnectedComponents{
	int V;
	ArrayList<Integer> adj[];
	ConnectedComponents(int v){
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
	//1.Approach Using DFS
	public int components(){
		int cnt=0;
		boolean[] vis=new boolean[V+1];
		for(int i=1;i<=V;i++){
			if(!vis[i]){
				dfs(i,vis);
				System.out.println();
				cnt++;
			}
		}
		return cnt;
	}
	public void dfs(int src,boolean[] vis){
		vis[src]=true;
		System.out.print(src+" ");
		for(Integer x:adj[src]){
			if(!vis[x]){
				dfs(x,vis);
			}
		}
	}


	//2.Approach Using BFS  T(n)=O(V+E)
	public int componentsUsingBFS(){
		int cnt=0;
		boolean[] vis=new boolean[V+1];
		for(int i=1;i<=V;i++){
			if(!vis[i]){
				bfs(i,vis);
				cnt++;
			}			
		}
		return cnt;

	}
	public void bfs(int src,boolean[] vis){
		Queue<Integer> queue=new LinkedList<>();
		queue.add(src);
		vis[src]=true;
		while(!queue.isEmpty()){
			Integer rp=queue.poll();			
			for(Integer x:adj[rp]){
				if(!vis[x]){
					queue.add(x);
				}
			}
		}
	}

}