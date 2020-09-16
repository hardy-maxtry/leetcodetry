package bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<List<Integer>> printTree(){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = this;
        if(root == null){
            return result;
        }
        queue.offer(root);
        int currentLineCount = queue.size();
        int nextLineCount = 0;
        while(currentLineCount != 0){
            List<Integer> nextLineResult = new ArrayList<>();
            while(currentLineCount > 0) {
                TreeNode node = queue.poll();
                currentLineCount --;
                if (node != null){
                    nextLineResult.add(node.val);
                    if(node.left != null) {
                        queue.add(node.left);
                        nextLineCount++;
                    }else{
//                    nextLineResult.add(null);
                        queue.add(null);
                        nextLineCount++;
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                        nextLineCount++;
                    }else{
                        queue.add(null);
                        nextLineCount++;
//                    nextLineResult.add(null);
                    }
                }else{
                    nextLineResult.add(null);
                    queue.add(null);
                    queue.add(null);
                    nextLineCount++;
                    nextLineCount++;
                }

            }
            if(nextLineResult.size() != 0) {
                boolean allAreNull = true;
                for(Integer i : nextLineResult){
                    if (i!=null){
                        allAreNull = false;
                        break;
                    }
                }
                if (allAreNull){
                    break;
                }
                result.add(nextLineResult);
            }
            // 下一行
            currentLineCount = nextLineCount;
            nextLineCount = 0;
        }
        List<List<String>> resultStr = new ArrayList<>();
        Integer length = 2 << result.size();

        for(List<Integer> line : result){
            Integer lineSize = line.size();
            for(Integer i : line){
                System.out.print(new String(new char[length/(lineSize+1)]).replace("\0", " "));
                if(i == null){
                    System.out.print("_");
                }else{
                    System.out.print(i);
                }
            }
            System.out.println();
        }

        return result;
    }
}