//RatInMazeAllDirections
//

class RatInMazeAllDirections{
	LinkedList<String> list=new LinkedList<>();
	String way="";
	public boolean isValid(int[][] path,boolean[][] vis,int row,int col,int n){
		if(row<0||row>=n||col<0||col>=n||vis[row][col]||path[row][col]==0){
			return false;
		}
		return true;
	}
	public void solveRatInMazeAll(int[][] path,boolean[][] vis,int row,int col,int n){
		if(row==n-1&&col==n-1){
			list.add(way);
			return;
		}
		if(row<0||row>=n||col<0||col>=n||vis[row][col]||path[row][col]==0){
			return;
		}
		vis[row][col]=true;
		//down direction
		if(isValid(path,vis,row+1,col,n)){
			way+='D';
			solveRatInMazeAll(path,vis,row+1,col,n);
			way=way.substring(0,way.length()-1);
			//backtrack step
		}
		//left direction
		if(isValid(path,vis,row,col-1,n)){
			way+='L';
			solveRatInMazeAll(path,vis,row,col-1,n);
			way=way.substring(0,way.length()-1);
		}
		//right direction
		if(isValid(path,vis,row,col+1,n)){
			way+='R';
			solveRatInMazeAll(path,vis,row,col+1,n);
			way=way.substring(0,way.length()-1);
		}
		//up direction
		if(isValid(path,vis,row-1,col,n)){
			way+='U';
			solveRatInMazeAll(path,vis,row-1,col,n);
			way=way.substring(0,way.length()-1);
		}
		vis[row][col]=false;
	}
	public boolean ratInMazeAll(int[][] path,int n){
		boolean[][] vis=new boolean[n][n];
		solveRatInMazeAll(path,vis,0,0,n);
		for(String x:list){
			System.out.println(x);
		}
	}
}