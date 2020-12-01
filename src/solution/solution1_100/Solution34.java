package solution.solution1_100;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        // 左侧位置
        int left = findPos(nums, target, true);
        // 找到的是比最右侧位置的下标+1的位置
        int right = findPos(nums, target, false) - 1;
        if (left <= right && left>=0 && right < nums.length && nums[left] == target && nums[right] == target){
            return new int[]{left, right};
        }

        return new int[]{-1,-1};
    }
    // 参考了题解
    public int findPos(int[] nums, int target, boolean findLower){
        int left = 0, right = nums.length-1;
        int result = nums.length;
        while (left <= right){
            // 二分法找中点
            int mid = (right + left) / 2;

            if (nums[mid] > target ){
                // 中点值大于目标值
                // 从中点左侧一个位置作为右边界继续查找
                right = mid - 1;
                result = mid;
            }else if (findLower && nums[mid] == target){
                // 当查找左侧第一个位置时，中点值等于目标值时，由于可能存在多个连续值，从中点左侧继续查找
                right = mid - 1;
                result = mid;
            }else{
                //
                // 当查找右侧第一个值时，中点值小于等于目标值，可能存在连续相同值，从中点右侧一个位置作为左边界继续查找
                // 注意：查找右侧时，这里最终得到的，不是target的右侧位置，由于始终找到的是target>=num[mid]的mid位置，并mid+1进入下一个查找，
                // 因此，循环停止时，mid落在的位置是target最右侧位置下标+1的位置
                // 当查找左侧第一个位置时，中点值小于目标值，从中点右侧一个位置作为左边界继续查找

                left = mid+1;
            }
        }


        return result;

    }

    public static void main(String[] args) {
        int[] aaa = {5,7,7,8,8,10};
//        int[] aaa = {1};
        Solution34 solution34 = new Solution34();
        int[] r = solution34.searchRange(aaa, 7);
        System.out.println(r[0]);
        System.out.println(r[1]);

    }
}
