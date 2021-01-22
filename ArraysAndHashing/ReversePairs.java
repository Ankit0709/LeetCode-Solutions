//ReversePairs
//Problem link : https://leetcode.com/problems/reverse-pairs/ 
class ReversePairs {
	public static int mergeSort(int[] nums,int low,int high){
		if(low>=high){
			return 0;
		}
		int cnt=0;
		int mid=low+(high-low)/2;
		cnt+=mergeSort(nums,low,mid);
		cnt+=mergeSort(nums,mid+1,high);
		cnt+=merge(nums,low,mid,mid+1,high);
		return cnt;
	}
	public static int merge(int[] nums,int start1,int end1,int start2,int end2){
		int i=start1,j=start2;
		int cnt=0;
		while(i<=end1){
			while(j<=end2&&(2*(long)nums[j])<nums[i]){
				j++;
			}
			cnt+=(j-start2);
			i++;
		}
		int[] temp=new int[end2-start1+1];
		int k=0;
		i=start1;j=start2;		
		while(i<=end1&&j<=end2){
			if(nums[i]<nums[j]){
				temp[k++]=nums[i++];
			}
			else{
				temp[k++]=nums[j++];				
			}
		}
		while(i<=end1){
			temp[k++]=nums[i++];
		}
		while(j<=end2){
			temp[k++]=nums[j++];
		}
		k=0;
		for(i=start1;i<=end2;i++){
			nums[i]=temp[k++];
		}	
		return cnt;

	}
    public int reversePairs(int[] nums) {
        int len=nums.length;
        if(len==0){
        	return 0;
        }
        return mergeSort(nums,0,len-1);
    }
}