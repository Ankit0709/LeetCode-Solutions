// /LocalAndGlobalInversions
////Problem link :https://leetcode.com/problems/global-and-local-inversions/
class Solution {	
	 public int localInversion(int[] A){
        int localInv=0;
        for(int i=0;i<A.length-1;i++){
            if(A[i]>A[i+1]){
                localInv++;
            }
        }
        return localInv;
	}
	public int mergeSort(int[] A,int low,int high){
		int globalInv=0;
		if(low<high){
			int mid=low+(high-low)/2;
            globalInv+=mergeSort(A,low,mid);
            globalInv+=mergeSort(A,mid+1,high);
            globalInv+=merge(A,low,mid+1,high);
		}		
		return globalInv;
	}
	public int merge(int[] A,int low,int mid,int high){
		int globalInv=0;
		int[] temp1=new int[A.length];
		int i=low,j=mid,k=low;
		while(i<mid&&j<=high){
            // System.out.println(A[i]+":"+A[j]);
			if(A[i]<A[j]){
				temp1[k++]=A[i];
				i++;
			}
			else{
				temp1[k++]=A[j];
				j++;
				globalInv+=(mid-i);
			}
		}
		while(i<mid){
			temp1[k++]=A[i++];
		}
		while(j<=high){
			temp1[k++]=A[j++];
		}
		i=low;
		while(i<=high){
			A[i]=temp1[i];
			i++;
		}
		return globalInv;
	}
	public int globalInversions(int[] A){		
		int globalInv=0;
		globalInv+=mergeSort(A,0,A.length-1);
        System.out.println(globalInv);
		return globalInv;
	}
    public boolean isIdealPermutation(int[] A) {
        return localInversion(A)==globalInversions(A);
    }
}