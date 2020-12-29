package solution.solution300_400;

public class Solution330 {
    public int minPatches(int[] nums, int n) {

        // 前提，当 [1, x-1]区间所有数字已覆盖，且下一个数字x也覆盖的话，可以证明 [1, 2x-1] 区间所有数字被覆盖
        int result = 0;
        long x  = 1; // x是下一个挑战是否需要补全的数字
        int length = nums.length;
        int index = 0;
        // 以下以[1,x-1]已经覆盖为基础，判断 [1,x]是否覆盖，直到[1,n] 被覆盖
        // 从 x=1 开始，即初始状态[1,0] 为空数组，属于已覆盖，挑战 [1, 1]是否被覆盖
        while(x <= n){
            // index不能大于nums下标
            // nums中下一个数字，比需要挑战的数字更小
            // 由于 [1, x-1]已经被覆盖，如果nums下一个数字next<=x，说明可以满足 [1, x-1 + next] 已经被覆盖
            // 需要挑战的数字变为  x + next
            if (index < length &&   nums[index] <= x){
                // 数字不能重复使用
                System.out.print("需要覆盖 [1,");
                System.out.print(x);
                System.out.print("], index=");
                System.out.print(index);
                System.out.print(", nums[index]=");
                System.out.print(nums[index]);
//                System.out.print(",");
//                System.out.print(nums[index] );

                System.out.print(",x后");
                x+= nums[index]; // 下一个挑战的数字
                System.out.println(x);
                index++;
            }else{
                // nums[i] > x， 说明 [1, x-1]中任意数字组合之和+下一个数字nums[i]，都无法得到数字 x，
                // 也就是表示这个x挑战失败，需要将x补全到数组中，达到[1,x]覆盖
                // 补全后  [1, x-1 + x] 已经被覆盖
                // 下一个挑战的数字是  x - 1 + x + 1 也就是 2x
                //
                // 实际上，仅当数组中，不存在比当前x小的数字的时候，才会需要补全数字
                System.out.print("需要覆盖 [1,");
                System.out.print(x);
                System.out.print("], index=");
                System.out.print(index);
                System.out.print(", nums[index]=");
                System.out.print(nums[index]);

                System.out.print(",补,");
                System.out.print(x);

                System.out.print(",x后");

                x = x * 2;  // 下一个挑战的数字
                System.out.println(x);
                result ++;
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] origin = {2,5,10};
        Solution330 solution330 = new Solution330();
        solution330.minPatches(origin, 20);
    }
}
