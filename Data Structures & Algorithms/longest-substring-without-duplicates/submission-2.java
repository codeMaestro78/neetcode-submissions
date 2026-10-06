class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, max =0;

        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);

            while(seen.contains(ch)){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(ch);
            max = Math.max(max, right - left +1);
        }
        return max;
    }
}
