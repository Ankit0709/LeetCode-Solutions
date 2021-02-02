//NQueens
//Problem LInk : https://leetcode.com/problems/n-queens/
class NQueens {
   List<List<String>> queenWays=new ArrayList<>();
	public boolean canPlaceTheQueen(boolean[][] mat,int row,int col,int n){
		int i=row,j=col;
		//check in same row
		while(j>=0){			
			if(mat[row][j]==true){
				return false;
			}
			j--;
		}
		//check in same column
		while(i>=0){
			if(mat[i][col]){
				return false;
			}
			i--;
		}
		i=row;j=col;
		while(i>=0&&j>=0){
			if(mat[i][j]){
				return false;
			}
			i--;j--;
		}
        i=row;j=col;
        while(i>=0&&j<n){
            if(mat[i][j]){
                return false;
            }
            i--;j++;
        }
		return true;
	}
	public boolean solveNQueenProblem(boolean[][] mat,int row,int n){
		//base condition is that if row == n we have got a arrangement
		//so add it to out ans
		
        if(row==n){
			    
			List<String> x=new ArrayList<>();
			for(int i=0;i<n;i++){
				StringBuilder str=new StringBuilder();
				for(int j=0;j<n;j++){
					if(mat[i][j]){
						str.append("Q");
					}
					else{
						str.append(".");
					}
				}
				x.add(str.toString());
                
			}
            queenWays.add(x);
			return false;
		}
		for(int col=0;col<n;col++){
            // System.out.println(canPlaceTheQueen(mat,row,col,n)+":"+row+":"+col);
			if(canPlaceTheQueen(mat,row,col,n)){
				mat[row][col]=true;
				if(solveNQueenProblem(mat,row+1,n)){
					return true;
				}
				//backtrack step
				mat[row][col]=false;
			}
		}
		return false;
	}
    public List<List<String>> solveNQueens(int n) {
        if(n==1){
        	List<String> x=new ArrayList<>();
        	x.add("Q");
        	queenWays.add(x);
        	return queenWays;
        }
        boolean[][] mat=new boolean[n][n];
        solveNQueenProblem(mat,0,n);
        return queenWays;
    }
}