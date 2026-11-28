class TimeStampedValue{
    int timestamp;
    String value;

    public TimeStampedValue(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {
    Map<String, ArrayList<TimeStampedValue>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        ArrayList<TimeStampedValue> timeStamped = map.get(key);
        timeStamped.add(new TimeStampedValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        ArrayList<TimeStampedValue> timestampvalues=map.get(key);

        Optional<TimeStampedValue> timeStamp =binarySearch(timestampvalues, timestamp);
        if(timeStamp.isEmpty()){
            return "";
        }
        return timeStamp.get().value;
    }
    private Optional<TimeStampedValue> binarySearch(
    ArrayList<TimeStampedValue> arr, int target) {
    int left = 0, right = arr.size() - 1;
    int matchIndex = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      TimeStampedValue cur = arr.get(mid);
      if(cur.timestamp <= target) {
        matchIndex = mid;
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }

    if(matchIndex == -1) {
      return Optional.empty();
    }
    return Optional.of(arr.get(matchIndex));
  }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */