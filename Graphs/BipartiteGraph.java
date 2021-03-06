// /BipartiteGraph
//Problem Link : https://leetcode.com/problems/is-graph-bipartite/
class Solution {
	//1.Approach Using BFS we just give src node color 1 and then its neighbours col 2 and then neigbours of
	//neigbours col 1 and so on if we find that col of neigh is equal to col of my node means 
	// graph cannot be bipartite
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue=new LinkedList<>();
        int V=graph.length;
 		int[] col=new int[V]; 		
 		Arrays.fill(col,-1); 		
 	    for(int i=0;i<V;i++){
 	    	if(col[i]==-1){
 	    		if(!bfs(graph,i,col)){
 	    			return false;
 	    		}
 	    	}
 	    }
 	    return true;
 		
    }
     public boolean bfs(int[][] graph,int src,int[] col){
		
		Queue<Integer> queue=new LinkedList<>();
		queue.add(src);
		col[src]=1;
		while(!queue.isEmpty()){
			int rp=queue.poll();			
			for(int j=0;j<graph[rp].length;j++){
                int nbrs=graph[rp][j];
                // System.out.println(rp+":"+col[rp]+":"+nbrs+":"+col[nbrs]);
				if(col[nbrs]==-1){
					queue.add(nbrs);
					col[nbrs]=1-col[rp];
				}
				else if(col[nbrs]==col[rp]){
					return false;
				}
			}
		}
		return true;
	}



	//2.Bipartite USing DFS 
	public boolean isBipartiteDFS(int[][] graph){
		int V=graph.length;
		int[] col=new int[V];
		Arrays.fill(col,-1);
		for(int i=0;i<V;i++){
			if(col[i]==-1){
				col[i]=1;
				if(!dfs(i,graph,col)){
					return false;
				}
			}			
		}
		return true;
	}
	public boolean dfs(int src,int[][] graph,int[] col){
		
		for(int j=0;j<graph[src].length;j++){
			int nbrs=graph[src][j];
			if(col[nbrs]==-1){
				 col[nbrs]=1-col[src];
				if(!dfs(nbrs,graph,col)){
					return false;
				}
			}
			else if(col[nbrs]==col[src]){
				return false;
			}
		}
		return true;
	}

}