package solution.solution700_800;

import java.util.Arrays;

public class solution785 {
    private final int RED=1;
    private final int BLUE=2;
    private final int WHITE=0;

    private int[] colors;
    private int length;
    private boolean valid;
    // 染色法，路径对面的数字应该是无色或不同颜色，否则直接false
    public boolean isBipartite(int[][] graph) {
        colors = new int[graph.length];
        Arrays.fill(this.colors, WHITE);
        this.length = graph.length;
        valid = true;
        for (int i = 0; i<length;i++){
            if (colors[i] == WHITE){
                calc(i, RED, graph);
            }
        }
        return valid;
    }

    private  void calc(int i, int color, int[][] graph){
        int targetColor = color == RED ? BLUE: RED;
        for (int j = 0 ; j<graph[i].length; j ++){
            int temp = graph[i][j];
            if (colors[temp] == targetColor){
                continue;
            }
            if (colors[temp] == WHITE){
                colors[temp] = targetColor;
                calc(temp, targetColor, graph);
                if (!valid){
                    return;
                }
                continue;
            }
            valid = false;
            return;

        }
    }

    public static void main(String[] args) {
        solution785 solution785 = new solution785();
        int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
        boolean result = solution785.isBipartite(graph);

            System.out.println(result);


    }
}
