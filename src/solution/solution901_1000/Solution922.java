package solution.solution901_1000;

public class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        int oddPos = 0, evenPos = 0;
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++){
            if (i % 2 == 0){
                while(A[oddPos] % 2 != 0){
                    oddPos++;
                }
                result[i] = A[oddPos];
                oddPos++;
            }else{
                while(A[evenPos] % 2 == 0){
                    evenPos++;
                }
                result[i] = A[evenPos];
                evenPos++;
            }
        }
        return result;
    }

    public int[] sortArrayByParityII2(int[] A) {
        int oddPos = 1, evenPos = 0;
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++){
            if (A[i] % 2 == 0){
                result[evenPos] = A[i];
                evenPos= evenPos+2;
            }else{

                result[oddPos] = A[evenPos];
                oddPos = oddPos+2;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution922 solution922 = new Solution922();
        int[] a = {4,2,5,7};
        solution922.sortArrayByParityII2(a);
    }
}
