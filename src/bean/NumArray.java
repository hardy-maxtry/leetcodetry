package bean;

// id 303 前缀和
public class NumArray {
    private  int[] nums;
    private  int[] sumArr;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.sumArr = new int[nums.length];
        this.initArr();
    }

    public int sumRange(int i, int j) {
        if (i==0){
            return sumArr[j];
        }else {
            return sumArr[j] - sumArr[i-1];
        }
    }

    private void initArr(){
        for (int i = 0; i<nums.length; i++){
            if (i == 0){
                sumArr[i] = nums[i];
            }else{
                sumArr[i] = sumArr[i-1] + nums[i];
            }
        }
    }
}
