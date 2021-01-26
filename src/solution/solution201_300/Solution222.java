package solution.solution201_300;

import bean.TreeNode;

public class Solution222 {
//    偷懒的方法
//    public int countNodes(TreeNode root) {
//        return count(root);
//    }
//
//    public int count(TreeNode n){
//        int i = 1;
//        if(n == null){
//            return 0;
//        }else{
//            i = i + count(n.left );
//            i = i + count(n.right);
//            return i;
//        }
//    }


    public int countNodes(TreeNode root) {
        // find depth with left node
        int depth = 0;
        if (root.left == null){
            return 1;
        }
        TreeNode tmp = root;
        while(tmp!=null){
            depth++;
            tmp = tmp.left;
        }

        return 0;
    }

    public int findRightPos(TreeNode root, int depth, int currentDepth, int currentPos) {
        TreeNode tmp = root;
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        int tmpDepth = currentDepth;
        while(rightChild.left != null){
            rightChild = rightChild.left;
            tmpDepth++;
        }
        if (tmpDepth == depth){
            // 右子树的左叶子节点存在
            // 不再需要计算左子树的叶子节点
            findRightPos(root.right, depth, currentDepth+1, currentPos);
        }else{
            // 右子树的左叶子节点不存在
            // 只计算左子树的叶子节点

        }
        return 0;
    }
}
