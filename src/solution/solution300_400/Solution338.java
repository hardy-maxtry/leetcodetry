package solution.solution300_400;

public class Solution338 {
    // 参考 https://leetcode-cn.com/problems/counting-bits/solution/yi-bu-bu-fen-xi-tui-dao-chu-dong-tai-gui-3yog/
    // i是偶数，二进制末尾为0，1的数量等于 i/2的1的数量
    // i是奇数，则i-1是偶数，i的二进制末尾为1，1的数量等于 i-1的1的数量+1，也就是i-1的末尾从0变1
    public int[] countBits(int num) {
        if (num == 0){
            int[] result = new int[1];
            result[0] = 0;
            return result;
        }


        int[] tmpArr = new int[num+1];
        tmpArr[0] = 0;
        tmpArr[1] = 1;
        for (int i = 1; i <= num; i ++){
            if (i % 2 == 0){
                tmpArr[i] = tmpArr[i/2];
            }else{
                tmpArr[i] = tmpArr[i/2]+1;
                //tmpArr[i] = tmpArr[i-1]+1;
            }
        }
        return tmpArr;

    }
}
