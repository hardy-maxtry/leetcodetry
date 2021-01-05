package solution.solution801_900;

import java.util.ArrayList;
import java.util.List;

public class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        char tmp = ' ';
        int count = 1;
        List<List<Integer>> result = new ArrayList<>();
        char[] cc = s.toCharArray();
        int tmpStart = 0;
        for (int i = 0; i < cc.length ; i++){
            char c = cc[i];
            if (c == tmp){
                count ++;
            }else{
                if (count >= 3){
                    List<Integer> tmpResult = new ArrayList<>();
                    tmpResult.add(tmpStart);
                    tmpResult.add(i-1);
                    result.add(tmpResult);
                }
                tmp = c;
                count = 1;
                tmpStart = i;
            }

        }
        if (count >= 3){
            List<Integer> tmpResult = new ArrayList<>();
            tmpResult.add(tmpStart);
            tmpResult.add(cc.length-1);
            result.add(tmpResult);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution830 solution830 = new Solution830();
        String s = "aaa";
        solution830.largeGroupPositions(s);
    }
}
