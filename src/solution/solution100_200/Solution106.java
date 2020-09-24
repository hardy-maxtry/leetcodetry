package solution.solution100_200;

import bean.TreeNode;

import java.util.Arrays;

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0){
            return null;
        }
        if (inorder.length == 1){
             TreeNode root = new TreeNode();
             root.val = inorder[0];
             return root;
        }
        int rootNum = postorder[postorder.length-1];
        TreeNode root = new TreeNode();
        root.val = rootNum;
        int rootPosInOrder = this.searchPosInArray(inorder, rootNum);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootPosInOrder);
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, inorderLeft.length);
        root.left = buildTree(inorderLeft, postorderLeft);

        int[] inorderRight = Arrays.copyOfRange(inorder,  rootPosInOrder+1, inorder.length);

        int[] postorderRight = Arrays.copyOfRange(postorder, inorderLeft.length, postorder.length-1);
        root.right = buildTree(inorderRight, postorderRight);
        return root;

    }

    public int searchPosInArray(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder){
        return null;
    }

    public static void main(String[] args){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        int[] result = Arrays.copyOfRange(inorder,0,inorder.length-1);
        Solution106 solution106 = new Solution106();
        TreeNode treeNode = solution106.buildTree(inorder, postorder);
        System.out.println(111);
    }
}
