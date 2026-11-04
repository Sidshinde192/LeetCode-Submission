class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n =  picture.length;
        int m = picture[0].length;
        int count =0;
        for(int i =0; i< n;i++){
            for(int j =0; j< m;j++){
                if(picture[i][j] == 'B'){
                    int rowC = checkRow(i, picture);
                    int colC = checkCol(j,picture);
                    if(rowC == 1 && colC == 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int checkRow(int i,char[][] picture){
        int count =0;
        for(int j =0; j < picture[0].length;j++){
            if(picture[i][j] == 'B'){
                count++;
            }
        }

        return count;
    }

    public int checkCol(int j, char[][] picture){
        int count =0;

        for(int i =0; i< picture.length;i++){
            if(picture[i][j] == 'B'){
                count++;
            }
        }

        return count;
    }
}