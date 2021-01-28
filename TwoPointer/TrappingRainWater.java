//TrappingRainWater
//Problem Link : https://leetcode.com/problems/trapping-rain-water/
class TrappingRainWater {
     public int trap(int[] height) {
        int left=0,right=height.length-1;
        int left_max=Integer.MIN_VALUE,right_max=Integer.MIN_VALUE;
        int water=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>left_max){
                    left_max=height[left];
                }else{
                    water+=left_max-height[left];
                }
                left++;
            }
            else{
                if(height[right]>right_max){
                    right_max=height[right];
                }else{
                    water+=right_max-height[right];
                }
                right--;
            }
        }
        return water;
    }
}