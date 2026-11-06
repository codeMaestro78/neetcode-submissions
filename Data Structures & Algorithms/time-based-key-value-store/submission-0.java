// timestamp_prev <= timestamp
class TimeMap {

    class TimeValue {
        String value;
        int timestamp;

        TimeValue(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }    

    private HashMap<String, List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());

        map.get(key).add(new TimeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)){
            return "";
        }

        List<TimeValue> list = map.get(key);

        int left = 0;
        int right = list.size() - 1 ;

        int answer = -1;

        while(left <=right){
            int mid  = left + (right - left )/2;

            if(list.get(mid).timestamp <= timestamp){
                answer = mid;
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }

        if(answer == -1){
            return "";
        }

    return list.get(answer).value;
    }
}
