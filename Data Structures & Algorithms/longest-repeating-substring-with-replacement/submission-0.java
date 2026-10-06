class Solution {
    public int characterReplacement(String s, int k) {

        int []count = new int[26];
        int left = 0, maxFreq = 0, best = 0;

        for(int right = 0;right < s.length();right++){
            int c = s.charAt(right) - 'A';
            count[c]++;
            maxFreq = Math.max(maxFreq, count[c]);

            if((right - left + 1)-maxFreq >k){
                count[s.charAt(left)- 'A']--;
                left++;
            }
            best = Math.max(best , right -left +1);
        }
        return best;
    }
}
