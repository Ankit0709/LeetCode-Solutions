//SearchInMatrix
//Problem LInk :https://leetcode.com/problems/search-a-2d-matrix/
class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int n=matrix.length,m=matrix[0].length;
        int row=0,col=m;
        while(row<n&&col>=0){
        	if(matrix[row][col]==target){
        		return true;
        	}
        	else if(matrix[row][col]>target){
        		col--;
        	}
        	else{
        		row++;
        	}
        }
        return false;
    }
}