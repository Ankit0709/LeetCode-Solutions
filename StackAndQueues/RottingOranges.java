// /RottingOranges
//Problem LInk : https://leetcode.com/problems/rotting-oranges/
class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int fresh=0;
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<rows;i++){
        	for(int j=0;j<cols;j++){
        		if(grid[i][j]==2){
        			queue.add(new Pair(i,j));
        		}
        		else if(grid[i][j]==1){
        			fresh++;
        		}
        	}
        }
       
        int days=0;
        while(!queue.isEmpty()){
        	int size=queue.size();
        	while(size--!=0){
        		Pair x=queue.poll();
                int i=x.f,j=x.s;
        		//we will find fresh oranges on its left,right,top and bottom
        		//top
        		if(i-1>=0&&grid[i-1][j]==1){
        			grid[i-1][j]=2;
        			queue.add(new Pair(i-1,j));
        			fresh--;
        		}
        		//left
        		if(j-1>=0&&grid[i][j-1]==1){
        			grid[i][j-1]=2;
        			queue.add(new Pair(i,j-1));
        			fresh--;
        		}
        		//down
        		if(i+1<rows&&grid[i+1][j]==1){
        			grid[i+1][j]=2;
        			queue.add(new Pair(i+1,j));
        			fresh--;
        		}
        		//right
        		if(j+1<cols&&grid[i][j+1]==1){
        			grid[i][j+1]=2;
        			queue.add(new Pair(i,j+1));
        			fresh--;
        		}
	        	
        	}
        	days++;
        	
        }
        if(days==0&&fresh==0){
          return 0;  
        }       
        if(fresh==0){
        	return days-1;
        }
        else{
        	return -1;
        }
    }
}
class Pair{
	int f,s;
	Pair(int x,int y){
		f=x;s=y;
	}
}