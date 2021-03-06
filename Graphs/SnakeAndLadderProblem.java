//SnakeAndLadderProblem
//Problem Link : https://leetcode.com/problems/snakes-and-ladders/

class SnakeAndLadderProblem {
	public int bfs(int[][] board,int n){
		Queue<Integer> queue=new LinkedList<>();
		int[] dist=new int[n*n+1];
		Arrays.fill(dist,-1);
		queue.add(1);
		dist[1]=0;
		while(!queue.isEmpty()){
			int s=queue.poll();
			if(s==n*n){
				return dist[s];
			}
			for(int v=s+1;v<=Math.min(n*n,s+6);v++){				
				int rc=get(v,n);
				int r=rc/n,c=rc%n;
				int dest=board[r][c]==-1?v:board[r][c];
				if(dist[dest]==-1){
					dist[dest]=dist[s]+1;
					queue.add(dest);
				}
				
			}
		}
		return dist[n*n];
	}
    public int snakesAndLadders(int[][] board) {
    	int n=board.length;       
        return bfs(board,n);
    }
    public int get(int s,int N){
    	int quo=(s-1)/N;
    	int rem=(s-1)%N;
    	int r=N-1-quo;
    	int c=r%2!=N%2?rem:N-1-rem;
    	return r*N+c;
    }
}