package solution.solution1_100;

import java.util.Stack;

public class Solution42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        Integer tmpPeak = height[0];
        int result = 0;
        int tmpAggregate = 0;
        for (int i=0;i < height.length;i++){
            if (height[i]>=tmpPeak){
                // 累加结果

                while (!stack.isEmpty()){
                    int tmp = stack.pop();
                    result += tmpPeak-tmp;
                }
                stack.push(height[i]);
                tmpPeak = height[i];
            }


            if(height[i] < tmpPeak){
                stack.push(height[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Solution42 solution42 = new Solution42();
        int result = solution42.trap(input);
        System.out.println(result);
    }
}
