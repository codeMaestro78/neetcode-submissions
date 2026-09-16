class Solution {
    public int[] twoSum(int[] nums, int target) {
        

        // for(int i = 0;i<nums.length;i++){
        //     for(int j =1 ;i<nums.length;j++){
        //         if((nums[i]+nums[j])==target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{-1,-1};

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0;i<nums.length;i++){
        int complement = target - nums[i];
        if(map.containsKey(complement)){
            return new int[]{map.get(complement),i};
        }
map.put(nums[i],i);

        }
        return new int[]{};
        
    }
}
