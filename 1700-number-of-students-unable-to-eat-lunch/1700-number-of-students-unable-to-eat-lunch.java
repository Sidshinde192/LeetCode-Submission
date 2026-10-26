class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        

        int s_1 =0;
        int s_0 =0;

        for(int num : students){
            if(num == 0){
                s_0++;
            }
            else{
                s_1++;
            }
        }

        for(int num : sandwiches){
            if((num == 0 && s_0 > 0)){
                s_0--;
            }
            else if(num == 1 && s_1 > 0){
                s_1--;
            }
            else{
                break;
            }
        }

        return s_0 + s_1;
    }
}