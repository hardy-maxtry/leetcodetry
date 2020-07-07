package solution.solution_other;

public class DivingBoardIcci {
    public int[] divingBoard(int shorter, int longer, int k) {

        if(k==0){
            return new int[0];
        }
        if(shorter == longer){
            int[] result = new int[1];
            result[0] = k + shorter;
            return result;
        }
        int[] result= new int[k+1];
        for(int i = 0; i <= k ; i ++){
            result[i] = shorter * (k-i) + longer * i;
        }
        return result;
    }
    public static void main(String[] args) {
        DivingBoardIcci divingBoardIcci = new DivingBoardIcci();
        int[] result = divingBoardIcci.divingBoard(3,4,5);
        for (int i : result) {
            System.out.println(i);
        }

    }
}


