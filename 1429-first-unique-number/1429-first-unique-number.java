class FirstUnique {
    Queue<Integer> q = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();
    public FirstUnique(int[] nums) {
        for(int i : nums){
            add(i);
        }
    }
    
    public int showFirstUnique() {
        while(!q.isEmpty() && map.get(q.peek()) > 1){
            q.poll();
        }

        return q.isEmpty() ? -1 : q.peek();
    }
    
    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        q.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */