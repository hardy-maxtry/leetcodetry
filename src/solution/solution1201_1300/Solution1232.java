package solution.solution1201_1300;

public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2){
            return true;
        }
        double xielv = calcXielv(coordinates[1], coordinates[0]);
        for (int i = 1; i < coordinates.length; i ++){
            double tmpXielv = calcXielv(coordinates[i], coordinates[i-1]) ;
            if (xielv != tmpXielv){
                return false;
            }
        }
        return true;
    }

    public double calcXielv(int[] coo1, int[] coo2){
        if (coo2[0] == coo1[0]){
            return Double.MAX_VALUE;
        }
        return (double)(coo2[1] - coo1[1]) / (coo2[0] - coo1[0]);
    }

    public static void main(String[] args){
        int[][] in = {{-4,-3},{1,0},{3,-1}, {0,-1},{-5,2}};
        Solution1232 solution1232 = new Solution1232();
        System.out.println(solution1232.checkStraightLine(in));
    }
}
