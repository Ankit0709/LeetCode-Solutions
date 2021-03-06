//BFSOfGraph
//Link : https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
import java.util.*;
class BFSOfGraph{
	int V;
	ArrayList<Integer> adj[];
	BFSOfGraph(int v){
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

	//1.BFS Of Graph T(n)=O(V+E)
	public void bfs(int src){
		Queue<Integer> queue=new LinkedList<>();
		boolean[] vis=new boolean[V+1];
		int[] dist=new int[V+1],par=new int[V+1];
		queue.add(src);
		dist[src]=0;vis[src]=true;
		for(int i=1;i<=V;i++){
			par[i]=i;
		}
		while(!queue.isEmpty()){
			Integer rp=queue.poll();
			Iterator<Integer> it=adj[rp].iterator();
			while(it.hasNext()){
				int child=it.next();
				if(!vis[child]){
					vis[child]=true;
					dist[child]=dist[rp]+1;
					par[child]=rp;
					queue.add(child);
				}
			}			
		}
	}


	//2.O-1 BFS  T(n)=O(V+E)
	public void BFSZeroOne(int src){
		Deque<Integer> deque=new ArrayDeque<>();
		int[] dist=new int[V+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[src]=0;
		deque.addLast(src);
		while(!deque.isEmpty()){
			int c=deque.removeFirst();
			Iterator<Pair> rp=adj[c].listIterator();
			while(rp.hasNext()){
				Pair p=rp.next();
				if(dist[p.n]>dist[c]+p.w){
					dist[p.n]=dist[c]+p.w;
					if(p.w==0){
						deque.addFirst(p.n);
					}
					else{
						deque.addLast(p.n);
					}
				}
			}
		}



	}


}
class Pair{
	int n,w;
	Pair(int x,int y){
		n=x;w=y;
	}
}