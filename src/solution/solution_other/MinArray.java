package solution.solution_other;

// 剑指 Offer 11. 旋转数组的最小数字
public class MinArray {
    // 找最小值即可
    public int minArray1(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for(int i : numbers){
            if(i< min){
                min = i;
            }
        }
        return min ;
    }
    // 序列特性 只要出现 numbers[i] > numbers[i+1]  就说明 numnbers[i+1] 是数组旋转后的右侧序列起点
    public int minArray2(int[] numbers) {
        int min = numbers[0];

        for(int i : numbers){
            if( min > i ){
                return i;
            }
        }
        return min ;
    }
    // 二分法
    public int minArray3(int[] numbers) {
        int min = numbers[0];
        int i = 0;
        int j = numbers.length -1;
        while(i < j){
            int mid = i + (j-i) / 2;
            if (numbers[mid] > numbers[j]){
                i = mid +1;
            }else if(numbers[mid] < numbers[j]){
                j = mid;
            }else{
                j = j-1;
            }
        }
        return numbers[i] ;
    }
}
