class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int longest = 0;

        for(int num:set){
            if(!set.contains(num-1)){
                int currSum = num;
                int streak = 1;

                while(set.contains(currSum+1)){
                    currSum++;
                    streak++;
                }
                longest = Math.max(longest,streak);
            }

        }
        return longest;
    }
}
