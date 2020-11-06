package solution.solution1301_1400;

import java.util.*;

public class Solution1356 {

    class TmpClass{
        public Integer pos;
        public Integer value;
        public Integer countOf1;

        TmpClass(int pos, int value, int countOf1){
            this.pos = pos;
            this.value = value;
            this.countOf1 = countOf1;
        }
    }

    public int[] sortByBits(int[] arr) {
        List<TmpClass> tmpList = new ArrayList<>();
        for (int i = 0; i < arr.length ; i++){
            tmpList.add(new TmpClass(i, arr[i], getCountOf1(arr[i])));
        }
//        tmpList.sort(Comparator.comparing(x -> x.countOf1));
        tmpList.sort((x,y)->{
            int i = x.countOf1.compareTo(y.countOf1);
            if (i == 0){
                return x.value.compareTo(y.value);
            }else{
                return i;
            }

        });

        int[] result = new int[arr.length];

        for (int i = 0; i<arr.length; i++){
            result[i] = tmpList.get(i).value;
        }
        return result;


    }

    public int getCountOf1(int a){
        int count = 0;
        while(a!=0){
            count += a & 1;
            a = a>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1111,7644,1107,6978,8742,1,7403,7694,9193,4401,377,8641,5311,624,3554,6631};
        Solution1356 solution1356 = new Solution1356();
        solution1356.sortByBits(a);
    }


}
