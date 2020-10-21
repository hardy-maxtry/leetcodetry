package solution.solution901_1000;

public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;

        while(i < name.length() && j < typed.length()){
            Character nameC = name.charAt(i);
            Character typedC = typed.charAt(j);

            if (nameC != typedC){
                return false;
            }

            // 计算连续相同字符串的长度
            Integer countSameCharName = 1;
            while(i + 1< name.length() && nameC == name.charAt(i+1)){
                countSameCharName++;
                i++;
            }
            Integer countSameCharTyped = 1;
            while(j + 1< typed.length() && typedC == typed.charAt(j+1)){
                countSameCharTyped++;
                j++;
            }
            if (countSameCharName > countSameCharTyped){
                return false;
            }

            if (i < name.length() && j < typed.length()){
                i++;
                j++;
            }

        }
        return  i == name.length() && j == typed.length();
    }

    public static void main(String[] args){
        Solution925 solution925 = new Solution925();
//        boolean b = solution925.isLongPressedName("alex", "aaleex");
//        boolean b = solution925.isLongPressedName("saeed", "ssaaedd");
//        boolean b = solution925.isLongPressedName("xnhtq", "xhhttqq");
        boolean b = solution925.isLongPressedName("pyplrz", "ppyypllr");

        System.out.println(b);
    }
}
