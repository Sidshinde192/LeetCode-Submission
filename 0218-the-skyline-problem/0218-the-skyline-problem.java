class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
         List<int[]> events = new ArrayList<>();

        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];

            events.add(new int[]{left, height, 1});
            events.add(new int[]{right, height, 0});
        }

        events.sort((a, b) -> Integer.compare(a[0], b[0]));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);

        List<List<Integer>> ans = new ArrayList<>();
        int prevMax = 0;
        int i = 0;

        while (i < events.size()) {
            int x = events.get(i)[0];

            // Process all events at the same x
            while (i < events.size() && events.get(i)[0] == x) {
                int[] event = events.get(i);
                int height = event[1];
                boolean isStart = event[2] == 1;

                if (isStart) {
                    map.put(height, map.getOrDefault(height, 0) + 1);
                } else {
                    int count = map.get(height);

                    if (count == 1) {
                        map.remove(height);
                    } else {
                        map.put(height, count - 1);
                    }
                }

                i++;
            }

            int currentMax = map.lastKey();

            if (currentMax != prevMax) {
                ans.add(Arrays.asList(x, currentMax));
                prevMax = currentMax;
            }
        }

        return ans;
    }
}