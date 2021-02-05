package solution.solution1201_1300;

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int result = 0;
        int[] diffArr = new int[s.length()];
        for (int i = 0; i < s.length(); i ++){
            diffArr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0;
        int right = 0;
        int tmpCost = Math.abs(s.charAt(0) - t.charAt(0));
        while(left < s.length()){
            while (tmpCost <= maxCost && right < s.length()){
                result = Math.max(result, right - left + 1);
                right++;
                if (right == s.length()){
                    break;
                }
                tmpCost+= diffArr[right];
            }
            if (right == s.length()){
                break;
            }
            tmpCost-=diffArr[left];
            left++;
            if (left > right && left < s.length()){
                right = left;
                tmpCost = diffArr[right];
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        String s = "abcd", t = "cdef";
//        int cost = 0;

        String s = "krpgjbjjznpzdfy";
        String t= "nxargkbydxmsgby";
        int cost = 14;
        Solution1208 solution1208 = new Solution1208();
        System.out.println(solution1208.equalSubstring(s,t,cost));
    }
}
