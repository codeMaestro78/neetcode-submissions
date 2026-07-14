class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean isContains= false;

        Set<Integer> set = new HashSet<>();

        for (int num:nums) {
            if(set.contains(num)) {
                isContains = true;
            }
            set.add(num);
        }
        return isContains;
    }
}