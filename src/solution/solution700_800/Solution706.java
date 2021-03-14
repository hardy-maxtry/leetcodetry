package solution.solution700_800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution706 {
    /** Initialize your data structure here. */

    private class IntegerPair {
        private int key;
        private int value;

        public IntegerPair(int key, int value){
            this.key = key;
            this.value = value;
        }

        public void setValue(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }

        public int getKey(){
            return this.key;
        }
    }

    private class IntegerPairComparator implements Comparator<IntegerPair>{
        @Override
        public int compare(IntegerPair o1, IntegerPair o2) {
            return o1.getKey() - o2.getKey();
        }
    }

    // 找一个合适的质数，取模用
    private int BASE = 769;

    // 下标为取模结果，值为store中对应链表的下标
    Integer[] keyArr;
    // 解决索引碰撞，使用链表存储相同索引下的值
    ArrayList<ArrayList<IntegerPair>> store;
    public Solution706() {
        this.keyArr = new Integer[BASE];
        this.store = new ArrayList<>();
    }

    public void put(int key, int value) {
        int tmp = key % BASE;
        if (this.keyArr[tmp] == null){
            // 当前取模值还没有对应的链表
            int currentLength = this.store.size();
            // keyArr存储store的下标
            this.keyArr[tmp] = currentLength;
            ArrayList<IntegerPair> newArrayList = new ArrayList<>();
            newArrayList.add(new IntegerPair(key, value));
            this.store.add(newArrayList);
        }else{
            ArrayList<IntegerPair> existedList = this.store.get(this.keyArr[tmp]);
            // 二分法查找下标
            IntegerPair newPair = new IntegerPair(key, value);
            int index = Collections.binarySearch(existedList, newPair, new IntegerPairComparator());
            if (index < 0){
                existedList.add(newPair);
                // 为二分法创造条件
                Collections.sort(existedList, new IntegerPairComparator());
            }else{
                existedList.get(index).setValue(value);
            }
        }
    }

    public void remove(int key) {
        int tmp = key % BASE;
        if (this.keyArr[tmp] == null){
            return;
        }else{
            ArrayList<IntegerPair> existedList = this.store.get(this.keyArr[tmp]);
            IntegerPair newPair = new IntegerPair(key, 0);
            int index = Collections.binarySearch(existedList, newPair, new IntegerPairComparator());
            if (index < 0){
                return;
            }else{
                existedList.remove(index);
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int tmp = key % BASE;
        if (this.keyArr[tmp] == null){
            return false;
        }else{
            ArrayList<IntegerPair> existedList = this.store.get(this.keyArr[tmp]);
            IntegerPair newPair = new IntegerPair(key, 0);
            int index = Collections.binarySearch(existedList, newPair, new IntegerPairComparator());
            if (index < 0){
                return false;
            }
            return true;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int tmp = key % BASE;
        if (this.keyArr[tmp] == null){
            return -1;
        }else{
            ArrayList<IntegerPair> existedList = this.store.get(this.keyArr[tmp]);
            IntegerPair newPair = new IntegerPair(key, 0);
            int index = Collections.binarySearch(existedList, newPair, new IntegerPairComparator());
            if (index < 0){
                return -1;
            }
            return existedList.get(index).getValue();
        }
    }

    public static void main(String[] args) {
        Solution706 myHashMap = new Solution706();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]


    }
}
