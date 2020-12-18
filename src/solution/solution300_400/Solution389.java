package solution.solution300_400;

public class Solution389 {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a'] = arr[c-'a'] + 1;
        }
        for(char c : t.toCharArray()){
            arr[c-'a'] = arr[c-'a'] - 1;
            if(arr[c-'a'] < 0){
                return c;
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        Solution389 solution389 = new Solution389();
        String s = "abcd", t = "abcde";
        System.out.println(solution389.findTheDifference(s, t));
    }
}
