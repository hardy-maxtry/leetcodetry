package solution.solution1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Solution1018 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        long num = 0;
        for(int i = 0; i < A.length; i++){
            num = ((num << 1) + A[i]) % 10;
            System.out.println(num);
            result.add(num%5L == 0);
        }
        return result;
    }

    public static List<Boolean> prefixesDivBy5_2(int[] A) {
        List<Boolean> list = new ArrayList<Boolean>();
        int prefix = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            list.add(prefix == 0);
            System.out.println(prefix);

        }
        return list;
    }

    public static void main(String[] args) {
//        int[] aaa = {0,1,1,1,1,1};
        int[] aaa = {1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0};
        List<Boolean> r = prefixesDivBy5_2(aaa);
        for (Boolean aBoolean : r) {
            System.out.println(aBoolean);
        }
    }
}
