// /NQueens2
//Problem Link : https://leetcode.com/problems/n-queens-ii/
class NQueens2 {
     int count=0;
     boolean[] column,d1,d2;
	public boolean canPlaceTheQueen(boolean[][] mat,int row,int col,int n){
		return column[col]&&d1[row-col+n]&&d2[row+col];
	}
	public boolean solveNQueen(boolean[][] mat,int row,int n){
		if(row==n){
			count++;
			return false;
		}
		for(int col=0;col<n;col++){
			if(canPlaceTheQueen(mat,row,col,n)){
				mat[row][col]=true;
				column[col]=true;
				d1[row-col+n]=true;
				d2[row+col]=true;
				if(solveNQueen(mat,row+1,n)){
					return true;
				}
				mat[row][col]=false;
			}
		}
		return false;
	}
    public int totalNQueens(int n) {
        boolean[][] mat=new boolean[n][n];
        column=new boolean[n];
        d1=new boolean[2*n];
        d2=new boolean[2*n];
        solveNQueen(mat,0,n);
        return count;
    }
}