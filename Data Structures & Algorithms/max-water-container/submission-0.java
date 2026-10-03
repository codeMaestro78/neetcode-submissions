class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;

        int max = 0;

        while(left < right){
            int width = right - left;
            int h = Math.min(heights[left], heights[right]);
            max = Math.max(max, width * h);


            if(heights[left]<=heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}
