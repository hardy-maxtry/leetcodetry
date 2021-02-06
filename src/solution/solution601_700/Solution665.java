package solution.solution601_700;

public class Solution665 {
    public boolean checkPossibility(int[] nums) {

        for(int i = 1; i < nums.length; i++){

            if (nums[i] < nums[i-1]){
                if (nums[i] < nums[i-1]){
                    // 当出现递减时, 尝试出去当前数字或前一位数字，然后判断剩余数字是否组成非递减数列
                    return isUpList(nums, i-1) || isUpList(nums, i);
                }
            }
        }
        return true;
    }

    public boolean isUpList(int[] nums, int x){
        int start = 1;
        if (x == 0) {
            start = 2;
        }
        int lastNum = nums[start-1];
        for (int i = start; i < nums.length; i++){
            if (i == x){
                continue;
            }
            if (nums[i] < lastNum){
                return false;
            }
            lastNum = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution665 solution665 = new Solution665();
        int[] a = {4,2,3};
        System.out.println(solution665.checkPossibility(a));
    }
}
