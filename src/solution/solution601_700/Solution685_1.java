package solution.solution601_700;

public class Solution685_1 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int edgesCount = edges.length;
        // 入度数组, 由于输入项只有正数不含零，因此数组长度为count+1
        int[] inDegree = new int[edgesCount+1];
        // 计算每个节点的入度
        for(int[] edge : edges){
            inDegree[edge[1]]++;
        }

        // 步骤 2：先尝试删除构成入度为 2 的边，看看是否形成环
        for (int i = edgesCount - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                // 如果不构成环，这条边就是要去掉的那条边
                if (!judgeCircle(edges, edgesCount, i)) {
                    return edges[i];
                }
            }
        }

        // 步骤 3：再尝试删除构成入度为 1 的边，看看是否形成环
        for (int i = edgesCount - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 1) {
                // 如果不构成环，这条边就是要去掉的那条边
                if (!judgeCircle(edges, edgesCount, i)) {
                    return edges[i];
                }
            }
        }
//        throw new IllegalArgumentException("输入不符合要求。");



        System.out.println(edges);
        return null;
    }

    /**
     * 将 removeEdgeIndex 去掉以后，剩下的有向边是否构成环
     *
     * @param edges
     * @param len             结点总数（从 1 开始，因此初始化的时候 + 1）
     * @param removeEdgeIndex 删除的边的下标
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

        public int find(int x) {
            while (x != parent[x]) {
                // 路径压缩（隔代压缩）
                parent[x] = parent[parent[x]];
                x = parent[x];
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

            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;  // 这个实际也是路径压缩
            return true;
        }
    }


    public static void main(String[] args){
        int[][] edges = {{1,2}, {1,3}, {2,3}};
        Solution685_1 solution685 = new Solution685_1();
        solution685.findRedundantDirectedConnection(edges);
    }
}
