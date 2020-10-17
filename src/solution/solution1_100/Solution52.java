package solution.solution1_100;

public class Solution52 {
    int total = 0;
    public int totalNQueens(int n) {
        if(n ==0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
        if(n==2){
            return 0;
        }

        for (int i = 0; i < n; i ++){
            int[][] arr = new int[n][n];
            arr[0][i] = 1;
            goodPosition(n, 1, arr);
        }

        return total;
    }

    private boolean goodPosition(int n, int current, int[][] arr){
        boolean goodPos = false;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n ; j ++){
                arr[current][j] = 0;
            }
            arr[current][i] = 1;
            goodPos = true;
            // 检查同列是否有占用
            for(int j = 0; j < current; j ++){
                if (arr[j][i] == 1){
                    arr[current][i] = 0;
                    goodPos = false;
                    break;
                }
            }
            // 检查同列占用失败
            if(arr[current][i] == 0){
                continue;
            }
            // 检查左上角是否有占用
            for(int j = current -1, k = i -1 ; j >=0 && k >=0; ){
                if(arr[j][k] == 1){
                    arr[current][i] = 0;
                    goodPos = false;
                    break;
                }
                k--;
                j--;
            }
            // 检查左上角占用失败
            if(arr[current][i] == 0){
                continue;
            }
            // 检查右上角是否有占用
            for(int j = current -1, k = i + 1 ; j >=0 && k < n; ){
                if(arr[j][k] == 1){
                    arr[current][i] = 0;
                    goodPos = false;
                    break;
                }
                k++;
                j--;
            }
            // 检查右上角占用失败
            if(arr[current][i] == 0){
                continue;
            }

            if (goodPos && current < n - 1 ){
                goodPosition(n, current+ 1, arr);
            }
            if (goodPos && current == n -1 ){
                arr[current][i] = 0;
                total++;
            }
        }
        return goodPos;
    }

    public static void main(String[] args){
        Solution52 solution52 = new Solution52();
        int result = solution52.totalNQueens(5);
        System.out.println(result);
    }
}
