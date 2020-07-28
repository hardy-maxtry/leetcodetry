package solution.solution100_200;


import bean.TreeNode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right == null){
            return 1 + maxDepth(root.left);
        }
        if(root.left == null && root.right != null){
            return 1+ maxDepth(root.right);
        }
        return 1+Math.max( maxDepth(root.left),  maxDepth(root.right));
    }

    public static void main(String[] args){
        Solution104 solution104 = new Solution104();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(6);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Integer result = solution104.maxDepth(root);
        System.out.println(result);
    }
}
