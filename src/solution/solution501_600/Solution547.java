package solution.solution501_600;

public class Solution547 {
    // dfs 时间复杂度 o(n^2) 空间复杂度 o(n)
    public int findCircleNum(int[][] isConnected) {
        int[] cityCalculated = new int[isConnected.length];

        int result = 0;

        for (int i = 0; i < cityCalculated.length; i++){
            if (cityCalculated[i] == 0){
                result++;
                dfs(isConnected, cityCalculated, i);
            }
        }
        return result;
    }

    public void dfs(int[][] isConnected, int[] cityCalculated, int i){
        for (int j = 0; j < cityCalculated.length; j++){
            if (isConnected[i][j] == 1 && cityCalculated[j] == 0){
                cityCalculated[j] = 1;
                dfs(isConnected, cityCalculated, j);
            }
        }
    }




}
