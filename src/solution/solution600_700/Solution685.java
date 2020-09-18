package solution.solution600_700;

import solution.Solution21_40;



// 这个答案参考了如下答案，并附上了个人理解
//           作者：liweiwei1419
//                   链接：https://leetcode-cn.com/problems/redundant-connection-ii/solution/bing-cha-ji-java-by-liweiwei1419/
//                   来源：力扣（LeetCode）
//                   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Solution685 {
    /**
     * 本题中，
     * 有根树：存在一个且仅有一个根节点，此时根节点的入度为0
     * 冗余链接数量为1
     * 也就是 tree中的节点数量和边数量相同
     * 考虑三种冗余情况，
     * 1. 存在一个节点A，有两个节点指向A，也就是A的入度为2
     *      1.1 指向A的两个节点，其中一个导致了环路，此时直接返回导致环路的边即可
     *      1.2 指向A的两个节点，都没有导致环路，此时只需要删除在edges数组中后出现的那条导致入度为2的边即可，也就是返回后出现的这条边
     *      1.1和1.2可以合并，实际上只要从后向前遍历，删掉第一次出现的导致入度为2的边，判断edges剩下的边是否构成环路，只要不构成环，直接返回这条边即可
     * 2. 存在一个节点A，指向了根节点，使得根节点的入度从0变为1，此时必定形成有向图的环
     *  此时只需要删除环上的任意一条边，就可以恢复成有根树，根据题干，删除最后出现的导致环路的边即可
     *
     * @param edges
     * @return
     */

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int edgeCount = edges.length;
        int[] inDegrees = new int[edgeCount+1];

        // 计算入度
        for(int[] edge : edges){
            inDegrees[edge[1]]++;
        }

        // 步骤 2：先尝试删除构成入度为 2 的边，看看是否形成环
        for (int i = edgeCount - 1; i >= 0; i--) {
            if (inDegrees[edges[i][1]] == 2) {
                // 对于入度为2的点，删除edges数组中最后出现的导致入度为2的边，排查是否构成环
                // 如果不构成环，说明找到了冗余链接，这条边就是要去掉的那条边
                if (!judgeCircle(edges, edgeCount, i)) {
                    return edges[i];
                }
            }
        }
        // 如果步骤2没有return，说明不存在入度为2的点
        // 步骤 3：再尝试删除构成入度为 1 的边，看看是否形成环
        for (int i = edgeCount - 1; i >= 0; i--) {
            if (inDegrees[edges[i][1]] == 1) {
                // 如果不构成环，这条边就是要去掉的那条边
                if (!judgeCircle(edges, edgeCount, i)) {
                    return edges[i];
                }
            }
        }
        throw new IllegalArgumentException("输入不符合要求。");
    }

    /**
     * 将 removeEdgeIndex 去掉以后，剩下的有向边是否构成环
     *
     * @param edges
     * @param len             结点总数（从 1 开始，因此初始化的时候 + 1）
     * @param removeEdgeIndex 删除的边的下标，不参与环的计算
     * @return 构成环，返回 true
     */
    private boolean judgeCircle(int[][] edges, int len, int removeEdgeIndex) {
        UnionFind unionFind = new UnionFind(len + 1);
        for (int i = 0; i < len; i++) {
            if (i == removeEdgeIndex) {
                continue;
            }
            if (!unionFind.union(edges[i][0], edges[i][1])) {
                // 合并失败，表示 edges[i][0] 和 edges[i][1] 在一个连通分量里，即构成了环
                // 本题中，如果合并失败，说明有一个已经计算过root的节点，和一个还未计算过root的节点(在并查集中root指向自己)，他们有相同的root，
                // 也就是 当有1->2  2->3  3->4  4->1 时，经过3次计算，并查集 parent[2] parent[3] parent[4] 都为1，
                // 在计算4->1时，1的root是自己，本应该将1指向4，但是由于已经计算得出parent[4]==1 ,遍历到此时1和4两者root相同，出现了冲突，也就是环
                return true;
            }
        }
        return false;
    }

    private class UnionFind {
        // 代表元法
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

//        public int find(int x) {
//            while (x != parent[x]) {
//                // 路径压缩（隔代压缩）
//                parent[x] = parent[parent[x]];
//                x = parent[x];
//            }
//            return x;
//        }
        public int find(int x){
            int tmp, son;
            son = x;
            // 查找root
            while(parent[x] != x){
                x = parent[x];
            }
            // 路径压缩
            while (son != x){
                tmp = parent[son];
                parent[son] = x;
                son = tmp;
            }
            return x;
        }

        /**
         * @param x
         * @param y
         * @return 如果合并成功返回 true
         */
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            // 如果相等，说明在并查集中出现了两个节点指向相同的root，不需要合并
            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            return true;
        }

    }

    public static  void  main(String[] args){
        int[][] a = {{1,2}, {1,3}, {2,3}};
        Solution685 solution685 = new Solution685();
        int[] result = solution685.findRedundantDirectedConnection(a);
        System.out.println(result);
    }
}
