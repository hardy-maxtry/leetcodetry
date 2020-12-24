package solution.solution1_100;

public class Solution135 {
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        result[0] = 1;
        // 左规则，向右上升时， r[i+1] = r[i]+1
        // 向右下降或者持平时  r[i+1]=1
        for (int i = 1; i < ratings.length;i++){
            if (ratings[i-1] < ratings[i]){
                result[i] = result[i-1]+1;
            }else{
                result[i] = 1;
            }
        }
        int result2 = 0;
        // 右规则
        // 向左上升，且r[i-1] <= r[i] 时， r[i-1] = r[i] + 1
        // 其实这里不会出现 < 的情况，只会右=
        for (int i = ratings.length-2; i>=0; i--){
            if (ratings[i] > ratings[i+1] && result[i] <= result[i+1]){
                result[i] = result[i+1]+1;
            }
        }
        for (int i :result){
            result2+= i;
        }
        return result2;
    }

    public static void main(String[] args) {
        Solution135 solution135 = new Solution135();
        int[] n = {1,2,2};
        int[] n2 = {1,0,2};
        int[] n3 = {1,3,2,2,1};
        System.out.println(solution135.candy(n));
        System.out.println(solution135.candy(n2));
//        System.out.println(solution135.candy(n3));
    }

}
