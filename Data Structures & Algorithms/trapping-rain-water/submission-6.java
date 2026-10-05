class Solution {
    public int trap(int[] height) {
        // int n = height.length;
        // int ans  = 0;

        // for(int i =0;i<n ;i++){
        //     int lmax  =0 , rmax =0;

        //     for(int j =0;j<=i;j++){
        //         lmax = Math.max(lmax, height[j]);
        //     }

        //     for(int j = i;j<n;j++){
        //         rmax = Math.max(rmax, height[j]);
        //     }

        //     int width =Math.min(lmax, rmax)- height[i];

        //     if(width > 0) {
        //         ans+=width;
        //     }
        // }
        // return ans;

        // Brute force solution : O (n ^ 2) and O(1)space

        // int n = height.length;
        // if(n ==0) return 0;

        // int []left = new int[n], right = new int[n];

        // left[0]= height[0];
        // for(int i =1;i<n ;i++){
        //     left[i] = Math.max(left[i-1],height[i]);
        // }
        // right[n-1]= height[n-1];

        // for(int i= n-2 ;i>=0;i--){
        //     right[i]= Math.max(right[i+1],height[i]);
        // }

        // int ans = 0;
        // for(int i =0;i<n;i++){
        //     int width = Math.min(left[i],right[i])-height[i];

        //     if(width > 0){
        //         ans+=width;
        //     }
        // }
        // return ans;

        // time complexity : O(n) and space complexity : O(n) 


        // optimal solution we have is two pointer

        // compress dp , move smaller side 

        int left =0, right = height.length - 1;
        int lmax =0, rmax =0,ans=0;
        while (left<=right){
            if(height[left]<= height[right]){
                if(height[left]>= lmax){
                    lmax =height[left];
                }
                else{
                    ans+=lmax - height[left];
                }
                left++;               
            }
            else{
                if(height[right]>= rmax){
                    rmax =height[right];
                }else{
                    ans+=rmax -height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
