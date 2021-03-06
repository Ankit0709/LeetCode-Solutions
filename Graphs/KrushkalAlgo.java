// /KrushkalAlgo
//Link : https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
import java.io.*;
import java.util.*;
class KrushkalAlgo{	
	//sort edges on their weight and then pick edge and check if it is not 
	//forming cycle then consider it (Union Find Algorithm) else discard it and
	//it will be done it O(V-1) times
	public static void krushkalAlgo(Edge[] edges,int V){
		Arrays.sort(edges,(e1,e2)->{
			return e1.w-e2.w;
		});
		int[] par=new int[V];
		int i=0;
		int cnt=0;
		for(i=0;i<V;i++){
			par[i]=i;
		}
		i=0;
		while(i<edges.length&&cnt!=V-1){
			Edge edge=edges[i];
			// System.out.println(edge.s+":"+edge.d);
			if(!detectCycle(edge.s,edge.d,par)){
				// par[edge.d]=edge.s;
				union(edge.s,edge.d,par);
				System.out.println(edge.s+":"+edge.d);
				cnt++;
			}
			i++;
		}
	}
	public static void union(int x,int y,int[] par){
		int parx=find(x,par);
		int pary=find(y,par);
		par[pary]=parx;
	}
	public static boolean detectCycle(int x,int y,int[] par){
		int parx=find(x,par);
		int pary=find(y,par);
		// System.out.println(x+":"+par[x]+":"+y+":"+par[y]);
		if(parx==pary){
			return true;
		}
		return false;
	}
	public static int find(int x,int[] par){
		while(x!=par[x]){
			x=par[x];
		}
		return x;
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new
       		FileReader("sampleinp.txt"));
		    	// BufferedReader br = new BufferedReader( 
       //                       new InputStreamReader(System.in)); 
	
		String[] str=br.readLine().split(" ");
		int V=Integer.parseInt(str[0]);
		int E=Integer.parseInt(str[1]);
		Edge[] edges= new Edge[E];
		for(int i=0;i<E;i++){
			str=br.readLine().split(" ");
			int u=Integer.parseInt(str[0]);
			int v=Integer.parseInt(str[1]);
			int w=Integer.parseInt(str[2]);
			edges[i]=new Edge(u,v,w);
		}
		krushkalAlgo(edges,V);
	}
}
class Edge{
	int s,d,w;
	Edge(int x,int y,int weight){
		s=x;
		d=y;
		w=weight;
	}
}

