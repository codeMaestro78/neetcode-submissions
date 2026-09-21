class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //  count O(n)

        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int num:nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        List<Integer> dist = new ArrayList<>(freq.keySet());

        dist.sort((a,b)->Integer.compare(freq.get(b), freq.get(a)));

        int []res = new int[k];
        for(int i =0;i<k;i++){
            res[i]=dist.get(i);
        }
        return res;
        
    }
}
