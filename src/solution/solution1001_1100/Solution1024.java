package solution.solution1001_1100;

public class Solution1024 {
    /**
     * 寻找每个开始点start(初始开始点为0)，能找到的最远结束点未知end，并将end记录作为下一个start，继续遍历，直到最远位置>T
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching(int[][] clips, int T) {
        int current = 0, currentMaxPos = 0;
        int result = 0;
        while (currentMaxPos < T ){
            boolean nextFound = false;
            for (int[] clip : clips){
                if (clip[0] <= current && clip[1] > currentMaxPos){
                    currentMaxPos = Math.max(clip[1], currentMaxPos);
                    nextFound = true;
                }
            }
            current = currentMaxPos;
            result ++;
            if (!nextFound){
                return -1;
            }
        }
        return  result;

    }

    public static void main(String[] args){
        int[][] a= {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        Solution1024 solution1024 = new Solution1024();
        int result = solution1024.videoStitching(a,10);
        System.out.println(result);
    }

}
