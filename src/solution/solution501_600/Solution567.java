package solution.solution501_600;

import java.util.Arrays;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int tmpLength = 0;
        int[] s1CharCount = new int[26];
        int[] s1CharCountTmp = new int[26];
        for (int i = 0; i < s1.length();i++){
            s1CharCount[s1.charAt(i) - 'a']++;
            s1CharCountTmp[s1.charAt(i) - 'a']++;
        }

        int right = 0;
        int left = -1;
        while(right < s2.length()){
            int s2num = s2.charAt(right) - 'a';
            if (left == -1 && s1CharCount[s2num] > 0){
                left = right;
                s1CharCountTmp[s2num]--;
                tmpLength++;
            }else

            if (left != -1 && s1CharCount[s2num] == 0 ){
                left = -1;
                tmpLength = 0;
                s1CharCountTmp = Arrays.copyOf(s1CharCount, s1CharCount.length);
            }else

            if (left != -1 && s1CharCountTmp[s2num] == 0 && s1CharCount[s2num] > 0){
                while(left <= right && s1CharCountTmp[s2num] == 0){
                    s1CharCountTmp[s2.charAt(left) - 'a']++;
                    tmpLength --;
                    left++;
                }
                s1CharCountTmp[s2num]--;
                tmpLength++;
            }else if( left != -1 && s1CharCountTmp[s2num] > 0){
                s1CharCountTmp[s2num]--;
                tmpLength++;
            }


            if (tmpLength == s1.length()){
                return true;
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
//        String s1 = "hello";
//        String s2 = "ooolleoooleh";
        String s1 = "adc";
        String s2 = "dcda";
        Solution567 solution567 = new Solution567();
        System.out.println(solution567.checkInclusion(s1, s2));
    }
}
