package solution.solution700_800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import static java.util.Collections.binarySearch;

public class Solution705 {
    /** Initialize your data structure here. */

    // 找一个合适的质数，取模用
    private int BASE = 769;

    // 下标为取模结果，值为store中对应链表的下标
    Integer[] keyArr;
    // 解决索引碰撞，使用链表存储相同索引下的值
    ArrayList<ArrayList<Integer>> store;
    public Solution705() {
        this.keyArr = new Integer[BASE];
        this.store = new ArrayList<>();
    }

    public void add(int key) {
        int tmp = key % BASE;
        if (this.keyArr[tmp] == null){
            // 当前取模值还没有对应的链表
            int currentLength = this.store.size();
            // keyArr存储store的下标
            this.keyArr[tmp] = currentLength;
            ArrayList<Integer> newArrayList = new ArrayList<>();
            newArrayList.add(key);
            this.store.add(newArrayList);
        }else{
            ArrayList<Integer> existedList = this.store.get(this.keyArr[tmp]);
            // 二分法查找下标
            int index = Collections.binarySearch(existedList, key);
            if (index < 0){
                existedList.add(key);
                // 为二分法创造条件
                Collections.sort(existedList);
            }
        }
    }

    public void remove(int key) {
        int tmp = key % BASE;
        if (this.keyArr[tmp] == null){
            return;
        }else{
            ArrayList<Integer> existedList = this.store.get(this.keyArr[tmp]);
            int index = Collections.binarySearch(existedList, key);
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
            ArrayList<Integer> existedList = this.store.get(this.keyArr[tmp]);
            int index = Collections.binarySearch(existedList, key);
            if (index < 0){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution705 myHashSet = new Solution705();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // 返回 True
        myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // 返回 False ，（已移除）


    }
}
