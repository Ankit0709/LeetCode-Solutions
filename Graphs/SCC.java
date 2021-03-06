// /SCC
//Link : https://www.geeksforgeeks.org/strongly-connected-components/
class SCC{
	int V;
	ArrayList<Integer> adj[];
	SCC(int v){
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

	public void stronglyComponents(){
		Stack<Integer> stack = new Stack<>();
		boolean[] vis=new boolean[V];
		for(int i=0;i<V;i++){
			if(!vis[i]){
				dfs(i,stack,vis);
			}
		}

		SCC reverse= transpose();
		vis=new boolean[V];
		int cnt=0;
		while(!stack.isEmpty()){
			int top=stack.pop();
			if(!vis[top]){
				components(top,vis);
				System.out.println();
				cnt++;
			}
		}
	}
	public void components(int src,boolean[] vis,SCC reverse){
		vis[src]=true;
		System.out.print(src+" ");
		for(Integer nbrs:reverse.adj){
			if(!vis[nbrs]){
				components(nbrs,vis,reverse);
			}
		}
	}
	public void dfs(int src,Stack stack,boolean[] vis){
		vis[src]=true;
		for(Integer x:adj[src]){
			if(!vis[x]){
				dfs(x,stack,vis);
			}
		}
		stack.push(src);
	}
	public SCC transpose(){
		SCC scc=new SCC(V);
		for(int i=0;i<V;i++){
			for(Integer nbrs:adj[i]){
				scc.adj[nbrs].add(i);
			}
		}
		return scc;
	}
}