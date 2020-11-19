package solution.solution201_300;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int firstZeroPos = -1;
        // int nextNumPos = -1;
        for(int i = 0; i < nums.length; i++){
            int currentNum = nums[i];
            if(currentNum == 0 ){
                if(firstZeroPos == -1){
                    firstZeroPos = i;
                }
            }else{
                // nextNumPos = i;
                if(firstZeroPos != -1 && firstZeroPos < i){
                    nums[firstZeroPos] = nums[i];
                    nums[i] = 0;
                    firstZeroPos ++;
                }
            }



        }
    }
}
