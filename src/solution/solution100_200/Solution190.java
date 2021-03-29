package solution.solution100_200;

public class Solution190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++){
            // 每次循环，找到最低位，并累计到结果中，
            // 累计后，将结果左移1位，达到最右边的低位出现在结果的最左侧高位的目标
            result |= (n & 1) << (31-i);
            // 将原始数值右移1位，因为最低位已经计算过了，下一次循环要计算次低位
            n = n >>> 1;
        }
        return result;
    }
}
