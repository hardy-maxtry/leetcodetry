package solution.solution100_200;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int lines = triangle.size();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++){
            List<Integer> currentLine = triangle.get(i);
            if (i == 0){
                resultList.add(currentLine.get(0));
                continue;
            }
            int currentLineSize = currentLine.size();
            List<Integer> newResultList = new ArrayList<>();
            for(int j = 0; j < currentLineSize; j++){
                if (j == 0){
                    newResultList.add(resultList.get(0) + currentLine.get(j));
                }else if(j==currentLineSize-1){
                    newResultList.add(resultList.get(j-1) + currentLine.get(j));
                }else{
                    newResultList.add( Math.min(resultList.get(j-1),resultList.get(j)) + currentLine.get(j));
                }
            }
            resultList = newResultList;
        }
        return Collections.min(resultList);
    }
}
