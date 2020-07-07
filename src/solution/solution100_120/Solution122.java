package solution.solution100_120;

public class Solution122 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        Integer targetSum = sum - root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
            return true;
        }else if(targetSum != 0 && root.left == null && root.right == null){
            return false;
        }
        // else if(targetSum == 0 && (root.left != null || root.right != null)){
        //     return false;
        // }
        else{
            boolean rightResult = hasPathSum(root.right, targetSum);
            boolean leftResult = hasPathSum(root.left, targetSum);
            return leftResult || rightResult;
        }
    }
}
