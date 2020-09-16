package solution.solution201_300;

import bean.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution226 {
    // dfs  前序遍历
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        // 交换当前节点左右子树
        TreeNode swap = root.left;
        root.left = root.right;
        root.right = swap;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // bfs 队列
    public TreeNode invertTreeBfs(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0){
            TreeNode node = queue.poll();

            // 交换当前节点左右子树
            TreeNode swap = node.left;
            node.left = node.right;
            node.right = swap;
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }
    public static  void main(String[] args){
        TreeNode root = new TreeNode();
        root.val = 4;
        root.left = new TreeNode();
        root.left.val = 2;
        root.right = new TreeNode();
        root.right.val = 7;
        root.left.left = new TreeNode();
        root.left.left.val = 1;
        root.left.right = new TreeNode();
        root.left.right.val = 3;
        root.right.left = new TreeNode();
        root.right.left.val = 6;
        root.right.right = new TreeNode();
        root.right.right.val = 9;
//        List<List<Integer>>  result = root.printTree();
        Solution226 solution226 = new Solution226();
//        TreeNode invertedTreeNode = solution226.invertTree(root);
        TreeNode invertedTreeNode = solution226.invertTreeBfs(root);
        List<List<Integer>>  result = invertedTreeNode.printTree();
//        System.out.println(result);
    }
}
