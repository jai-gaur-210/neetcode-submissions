class TimeMap {

    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair<Integer , String>> list = map.get(key);
        int l = 0; int r = list.size()-1;
        String res = "";

        while(l<=r){
            int mid = (l+r)/2;
            int mTime = list.get(mid).getKey();
            if(mTime == timestamp){
                return list.get(mid).getValue();
            }
            else if(mTime > timestamp){

                r = mid-1;
            }
            else{
                res = list.get(mid).getValue();
                l = mid+1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */