// /MinStepsForKnightProblem
//Link : https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
class MinStepsForKnightProblem{
	//Approach do a simple bfs as knight can move on 8 directions
	public int minSteps(Pair knight,Pair target,int N){
		int[] xi={1,-1,-2,-2,2,2,-1,1};
		int[] yi={-2,-2,-1,1,-1,1,2,2};
		Queue<Pair> queue=new LinkedList<>();
		queue.add(new Pair(knight.x,knight.y,0));
		vis[knight.x][knight.y]=true;
		while(!queue.isEmpty()){
			Pair rp=queue.poll();
			if(rp.x==target.x&&rp.y==target.y){
				return dist[rp.x][rp.y];
			}
			for(int i=0;i<8;i++){
				int x=rp.x+xi[i];
				int y=rp.y+yi[i];
				int d=rp.d+1;
				if(x>=1&&x<=N&&y>=1&&y<=N&&!vis[x][y]){
					queue.add(new Pair(x,y,d));
					vis[x][y]=true;
				}
			}
		}
		return -1;
	}
}
class Pair{
	int x,y,d;
	Pair(int x,int y,int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
}
