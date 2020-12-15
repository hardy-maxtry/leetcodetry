package solution.solution700_800;

public class Solution738 {
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            // 高位大于低位
            // 因此高位不可能为0，可以直接-1
            // 高位本身在运算中不会直接出现退位情况，最多出现高位=0，
            // 在后续str转int时，高位0被忽略，也就是实际上的退位
            // 当出现类似 11100的情况时，需要连续将高位置为0
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            // 找到最高一个出现递减的位数
            // 从该位的后一位开始，向低位遍历全部置为9，也就是退位
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }

    public int monotoneIncreasingDigits2(int N) {
        int res = 0;
        // 倍数
        int seed = 1;
        while (N > 0) {
            int num = N % 10;
            N /= 10;
            int high = N % 10;
            if (high > num) {
                // 高位大于低位，将低位全部置为9，高位数字-1
                res = seed*10 - 1;
                N -= 1;
            }else  {
                res = num * seed + res;
            }
            seed *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution738 solution738 = new Solution738();
        solution738.monotoneIncreasingDigits(11100);
    }
}
