package solutionByteDance;

public class Solution1016 {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];

        for (char c : s1.toCharArray()){
            count[c-'a'] = count[c-'a'] + 1;
        }


        int length = 0;
        for (int left=0; left < s2.length(); left++){
            length = 0;
            int[] copy = getCopyOfArray(count);
            for (int right=left; right < s2.length() && length <= s1.length(); right++){
                if (copy[s2.charAt(right) - 'a'] > 0){
                    copy[s2.charAt(right) - 'a'] = copy[s2.charAt(right) - 'a'] -1;
                    length ++;
                }else{
                    if (length == s1.length()){
                        return  true;
                    }
                    break;
                }
            }
            if (length == s1.length()){
                return  true;
            }
        }
        if (length == s1.length()){
            return  true;
        }
        return false;
    }

    public int[] getCopyOfArray(int[] arr){
        int[] result = new int[arr.length];
        for (int i = 0; i<arr.length ; i++){
            result[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1016 solution1016 = new Solution1016();
        System.out.println(solution1016.checkInclusion("adc", "dcda"));
    }
}
