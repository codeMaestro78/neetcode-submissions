class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }   

        StringBuilder remaining= new StringBuilder(t);
         for(char c :s.toCharArray()){
            int index = remaining.indexOf(String.valueOf(c));
                if(index == -1){
                    return false;
                }
                remaining.deleteCharAt(index);
            
         }
         return true;

        
        }
}
