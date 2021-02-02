//SudokuSolver
//Problem LInk : https://leetcode.com/problems/sudoku-solver/
class SudokuSolver {
	public boolean isSameNumberExists(char[][] board,int row,int col,int n,char num){
		//check in same row
		for(int i=0;i<n;i++){
			if(board[row][i]==num){
				return true;
			}
		}
		//same column 
		for(int i=0;i<n;i++){
			if(board[i][col]==num){
				return true;
			}
		}
		//submatrix check
		int si=(row/3)*3,sj=(col/3)*3;
		for(int i=si;i<si+3;i++){
			for(int j=sj;j<sj+3;j++){
				if(board[i][j]==num){
					return true;
				}
			}
		}
		return false;

	}
	public boolean solveSudokuProblem(char[][] board,int row,int col,int n){
		//base cases
		if(row==n){
			return true;
		}
		if(col==n){
			return solveSudokuProblem(board,row+1,0,n);
		}
		
		if(board[row][col]!='.'){
			return solveSudokuProblem(board,row,col+1,n);
		}
		//try for every number with 1 to 9 in the cell
		for(char ch='1';ch<='9';ch++){
			if(!isSameNumberExists(board,row,col,n,ch)){
				board[row][col]=ch;
				boolean boardfillhuayanhi=solveSudokuProblem(board,row,col+1,n);
				if(boardfillhuayanhi){
					return true;
				}
				//backtrack
				board[row][col]='.';
			}
		}
		return false;		
	}
    public void solveSudoku(char[][] board) {
        solveSudokuProblem(board,0,0,board.length);
    }
}