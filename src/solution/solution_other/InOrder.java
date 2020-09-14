package solution.solution_other;

import bean.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    public List<Integer> inOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return null;
        }
        if (root.left != null){
            inOrder(root.left, result);
        }
        result.add(root.val);
        if (root.right != null){
            inOrder(root.right, result);
        }
        return result;
    }


    /**
     *  Morris 遍历算法
     *  寻找 predecessor : 某个节点的左子树上的最右一个节点
     *  实际上是将二叉树拆分为若干个小的二叉树，计算每个小二叉树的中序遍历
     *  给出以下二叉树，1是root
     *         1
     *     2        3
     *   4   5     6  7
     *   实际上可以拆分为
     *      2                   3
     *     4  5    和  1   和  6  7  三部分， 计算每个部分的中序遍历并拼接即可
     *     第一部分，将4视作第一部分的root，4是遍历起点，5是遍历终点，[5是1的predecessor], 此时5.right为null， 将5.right指向1，即可形成5->1顺序
     *     同时第一部分又拆分为4,  2,  5 三部分,  [4是2的predecessor]，此时4.right为null，将4.right指向2，即可形成4->2的顺序
     *     4是最左节点，是遍历的起点位置，4是4自己的predecessor，此时4没有左子树，记录4到result中
     *     4指向2，从2开始找predecessor，再次找到4，此时4.right有值，说明已经遍历过一次2的左子树，且左子树的值已经写入result，这时候将4.right的值，也就是2，写入result
     *     到这里，第一部分的2,4,5这个二叉树已经完成左节点和根节点遍历，继续遍历右子树5
     *     ！！！注意！！
     *     这里5没有左子树，因此认为左子树已经遍历完毕，直接将自己写入result，并遍历右子树5.right，这里已经指向了1，即最初的根节点，
     *     从1开始再次寻找predecessor，又找到5，并且发现5.right有值，说明是第二次遍历，并且1的左子树已经遍历完毕，因此将1写入result，并遍历1的右子树 1.right
     *                3
     *     第三部分 6   7 的计算方式类似第一部分，6是3的predecessor，遍历完成6之后，6.left==null，将6写入result，
     *     6.right指向3，再次从3开始查找predecessor，再次找到6，此时6.right有值，说明3的左子树遍历完成，将3写入result，并遍历3的右子树
     *     7.left==null 将7写入result，并遍历7.right，此时7.right为null，整体算法结束退出，获得result
     *
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = null;
        root.right = new TreeNode();
        root.right.val = 2;
        root.right.left = new TreeNode();
        root.right.left.val = 3;

        TreeNode comploxTreeNode = new TreeNode();
        comploxTreeNode.val = 1;
        comploxTreeNode.left = new TreeNode();
        comploxTreeNode.left.val = 2;
        comploxTreeNode.left.left = new TreeNode();
        comploxTreeNode.left.left.val = 4;
        comploxTreeNode.left.right = new TreeNode();
        comploxTreeNode.left.right.val = 5;
        comploxTreeNode.right = new TreeNode();
        comploxTreeNode.right.val = 3;
        comploxTreeNode.right.left = new TreeNode();
        comploxTreeNode.right.left.val = 6;


        InOrder inOrder = new InOrder();
        List<Integer> result = inOrder.inorderTraversal2(comploxTreeNode);
        result.forEach(x->{
            System.out.println(x);
        });

    }
}
