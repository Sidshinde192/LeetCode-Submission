class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();

        for(int num : students){
            studentQueue.add(num);
        }

        for(int i = sandwiches.length - 1; i >= 0; i--){
    sandwichStack.push(sandwiches[i]);
}

        int count =0;

        while(!studentQueue.isEmpty() && count < studentQueue.size()){
            if(sandwichStack.peek() == studentQueue.peek()){
                sandwichStack.pop();
                studentQueue.poll();
                count =0;
            }
            else{
                studentQueue.add(studentQueue.poll());
                count++;
            }
        }

        return studentQueue.size();


    }
}