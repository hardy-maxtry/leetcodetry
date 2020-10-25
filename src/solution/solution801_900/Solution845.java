package solution.solution801_900;

public class Solution845 {
    public int longestMountain(int[] A) {
        int result = 0;
        int i = 0;
        while(i < A.length ){
            if (i == A.length-1)break;;
            int riseLength = 0, descendLengh = 0;

            while(i< A.length -1 && A[i] < A[i+1]){
                i++;
                riseLength ++;
            }
            while (i< A.length -1 && A[i] > A[i+1]){
                i ++;
                descendLengh ++;
            }
            if (riseLength>0 && descendLengh >0){
                result = Math.max(result, riseLength + descendLengh + 1);
            }

            while (i < A.length - 1 && A[i] == A[i+1]){
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution845 solution845 = new Solution845();
        int[] A = {2,1,4,7, 7,3,2,5};
//        int[] A = {2,1,4,7,7,3,2,5,4};
        int r = solution845.longestMountain(A);
        System.out.println(r);
    }
}
