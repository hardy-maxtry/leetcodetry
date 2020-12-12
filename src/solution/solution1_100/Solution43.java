package solution.solution1_100;

import solutionByteDance.Solution1015;

public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){ return "0";}
//        char[] num1arr = num1.toCharArray();
        char[] num2arr = num2.toCharArray();
        String s = "";
        String result = "0";
        for (int i = num2arr.length - 1; i >= 0; i--){
            StringBuilder multiplySingleResult = new StringBuilder(multiplySingle(num1, num2arr[i]));
            for (int j = num2arr.length - 1; j > i; j--){
                multiplySingleResult.append(0);
            }
            result = addStrings(result, multiplySingleResult.toString());

        }
        return result;
    }


    // num2只有1位数
    public String multiplySingle(String num1, char num2) {
        if (num2 == '0'){
            return "0";
        }
        char[] num1arr = num1.toCharArray();
        int tmpNum2 = num2 - '0';
        int extraPlus = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num1arr.length; i++){
            int tmp = num1arr[num1arr.length - 1 - i] - '0';
            if (tmp == 0){
                stringBuilder.append(extraPlus);
                extraPlus = 0;
                continue;
            }
            int tmpResult = tmp * tmpNum2 + extraPlus;
            stringBuilder.append(tmpResult % 10);
            extraPlus = tmpResult / 10;
        }
        if (extraPlus != 0){
            stringBuilder.append(extraPlus);
        }
        return stringBuilder.reverse().toString();
    }


    // 工具函数 来源id 415
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
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.multiplySingle("408", '5'));
        System.out.println(solution43.multiply("92345", "555"));

    }
}
