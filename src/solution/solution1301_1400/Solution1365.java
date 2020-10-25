package solution.solution1301_1400;

public class Solution1365 {
    /**
     * 由于数字范围有限，因此制作一个数组countOfNum来存放每个数字的出现次数
     * 遍历该数组countOfNum，统计小于当前数字的数字个数，记录到countOfSmallerNumber
     *  countOfSmallerNumber[i] =  countOfNum[i-1] + countOfSmallerNumber[i-1];
     *  遍历输入数组nums，从countOfSmallerNumber找到每个数字的值，填充到result即可
     * @param nums 
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] countOfNum = new int[101];
        for(int num : nums){
            countOfNum[num] = countOfNum[num] + 1;
        }
        int[] countOfSmallerNumber = new int[101];
        countOfSmallerNumber[0] = 0;
        countOfSmallerNumber[1] = countOfNum[0];
        for(int i = 2; i <= 100; i++){
            countOfSmallerNumber[i] =  countOfNum[i-1] + countOfSmallerNumber[i-1];
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = countOfSmallerNumber[nums[i]];
        }
        return result;
    }
}
