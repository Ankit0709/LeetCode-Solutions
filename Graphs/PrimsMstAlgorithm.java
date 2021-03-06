// /PrimsMstAlgorithm
//Link : https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/

class PrimsMstAlgorithm{
	int V;
	ArrayList<Pair> adj[];
	PrimsMstAlgorithm(int v){
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
	//App1 : Using Arrays Time Complexity is O(EV)
	public void primsAlgo(){
		int[] key=new int[V];
		boolean[] mstSet=new boolean[V];
		int cnt=0;
		int[] par=new int[V];
		Arrays.fill(key,Integer.MAX_VALUE);
		key[0]=0;
		par[0]=0;
		while(cnt!=V){
			int node=findMin(key,mstSet);
			cnt++;
			mstSet[node]=true;
			for(Pair nbrs:adj[node]){
				if(!mstSet[nbrs.d]&&nbrs.w<key[node]){
					key[nbrs.d]=nbrs.w;
					par[nbrs.d]=node;
				}
			}			
		}
		printMst(par);	
		
	}
	//App 2: Using Min Heap Optimised Prims Algo O(E logV)
	public void primsAlgoOptim(){
		int[] key=new int[V];
		Arrays.fill(key,Integer.MAX_VALUE);
		key[0]=0;
		par[0]=-1;
		int[] mstSet=new int[V];
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1,p2)->{
			return p1.w-p2.w;
		});
		minHeap.add(new Pair(0,0));
		while(!minHeap.isEmpty()){
			Pair rp=minHeap.poll();
			mstSet[rp.d]=true;
			for(Pair nbrs:adj[rp.d]){
				if(!mstSet[nbrs.d]&&key[nbrs.d]>nbrs.w){
					key[nbrs.d]=nbrs.w;
					minHeap.add(new Pair(nbrs.d,nbrs.w));
					par[nbrs.d]=rp.d;
				}
			}
		}
		printMSt(par);
	}
	public void printMSt(int[] par){
		for(int i=0;i<V;i++){
			System.out.println(i+"-->"+par[i]);
		}
	}
	public int findMin(int[] key,boolean[] mstSet){
		int minVal=Integer.MAX_VALUE,node=-1;
		for(int i=0;i<key.length;i++){
			if(minVal>key[i]&&!mstSet[i]){
				minVal=key[i];
				node=i;
			}
		}
		return node;
	}
}
class Pair{
	int d,w;
	Pair(int f,int s){
		d=f;
		w=s;
	}
}