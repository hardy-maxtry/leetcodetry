package solution.solution300_400;

public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        // 动态规划
        // 定义上升/下降序列，只看最后两位数字
        // 定义，nums[length-1] > nums[length-2] 为上升序列
        // 定义，nums[length-1] < nums[length-2] 为下降序列
        if (nums.length < 2)return nums.length;
        // 初始长度为1
        int up = 1; int down = 1;
        for (int i = 1; i < nums.length; i++){
            // 因为需要返回序列长度，因此从第二位开始计算，只要满足要求，长度能自动匹配
            if (nums[i] > nums[i-1]){
                // 当前上升
                // 上升序列长度 = 之前下降列长度 + 1
                // 即使连续上升，当前上升序列长度也不会累加，也只会 =之前下降列长度 + 1(下降序列发生在本次上升序列之前，也不会增长)
                up = down + 1;
            }else if (nums[i] < nums[i-1]){
                // 当前下降
                // 下降序列长度 = 之前上升序列长度 + 1
                // 即使连续下降，当前下降序列长度也不会累加，也只会 =之前上升列长度 + 1 (上升序列发生在本次下降序列之前，也不会增长)
                down = up + 1;
            }
        }
        // 摆动序列只需要返回最长的上升或下降序列
        return Math.max(up,down);
    }

    public int wiggleMaxLength2(int[] nums) {
        // 贪心，基于上一个上升/下降，尝试寻找下一个最近的下降/上升
        // 返回结果长度为 result
        // 仅有 nums[length-1] > nums[length-2] 且之前存在下降时，result + 1
        // 或者 nums[length-1] < nums[length-2] 且之前存在上升时，result + 1
        if (nums.length < 2) return nums.length;
        Boolean isUp = nums[1] == nums[0] ? null : nums[1] > nums[0];
        int result = nums[1] == nums[0] ? 1 : 2;
        // 从第三位开始运算
        for (int i = 2; i < nums.length; i++){
            if (isUp == null){
                if (nums[i] > nums[i-1] ){
                    // 上一个判定为下降且本次为上升，长度+1
                    result++;
                    isUp = true;
                }else if (nums[i] < nums[i-1]){
                    // 上一个判定为上升且本次为下降，长度+1
                    result++;
                    isUp = false;
                }
            }else{

                if (nums[i] > nums[i-1] && !isUp){
                    // 上一个判定为下降且本次为上升，长度+1
                    result++;
                    isUp = true;
                }else if (nums[i] < nums[i-1] && isUp){
                    // 上一个判定为上升且本次为下降，长度+1
                    result++;
                    isUp = false;
                }
            }
            // 连续上升或下降时，不满足isUp条件，result不变
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] a = {1,17,5,10,13,15,10,5,16,8};
        int[] a = {1,2,3,4,5};
        Solution376 solution376 = new Solution376();
        System.out.println(solution376.wiggleMaxLength2(a));
    }
}
