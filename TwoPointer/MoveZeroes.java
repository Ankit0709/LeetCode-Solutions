//MoveZeroes
//Problem Link : https://leetcode.com/problems/move-zeroes/
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len=nums.length;
        int i=0;
        for(int j=0;j<len;j++){
            if(nums[j]!=0){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
            }
        }
    }
}