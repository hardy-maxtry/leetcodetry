import solution.Solution1_20;
import solution.Solution21_40;
import solution.Solution41_60;

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


//        int search_insert_position_result = solution21_40.search_insert_position(new int[]{1,3,5,6}, 0);
//        int search_insert_position_result = solution21_40.search_insert_position(new int[]{0,3,5}, 0);
//        System.out.println(search_insert_position_result);


//        System.out.println("countAndSayResult");
//        for(int i = 1; i < 10; i++){
//            String countAndSayResult = solution21_40.countAndSay(i);
//            System.out.println(countAndSayResult);
//        }

        Solution41_60 solution41_60 = new Solution41_60();

        System.out.println("maximum_subarray");
        int maximum_subarray_result = solution41_60.maximum_subarray(new int[]{-3,101,-100,1000});
        System.out.println(maximum_subarray_result);

        int maximum_subarray_result2 = solution41_60.maximum_subarray2(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(maximum_subarray_result2);

    }
}
