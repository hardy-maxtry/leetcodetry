package solution.solution1201_1300;

import java.util.*;

public class Solution1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 构建并查集
        Integer[] disjointSet = new Integer[s.length()];
        // 构建高度
        Integer[] rank = new Integer[s.length()];
        Arrays.fill(rank ,0);
        for (int i = 0; i < s.length(); i++){
            disjointSet[i] = i;
        }
        // 方法1
//        for (List<Integer> pair: pairs){
//            int x = findRoot(pair.get(0), disjointSet);
//            int y = findRoot(pair.get(1), disjointSet);
//
////            if (x!=y){
////                // x的父节点是y
////                disjointSet[x] = y;
////            }
//            // 此时说明根节点属于两个联通分量，需要组合
//            if (x!=y){
//                // 路径简化
//                if (rank[x] == rank[y]){
//                    // 高度相同时，取前者作为父节点，该节点高度+1
//                    rank[x]++;
//                    disjointSet[y] = x;
//                }else if (rank[x] >= rank[y]){
//                    // 将较低的树挂靠到较高的树下，两者高度均不改变
//                    disjointSet[y] = x;
//                }else{
//                    // 将较低的树挂靠到较高的树下，两者高度均不改变
//                    disjointSet[x] = y;
//                }
//            }
//        }

        // 方法2
        for (List<Integer> pair: pairs){
            int x = findRoot2(pair.get(0), disjointSet);
            int y = findRoot2(pair.get(1), disjointSet);

//            if (x!=y){
//                // x的父节点是y
//                disjointSet[x] = y;
//            }
            // 此时说明根节点属于两个联通分量，需要组合
            if (x!=y){
//                disjointSet[y] = x;
                // 路径简化
                if (rank[x] == rank[y]){
                    // 高度相同时，取前者作为父节点，该节点高度+1
                    rank[x]++;
                    disjointSet[y] = x;
                }else if (rank[x] >= rank[y]){
                    // 将较低的树挂靠到较高的树下，两者高度均不改变
                    disjointSet[y] = x;
                }else{
                    // 将较低的树挂靠到较高的树下，两者高度均不改变
                    disjointSet[x] = y;
                }
            }
        }

        // 小根堆
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            int root = findRoot(i, disjointSet);

            if (!map.containsKey(root)){
                map.put(root, new PriorityQueue<>());
            }
            map.get(root).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            sb.append(map.get(findRoot(i, disjointSet)).poll());
        }
        return sb.toString();



    }



    public int findRoot(int x, Integer[] disjointSet){
        if (x != disjointSet[x]){
            return findRoot(disjointSet[x], disjointSet);
        }
        return x;
    }

    // 路径压缩
    public int findRoot2(int x, Integer[] disjointSet){
        if (x != disjointSet[x]){
            disjointSet[x] =  findRoot2(disjointSet[x], disjointSet);
        }
        return disjointSet[x];
    }

    public static void main(String[] args){
        Solution1202 solution1202 = new Solution1202();
//        int[][] arr = {{0,3},{1,2},{0,2}};
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(0);arr1.add(3);
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(1);arr2.add(2);
        List<Integer> arr3 = new ArrayList<>();
        arr3.add(0);arr3.add(2);
        arr.add(arr1);
        arr.add(arr2);
        arr.add(arr3);

        System.out.println(solution1202.smallestStringWithSwaps("dcab", arr));
    }
}
