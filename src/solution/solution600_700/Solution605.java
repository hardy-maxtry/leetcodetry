package solution.solution600_700;

public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        if(flowerbed.length ==1){
            return n<=1 && flowerbed[0] == 0;
        }

        for(int i = 0; i < flowerbed.length; i ++){
            if(i==0 ){
                if( flowerbed[0]==0 && flowerbed[1]==0){
                    flowerbed[0] = 1;
                    n--;
                    i++;
                }

            }else if(i==flowerbed.length-1  ){
                if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0){
                    n--;
                }

            }else{
                if(flowerbed[i-1]==0 && flowerbed[i]==0
                        && flowerbed[i+1]==0){
                    n--;
                    flowerbed[i]=1;
                    i++;
                }
            }

        }
        return n<=0;
    }

    public static void main(String[] args) {
        Solution605 solution605 = new Solution605();
        int n = 1;
        int[] o = {1,0};
        solution605.canPlaceFlowers(o,n);
    }
}
