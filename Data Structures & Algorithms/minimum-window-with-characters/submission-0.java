class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];

        for (char ch : t.toCharArray()) {
            need[ch]++;
        }
        int[] window = new int[128];

        int left = 0;
        int have = 0;
        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            window[ch]++;

            if (need[ch] > 0 && window[ch] <= need[ch]) {
                have++;
            }

            while (have == required) {

             
                int currentLength = right - left + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

             
                if (need[leftChar] > 0 &&
                    window[leftChar] < need[leftChar]) {
                    have--;
                }

                left++;
            }
        }


        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }
}