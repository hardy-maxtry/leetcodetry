package solution.solution801_900;

import java.util.Arrays;
import java.util.List;

public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int n5 = 0, n10 = 0;
        for (int bill : bills){
            if ( bill == 5){
                n5++;
            }
            if(bill == 10){
                n10 ++;
                if (n5 > 0){
                    n5 --;
                }else{
                    return false;
                }

            }
            if (bill == 20){
                if (n10 > 0){
                    n10 --;
                    if (n5 > 0){
                        n5 --;
                    }else{
                        return false;
                    }
                }else{
                    if (n5 >=3){
                        n5 = n5-3;
                    }else{
                        return false;
                    }
                }
            }

        }
        return true;
    }
}
