package solution;

import bean.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution81_100 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    // id 96
    public int numTrees(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        // resultArray存储的是，n个数字组成的搜索二叉树的个数
        int[] resultArray = new int[n+1];
        resultArray[0] = 1;
        resultArray[1] = 1;
        for(int i=2; i < n + 1; i++){
            int current = 0;
            // 遍历从1到i不同数字作为根节点，有多少种可能性
            for (int j = 1; j < i+1 ; j++){
                // 左侧树和右侧树所有可能性，实际上是个笛卡儿积
                // 因此数量直接相乘
                // 左子树和右子树的可能性，由于都没有重复数字，因此与具体数值无关，只与数字的个数有关
                current += resultArray[j-1] * resultArray[i-j];
            }
            resultArray[i] = current;
        }
        return resultArray[n];
    }

    // id 97
    public boolean isInterleave(String s1, String s2, String s3) {
        int rows = s1.length() + 1;
        int columns = s2.length() + 1;
        if (s3.length() != rows + columns - 2){
            return false;
        }

        // 普通解法
//        boolean[][] arr = new boolean[rows][columns];
//        arr[0][0] = true;

        // 滚动数组
        boolean[] arr2 = new boolean[columns];
        arr2[0] = true;

        for (int i = 0 ; i < rows; i++){
            for(int j = 0; j <columns; j++){
                int p = i+j-1;
                if (i == 0 && j > 0){
//                    arr[i][j] = arr[i][j-1] && (s2.charAt(j-1) == s3.charAt(p));
                    arr2[j] = arr2[j-1]  && (s2.charAt(j-1) == s3.charAt(p));
                }
                if (j == 0 && i > 0){
//                    arr[i][j] = arr[i-1][j] && (s1.charAt(i-1) == s3.charAt(p));
                    arr2[j] = arr2[j]  && (s1.charAt(i-1) == s3.charAt(p));
                }
                if (i > 0 && j > 0){
//                    arr[i][j] =  (arr[i][j-1]  && s2.charAt(j-1) == s3.charAt(p)  ) || ( arr[i-1][j]   && (s1.charAt(i-1) == s3.charAt(p)));
                    arr2[j] = (arr2[j-1]  && s2.charAt(j-1) == s3.charAt(p)  ) || ( arr2[j]   && (s1.charAt(i-1) == s3.charAt(p)));
                }
            }
        }
//        return arr[rows-1][columns-1];
        return arr2[columns-1];

    }

    // id 95
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return  new ArrayList<>();
        }
        return recursiveMakeTree(1, n);
    }

    public List<TreeNode> recursiveMakeTree(int start, int end){
        List<TreeNode> result = new ArrayList<>();

        if (start > end){
            result.add(null);
            return result;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftTrees = recursiveMakeTree(start,i-1);
            List<TreeNode> rightTrees = recursiveMakeTree(i+1, end);
            for (TreeNode left : leftTrees){
                for(TreeNode right: rightTrees){
                    TreeNode r = new TreeNode();
                    r.val = i;
                    r.left = left;
                    r.right = right;
                    result.add(r);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution81_100 solution81_100 = new Solution81_100();
//        System.out.println(solution81_100.numTrees(3));
//        String  s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
//        System.out.println(solution81_100.isInterleave(s1,s2,s3));
//        s1 = "aabcc";
//        s2 = "dbbca";
//        s3 = "aadbbbaccc";
//        System.out.println(solution81_100.isInterleave(s1,s2,s3));
//        s1= "ab";
//        s2= "bc";
//        s3 = "bbac";
//        System.out.println(solution81_100.isInterleave(s1,s2,s3));

        List<TreeNode> result95 = solution81_100.generateTrees(3);
        System.out.println(result95.size());
    }
}
