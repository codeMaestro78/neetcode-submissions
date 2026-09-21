class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //  count O(n)

        // HashMap<Integer,Integer> freq = new HashMap<>();

        // for(int num:nums){
        //     freq.put(num, freq.getOrDefault(num, 0)+1);
        // }

        // List<Integer> dist = new ArrayList<>(freq.keySet());

        // dist.sort((a,b)->Integer.compare(freq.get(b), freq.get(a)));

        // int []res = new int[k];
        // for(int i =0;i<k;i++){
        //     res[i]=dist.get(i);
        // }
        // return res;
        


        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int num:nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        List<Integer> [] bucket = new List[nums.length+1];

        for(int num:freq.keySet()){
            int f = freq.get(num);
            if(bucket[f]==null){
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(num);
        }
        
        int []res = new int[k];
        int idx = 0;
        for(int i = bucket.length - 1;i>=0 && idx<k; i--){
            if(bucket[i]!=null){
                for(int num: bucket[i]){
                    res[idx++]= num;
                    if(idx==k){
                        break;
                    }
                }
            }
        }
        return res;
    }
}
