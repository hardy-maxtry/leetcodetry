package solution.solution901_1000;

public class Solution941 {
    // 线性扫描
    public boolean validMountainArray(int[] A) {
        boolean hasUp = false;
        boolean hasDown = false;
        boolean switchUpDown = false;
        for(int i = 1 ; i < A.length; i++){
            if(A[i - 1] < A[i]){
                hasUp = true;
                if(switchUpDown){
                    return false;
                }
            }

            if(A[i - 1] == A[i]){
                return false;
            }

            if(A[i - 1] > A[i]){
                hasDown = true;
                switchUpDown = true;
            }
        }

        return hasUp && hasDown;
    }

    // 双指针
    public boolean validMountainArray2(int[] A) {
        int left = 1;
        int right = A.length -1;
        while(left < A.length){
            if (A[left] == A[left - 1]){
                return false;
            }
            if (A[left - 1] > A[left ]){
                break;
            }
            left ++;
        }

        while(right > 0){
            if (A[right] == A[right - 1]){
                return false;
            }
            if (A[right] > A[right - 1]){
                break;
            }
            right --;
        }
        return left > 1 &&  right < A.length-1 && left == right + 1;
    }

    public static void main(String[] args) {
        int[]  A = {3,2,1};
        Solution941 solution941 = new Solution941();
        boolean b = solution941.validMountainArray2(A);
        System.out.println(b);
    }
}
