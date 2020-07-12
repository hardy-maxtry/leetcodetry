package solution.solution_other;

import java.util.Arrays;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] result = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++){
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }
        result[m][n-1] = 1;
        result[m-1][n] = 1;
        for(int i = m -1; i >= 0; --i){
            for(int j = n-1; j >=0; --j){
                int minNext = Math.min(result[i+1][j], result[i][j+1]);
                // 负数是扣血，这里减去负数表示增大了走这一格所需的hp
                // 正数是加血，这里减去正数表示进入这一格之前不需要太多的hp，但是不能低于0
                result[i][j] = Math.max(minNext - dungeon[i][j], 1);
            }
        }
        return result[0][0];
    }

    public static void main(String[] args) {
        DungeonGame dungeonGame = new DungeonGame();
//        int[][] aaa = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
//        int[][] aaa = {{0,0}};
        int[][] aaa = {{0,-3}};
        int result = dungeonGame.calculateMinimumHP(aaa);
        System.out.println(result);
    }
}
