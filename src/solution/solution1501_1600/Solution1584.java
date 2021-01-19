package solution.solution1501_1600;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1584 {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        UnionFind uf = new UnionFind(length+1);

        ArrayList<Edge> edges = new ArrayList<>();
        //求边长,每个点和之后的点的距离，不需要求当前点和之前的点的距离，因为已经求过了
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (len != 0) {
                    edges.add(new Edge(i, j, len));
                }
            }
        }
        int ans =0;
        // 连线距离升序
        Collections.sort(edges);

        // 从小到大遍历连线
        for (Edge e : edges){
            int x = e.getX();
            int y = e.getY();

            if (uf.find(x) == uf.find(y)){
                // 说明两个点已经联通
                // 说明已经存在一条或者多条边，联通x和y，且长度小于当前连线
                continue;
            }
            // 连两个点
            uf.union(x, y);
            ans+= e.getLen();
        }
        return ans;
    }

    public class UnionFind {
        int[] parent;

        // 按长度初始化，每个节点初始指向自己
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // 连接节点，直接做路径压缩
        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        // 查找root
        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }

    class Edge implements Comparable<Edge> {
        private int x;
        private int y;
        private int len;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {//内置比较器实现按len升序
            return Integer.compare(this.len, o.len);
        }
    }


}
