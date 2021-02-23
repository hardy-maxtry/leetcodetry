package solution.solution1001_1100;

public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int result = 0;
        for (int i = 0; i < customers.length; i++){
            if (grumpy[i] == 0){
                result += customers[i];
            }
        }

        int left = 0;
        int right = X-1;
        int finalResult = result;
        for (int i = left; i <= right; i++){
            if (grumpy[i] == 1){
                result += customers[i];
            }
        }
        finalResult = Math.max(finalResult, result);
        right++;
        left++;
        while(right<grumpy.length){


            if (grumpy[left-1] == 1){
                result -= customers[left-1];
            }
            if (grumpy[right] == 1){
                result += customers[right];
            }
            finalResult = Math.max(finalResult, result);
            right++;
            left++;

        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] customers = {5,8};
        int[] grumpy = {0,1};
        int X = 1;
        Solution1052 solution1052 = new Solution1052();
        System.out.println(solution1052.maxSatisfied(customers, grumpy, X));
    }
}
