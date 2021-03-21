package solution.solution401_500;

import java.util.Arrays;

public class Solution493 {
    public int reversePairs(int[] nums) {
        Integer[] tmpArr = new Integer[nums.length];
        Arrays.fill(tmpArr, null);
        int result = 0;
        for(int i = nums.length-1; i>=0; i--){
            int number = nums[i];
            result += getPos(tmpArr, number);
        }
        return result;
    }

    public int getPos(Integer[] arr, int number){
        for (int i = 0; i<arr.length; i++){
            Integer currentNumber = arr[i];
            if (currentNumber == null){
                arr[i] = number;
                return i;
            }
            if (i==0 && currentNumber >= number){
                Integer previousNumber = number;
                for (int j = i ; j < arr.length; j++){
                    Integer tmpNumb3 = previousNumber;
                    previousNumber = arr[j];
                    arr[j] = tmpNumb3;
                }
                return 0;
            }


            if (currentNumber < number && (arr[i+1] == null || arr[i+1] >= number  )){
                Integer previousNumber = number;
                for (int j = i ; j < arr.length; j++){
                    Integer tmpNumb3 = previousNumber;
                    previousNumber = arr[j];
                    arr[j] = tmpNumb3;
                }
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,3,1};
        Solution493 solution493 = new Solution493();
        System.out.println(solution493.reversePairs(a));
    }
}
