// /DijikstraAlgo
//Link : https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
class DijikstraAlgo{
	int V;
	ArrayList<Pair> adj[];
	DijikstraAlgo(int v){
		V=v;
		adj=new ArrayList[V+1];
		for(int i=1;i<=v;i++){
			adj[i]=new ArrayList<>();
		}
	}
	public void addEdge(int src,int dest,int weight){
		adj[src].add(new Pair(dest,weight));
		adj[dest].add(new Pair(src,weight));
	}
	public void dijikstra(int src){
		int[] dist=new int[V+1];
		dist[src]=0;
		int[] par=new int[V+1];
		for(int i=1;i<=V;i++){
			par[i]=i;
		}
		TreeSet<Pair> set = new TreeSet<>();
		set.add(new Pair(0,src));
		int edges=0;
		boolean[] vis=new boolean[V+1];
		
		while(!set.isEmpty()){
			Pair top=set.pollFirst();
			vis[top.w]=true;
			for(Pair nbrs:adj[top.w]){
				if(!vis[nbrs.d]){
					if(dist[nbrs.d]>dist[top.w]+top.d){
						Pair xo=new Pair(dist[nbrs.d],nbrs.w);
						if(set.contains(xo)){
							set.remove(xo);
						}
						dist[nbrs.d]=dist[top.w]+top.d;
						set.add(new Pair(dist[nbrs.d],nbrs.w
					}
				}
				
			}
		}

		for(int i=1;i<=V;i++){
			System.out.println(i+"===>"+dist[i]);
		}

	}
}
class Pair{
	int d,w;
	Pair(int f,int s){
		d=f;
		w=s;
	}
}