//FindDuplicateNo
//Problem LInk :https://leetcode.com/problems/find-the-duplicate-number/
class FindDuplicateNo {
   public int findDuplicate(int[] nums) {
    int slow_pointer=nums[0];
      int fast_pointer=nums[0];
        slow_pointer=nums[slow_pointer];
        fast_pointer=nums[nums[fast_pointer]];
      while(fast_pointer!=slow_pointer){
      	fast_pointer=nums[nums[fast_pointer]];
      	slow_pointer=nums[slow_pointer];
      }
      int temp_pointer=nums[0];
      while(temp_pointer!=slow_pointer){
      	temp_pointer=nums[temp_pointer];
      	slow_pointer=nums[slow_pointer];
      }
      return slow_pointer;
    }

}