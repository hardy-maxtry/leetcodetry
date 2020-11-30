package solution.solution700_800;

public class Solution767 {
    public String reorganizeString(String S) {
        int[] charArr = new int[26];
        // 统计每个字母出现次数
        for (int i = 0; i < S.length(); i++){
            charArr[S.charAt(i)-'a'] = charArr[S.charAt(i)-'a'] + 1;
        }
        // 找到出现做多的字母
        int max = 0;
        int maxCharPos = 0;
        for (int i = 0; i < 26; i++){
            if (charArr[i] > max){
                max = charArr[i];
                maxCharPos = i;
            }
        }
        // 为了间隔出现字母，最多出现的字母的次数，不能大于 length/2 或 length/2 + 1
        int limit = 0;
        if (S.length() % 2 == 0){
            limit = S.length() / 2;
        }else{
            limit = S.length() / 2 + 1;
        }
        // 如果出现次数大于限制，直接返回失败
        if (max > limit){
            return "";
        }
        // 出现最多的字母，从下标0开始，间隔1位写入结果，也就是填满偶数位
        char[] result = new char[S.length()];
        int i = 0;
        for ( i = 0; i < S.length(); i=i+2){
            result[i] = (char)(maxCharPos + 'a');
            charArr[maxCharPos] = charArr[maxCharPos] - 1;
            if (charArr[maxCharPos] == 0){
                break;
            }
        }
        // 无论是否填满了偶数位
        // 下一个字母继续填充偶数位置，防止相邻
        i=i+2;
//        int resultPos = 0;
//        for (int i = 1; i < S.length(); i=i+2){
//            if (resultPos == maxCharPos){
//                resultPos++;
//            }
//            if (resultPos)
//        }
        // 遍历剩下的数组，间隔填充
        for (int j = 0; j < charArr.length; j++) {
            while (charArr[j]-- > 0) {
                // 如果下标大于字符串长度了，则下标回到1开始，也就是填充奇数位置
                // 由于偶数位置已经填充满了，因此后续填充不可能出现重复，否则与上述limit直接返回失败相冲突
                if (i >= result.length) {
                    i = 1;
                }
                result[i] = (char) (j + 'a');
                i += 2;
            }
        }
        return new String(result);



    }

    public static void main(String[] args) {
        Solution767 solution767 = new Solution767();
        solution767.reorganizeString("bfrbs");
    }
}
