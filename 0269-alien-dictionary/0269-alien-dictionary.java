class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // 2) Build edges from the first differing pair in each adjacent word pair
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i], b = words[i + 1];

            // Invalid order: longer word comes before its prefix (e.g., "abc" before "ab")
            if (a.length() > b.length() && a.startsWith(b)) return "";

            int len = Math.min(a.length(), b.length());
            for (int j = 0; j < len; j++) {
                char ca = a.charAt(j), cb = b.charAt(j);
                if (ca != cb) {
                    // Add edge ca -> cb once
                    if (graph.get(ca).add(cb)) {
                        indegree.put(cb, indegree.get(cb) + 1);
                    }
                    break; // only the first mismatch defines the order
                }
            }
        }

        // 3) Kahn's BFS topological sort
        Queue<Character> q = new ArrayDeque<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) q.offer(c);
        }

        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            char node = q.poll();
            order.append(node);
            for (char nei : graph.get(node)) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) q.offer(nei);
            }
        }

        // If we couldn't process all nodes, there's a cycle → invalid order
        return order.length() == indegree.size() ? order.toString() : "";
    }
}