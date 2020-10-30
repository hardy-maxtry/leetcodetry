package solution.solution401_500;

public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int x = 0; x < grid.length; x++){
            for (int y = 0; y < grid[0].length; y++){
                result =result + calcSingleBlock(grid, x, y);
            }
        }
        return result;
    }

    private Integer calcSingleBlock(int[][] grid, int x, int y){
        Integer result = 0;
        // 顶边
        if (x == 0 && grid[x][y] ==1){
            result++;
        }
        // 底边
        if (x == grid.length-1 && grid[x][y] ==1){
            result++;
        }
        // 左边
        if (y == 0 && grid[x][y] ==1){
            result++;
        }
        // 右边
        if (y == grid[0].length-1 && grid[x][y] ==1){
            result++;
        }

//        if (x>=1){
//            if (grid[x-1][y] == 0 && grid[x][y] == 1){
//                result++;
//            }
//        }
//        if (y>=1){
//            if (grid[x][y-1] == 0 && grid[x][y] == 1){
//                result++;
//            }
//        }
        if (x>=1){
            if (grid[x-1][y] != grid[x][y] ){
                result++;
            }
        }
        if (y>=1){
            if (grid[x][y-1] != grid[x][y] ){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution463 solution463 = new Solution463();
        int[][] origin = {{0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        Integer i = solution463.islandPerimeter(origin);
        System.out.println(i);
    }
}
