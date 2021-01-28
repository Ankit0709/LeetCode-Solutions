//RemoveDuplicatesFromSortedArray
//Problem LInk : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i=1,j=0;
        while(i<nums.length){
            if(nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
            }
            i++;
        }
        return j+1;
    }
}