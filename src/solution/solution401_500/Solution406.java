package solution.solution401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o2[0] -o1[0]; // 身高倒叙
                }else{
                    return o1[1] - o2[1]; // 同身高 排名正序
                }
            }
        });

        List<int[]> ans = new ArrayList<int[]>();
        // 插入操作，维护一个新的空序列
        // 1. 由于已经将数据按照身高降序排列，那么首先插入队列的一定是较大数字，
        // 2. 同时，由于已经按照出现个数升序排列，那么同身高人的出现个数一定不会大于当前序列的已有个数，插入到序列最后即可
        // 3. 当较大数字插入完成，例如有三个7，都插入完成，接下来有两个个6需要插入序列，可知一定是[6,m] [6,n]  m<n为顺序插入
        // 4. 可知 [6,m]插入到序列第m位时，下标>m的身高7的元素下标+1，但是因为6<7，所以不影响身高7 的[7, k] k>m中的k的升序排序和数值
        // 5. 以此类推  [6, n] 插入时，因为插入位置在 [6,m]之后，所以不会影响 [6,m]的m计数 也不会影响所有身高[7, l]  l>n 的k的升序排序和数值
        // 6, 再次类推  [5, x] 插入时，不会影响所有序列中的身高6和7的排序和计数’
        // 7  类推至 [0, y] 插入序列，不会影响所有序列中，身高>0的元素的排序和计数
        // 8 返回序列，转为数组即可
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Solution406 solution406 = new Solution406();
        int[][] a = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        solution406.reconstructQueue(a);
    }
}
