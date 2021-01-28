//ContainerWithMostWater
//Problem LInk : https://leetcode.com/problems/container-with-most-water/
class ContainerWithMostWater {
      public int maxArea(int[] height) {
        int area=0;
        int left=0,right=height.length-1;
        while(left<=right){
            if(height[left]<height[right]){
                int water=height[left]*(right-left);
                area=Math.max(water,area);
                left++;
            }
            else{
                int water=height[right]*(right-left);
                area=Math.max(water,area);
                right--;
            }
        }
        return area;
    }
}