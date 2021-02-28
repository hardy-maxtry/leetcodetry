package solution.solution801_900;

public class Solution896 {
    public boolean isMonotonic(int[] A) {
        if (A.length <=1){
            return true;
        }

        boolean isUp = false;
        boolean isDown = false;
        for (int i = 1; i < A.length; i++){
            if (A[i] < A[i-1]){
                isDown = true;
                if (isUp){
                    return false;
                }
            }else
            if (A[i] > A[i-1]){
                isUp = true;
                if (isDown){
                    return false;
                }
            }

        }
        return true;
    }
}
