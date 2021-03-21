package solution.solution100_200;

import bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mapToIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; i++){
            mapToIndex.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorder, 0, preorder.length, 0, inorder.length, mapToIndex);
    }
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end, Map<Integer, Integer> mapToInorderIndex) {
        if (pre_end <= pre_start){
            return null;
        }

        int rootVal = preorder[pre_start];
        TreeNode root = new TreeNode(rootVal);

        int in_root_index = mapToInorderIndex.get(rootVal);

        int warp = in_root_index - in_start;

        root.left = buildTreeHelper(preorder, inorder, pre_start+1, pre_start+1+warp, in_start, in_root_index, mapToInorderIndex);
        root.right = buildTreeHelper(preorder, inorder, pre_start+1+warp, pre_end, in_root_index+1, in_end, mapToInorderIndex);

        return root;

    }

    public static void main(String[] args) {
        int[]  preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution105 solution105 = new Solution105();
        TreeNode node = solution105.buildTree(preorder,inorder);
        System.out.println(node.val);
    }
}
