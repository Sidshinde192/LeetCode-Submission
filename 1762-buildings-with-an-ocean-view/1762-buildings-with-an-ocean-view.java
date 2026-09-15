class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
		// Assume that the first building can see the ocean
        stack.push(0);
		// Walk through list of buildings
        for(int i = 1; i<heights.length;i++){
			// If the height of the current building is taller than whats in the stack
			// it needs to be the first building in the stack
            while(!stack.isEmpty() && heights[i] >= heights[stack.peek()]){
                stack.pop();
            }
				// We know that we have the next tallest building in the input array
                stack.push(i);// 0, 2, 3
        }
		
		//Our stack now contains only the buildings that have a view of the ocean and we need to return it in the appropriate form
        int[] result = new int[stack.size()];
        int n = stack.size();
        for(int i = n-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;

    }
}