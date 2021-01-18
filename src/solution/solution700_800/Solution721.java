package solution.solution700_800;

import java.util.*;

public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // email的下标，构建并查集使用，相同email只会有一个下标
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        // email和用户名的对应关系
        Map<String, String> emailToName = new HashMap<String, String>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        // 构建所有email的并查集
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }
        //
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            // 找到每一个email的root
            int index = uf.find(emailToIndex.get(email));
            // 基于root index，构建map，key为rootIndex，value为email集合
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            // 找到每个rootIndex的所有email，字母顺序排序
            Collections.sort(emails);
            // 根据第一个email地址找到对应的用户名
            String name = emailToName.get(emails.get(0));
            // 构建返回结果
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;



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
}
