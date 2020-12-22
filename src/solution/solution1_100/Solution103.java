package solution.solution1_100;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        // 奇偶性，标记从哪个方向遍历
        int current = 1;
        // 当前行是否为null
        boolean allNull = false;
        List<List<Integer>> result = new ArrayList<>();
        // 存储当前行的临时数组
        List<TreeNode> currentNodes = new ArrayList<>();
        // 根节点直接进入当前行
        currentNodes.add(root);

        while(!allNull){
            // 下一行临时数组
            List<TreeNode> nextNodes = new ArrayList<>();
            // 当前行输出结果
            List<Integer> currentResult = new ArrayList<>();
            allNull = true;
            if (current%2 == 0){
                // 倒序遍历当前行节点
                for (int i = currentNodes.size() - 1; i >=0; i--){
                    // 如果当前节点不为null, 存储当前行输出结果
                    if (currentNodes.get(i) != null){
                        allNull = false;
                        currentResult.add(currentNodes.get(i).val);
                        // 注意，偶数行从右向左遍历
                        nextNodes.add(currentNodes.get(i).right);
                        nextNodes.add(currentNodes.get(i).left);
                    }
                }
            }else{
                // 注意，由于偶数行已经从右向左遍历，
                // 在奇数行拿到的当前行数组，已经是倒序遍历，因此再次倒序遍历可以得到正序的当前行节点
                for (int i = currentNodes.size() - 1; i >=0; i--){
                    if (currentNodes.get(i) != null){
                        allNull = false;
                        currentResult.add(currentNodes.get(i).val);
                        // 注意，偶数行从左向右遍历
                        nextNodes.add(currentNodes.get(i).left);
                        nextNodes.add(currentNodes.get(i).right);
                    }
                }
            }
            // 由于题目中不需要输出null节点，因此这里可以用 nextNodes.size()==0 代替
            if (allNull){
                break;
            }
            current++;
            currentNodes = nextNodes;
            result.add(currentResult);
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution103 solution103 = new Solution103();
        List<List<Integer>> result = solution103.zigzagLevelOrder(root);
        System.out.println(result.size());
    }
}
