//NumberOfIslands
//Probelem LInk : https://leetcode.com/problems/number-of-islands/
class NumberOfIslands {	
	 public void dfs(char[][] grid,int i,int j,boolean[][] vis){
		if(i<0||j<0||i>=grid.length||j>=grid[0].length||vis[i][j]||grid[i][j]=='0'){
			return;
		}
		vis[i][j]=true;
        dfs(grid,i+1,j,vis);
		dfs(grid,i-1,j,vis);		
		dfs(grid,i,j-1,vis);
		dfs(grid,i,j+1,vis);
	}
    public int numIslands(char[][] grid) {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int comp=0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j]&&grid[i][j]=='1'){
                    dfs(grid,i,j,vis);                    
        		    comp++;
                }
        		
        	}
        }
        return comp;
    }
}