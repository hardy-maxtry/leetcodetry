package solution.solution1_100;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int length = n*n;
        int[][] result = new int[n][n];

        int x = 0;
        int y = 0;

        int nextX = 0;
        int nextY = 1;

        int borderLeft = -1;
        int borderRight = n;
        int borderTop = -1;
        int borderBottom = n;

        for (int i = 0; i < length; i++){
            result[x][y] = i+1;
            x+=nextX;
            y+=nextY;

            if (x == borderTop+1 && y==borderRight){
                nextX = 1;
                nextY = 0;
                x = x + 1;
                y = y - 1;
                borderTop++;
            }else if(x == borderBottom && y==borderRight-1){
                nextX = 0;
                nextY = -1;
                x = x - 1;
                y = y - 1;
                borderRight--;
            }else if(x == borderBottom-1 && y==borderLeft){
                nextX = -1;
                nextY= 0;
                x = x - 1;
                y = y + 1;
                borderBottom--;
            }else if(x == borderTop && y==borderLeft+1){
                nextX = 0;
                nextY= 1;
                x = x + 1;
                y = y + 1;
                borderLeft++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
//        solution59.generateMatrix(2);
        solution59.generateMatrix(5);
    }
}
