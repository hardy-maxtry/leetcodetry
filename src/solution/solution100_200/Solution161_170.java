package solution.solution100_200;

public class Solution161_170 {
    // id 167
    public int[] twoSum(int[] numbers, int target) {
        int max_pos = numbers.length -1;

        int[] result = new int[2];
        for (int i = 0; i <max_pos; i ++){
            int left= i+1;
            int right = max_pos;
            while(left <= right){
                int mid = left + (right - left) /2;
                if (numbers[i] + numbers[mid] == target){
                    return new int[]{i+1,mid+1};
                }
                if (numbers[i] + numbers[mid] > target){
                    right = mid-1;
                }
                if (numbers[i] + numbers[mid] < target){
                    left = mid+1;
                }
            }
//            for (int j =max_pos ; j > i; j--){
//                if (numbers[i] + numbers[j] == target){
//                    int[] r = new int[]{i+1,j+1};
//                    return r;
//                }
//                if(numbers[i] + numbers[j] < target){
//                    break;
//                }
//            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution161_170 solution161_170 = new Solution161_170();
        int[] graph = {2, 7, 11, 15};
        int[] result = solution161_170.twoSum(graph,9);

        System.out.println(String.format("%d %d", result[0],result[1]));


    }
}
