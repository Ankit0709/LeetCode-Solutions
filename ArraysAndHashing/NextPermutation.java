// /NextPermutation
//Problem LInk :https://leetcode.com/problems/next-permutation/
class NextPermutation {
    public void nextPermutation(int[] nums) {
        int j=nums.length-2;
        while(j>=0&&nums[j]>=nums[j+1]){
        	j--;
        }
        if(j>=0){
            int i=j+1;
            int pos=-1;
            while(i<nums.length){
                if(nums[i]>nums[j]){
                    pos=i;                
                }
                i++;
            }
            swap(nums,pos,j);
        }        
        reverse(nums,j+1,nums.length-1);
    }
    void swap(int[] nums,int i,int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	void reverse(int[] nums,int low,int high){
		while(low<high){
			int temp=nums[low];
			nums[low]=nums[high];
			nums[high]=temp;
			low++;
			high--;
		}
	}
}
