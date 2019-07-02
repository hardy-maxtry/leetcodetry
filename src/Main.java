import solution.Solution1_20;
import solution.Solution21_40;

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

        Solution21_40 solution21_40 = new Solution21_40();
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int r = solution21_40.removeElement(nums, 2);
//        System.out.println(r);


        int r1 = solution21_40.implementStrStr2("aabaaabaaac", "aabaaac");
        System.out.println(r1);

    }
}
