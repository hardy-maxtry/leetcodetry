public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        Solution1_20 solution1_20 = new Solution1_20();
//        Integer i = solution1_20.romanToInt("MCMXCIV");
//        System.out.println(i);
        String[] strs = new String[]{"flower","flow","flight"};
        String longestPrefix = solution1_20.longestCommonPrefix(strs);
        System.out.println(longestPrefix);

        String parentheses = "{[";
        Boolean parentheses_result = solution1_20.valid_parentheses(parentheses);
        System.out.println(parentheses_result);
    }
}
