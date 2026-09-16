class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> anagram = new ArrayList<>();

    //     for(String str :strs){
    //         boolean found = false;

    //         for(List<String> group:anagram){
    //             if(isAnagram(group.get(0),str)){
    //                 group.add(str);
    //                 found = true;
    //                 break;
    //             }
    //         }

    //         if(!found){
    //             List<String> newGroup = new ArrayList<>();
    //             newGroup.add(str);
    //             anagram.add(newGroup);
    //         }
    //     }
    //     return anagram;
    // }



    // private boolean isAnagram(String s, String t){
    //     if(s.length()!=t.length()){
    //         return false;
    //     }

    //     int []count = new int[26];

    //     for(int i =0;i<s.length();i++) {
    //         count[s.charAt(i)-'a']++;
    //         count[t.charAt(i)-'a']--;
    //     }

    //     for(int val:count){
    //         if(val!=0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //  below is the optimal solution using the frequency character

    Map<String,List<String>> map = new HashMap<>();

    for(String str:strs){

        int []count = new int[26];

        for(char c:str.toCharArray()){
            count[c-'a']++;
        }

        StringBuilder  key =new StringBuilder();

        for(int val:count){
            key.append(val).append('#');
        }

        map.computeIfAbsent(key.toString(), k->new ArrayList()).add(str);
    }
    return new ArrayList<>(map.values());
    }
}
