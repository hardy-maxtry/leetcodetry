package solution.solution100_200;

import java.util.Arrays;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int k1 = k % n;
        boolean[] visited = new boolean[k1];
        Arrays.fill(visited, false);
        for (int i = 0; i < k1; i ++){
            int tmpPos = i;
            if (visited[tmpPos]) continue;
            int tmpNum = nums[tmpPos];
//            int tmpNum = nums[(tmpPos + k1) % n];
            do {
//                tmpNum = nums[(tmpPos + k1) % n];
                int tmpNum2 = nums[(tmpPos + k1) % n];
                nums[(tmpPos + k1) % n] = tmpNum;
                tmpNum = tmpNum2;
                tmpPos = (tmpPos + k1) % n;
                if (tmpPos < visited.length){
                    visited[tmpPos] = true;
                }
            }while(tmpPos != i);
        }

        System.out.println(111);

    }

    public static void main(String[] args) {
//        int[] aaa = {1,2,3,4,5,6,7};
//        int[] aaa2 = {-1,-100,3,99};
//        Solution189 solution189 = new Solution189();
//        solution189.rotate(aaa, 3);
//        solution189.rotate(aaa2, 2);
        int i = 1;
        int j = 4;
        System.out.println(i^1);
        System.out.println(j^1);
    }
}
