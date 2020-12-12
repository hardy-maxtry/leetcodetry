package solution.solution401_500;

public class Solution415 {
    public String addStrings(String num1, String num2) {
        if (num1.equals("0")){return num2;}
        if (num2.equals("0")){return num1;}

        StringBuilder stringBuilder = new StringBuilder();
        char[] num1arr = num1.toCharArray();
        char[] num2arr = num2.toCharArray();
        int extraPlus = 0;
        // 竖式运算
        for (int i = 0; i < Math.max(num1arr.length, num2arr.length); i ++){
            // 从数字最右侧一位取做加数开始累加，如果超过了数字长度，则加数为0
            int tmpNum1 = i >= num1arr.length ? 0 : num1arr[num1arr.length - 1 - i] - '0';
            int tmpNum2 = i >= num2arr.length ? 0 : num2arr[num2arr.length - 1 - i] - '0';
            int tmpResult = tmpNum1 + tmpNum2 + extraPlus;
            stringBuilder.append(tmpResult % 10);
            extraPlus = tmpResult / 10;
        }
        if (extraPlus == 1){
            stringBuilder.append(extraPlus);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        System.out.println(solution415.addStrings("98","9"));
    }
}
