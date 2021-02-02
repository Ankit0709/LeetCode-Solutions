//RatInMaze
//Problem Link : https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
class Solution {
	public boolean isValidPath(int[][] path,int i,int j,int n){
		return i>=0&&i<n&&j>=0&&j<n&&path[i][j]==1;
	}
	public boolean solveRatInMazeProblem(int[][] path,boolean[][] way,int i,int j,int n){
		if(i==n-1&&j==n-1){
			way[i][j]=true;
			return true;
		}
		if(isValidPath(path,i,j,m)){
			way[i][j]=true;
			if(solveRatInMazeProblem(path,way,i+1,j,n)){
				return true;
			}
			if(solveRatInMazeProblem(path,way,i,j+1,n)){
				return true;
			}
			way[i][j]=false;
		}		
		return false;
	}
	//O denoted that it is block end hurdle and 1 means that it can be used as path
    public boolean ratInMaze(int[][] path,int n) {
    	boolean[][] way=new boolean[n][n];
        return solveRatInMazeProblem(path,way,0,0,n);
    }
}