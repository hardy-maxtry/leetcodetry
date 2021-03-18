package solution.solution1_100;

import bean.ListNode;

import java.util.List;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left>=right){
            return head;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode currentNode = preHead.next;
        int i = 1;
        ListNode leftNode = preHead, rightNode = new ListNode(0);
        boolean isReverse = false;
        while(currentNode != null){
            if (i == left){
                isReverse = true;
                // 起始节点是翻转后的结束节点
                rightNode = currentNode;
            }
            if(i == right){
                // 翻转后的结束节点的next指向正确位置
                isReverse = false;
                rightNode.next = currentNode.next;
                // 将当前节点插入到最左侧
                ListNode tmpNode = leftNode.next;
                ListNode tmpNode2 = currentNode.next;
                leftNode.next = currentNode;
                leftNode.next.next = tmpNode;
                currentNode = tmpNode2;
            }else
            if (isReverse){
                // 将当前节点插入到最左侧
                ListNode tmpNode = leftNode.next;
                ListNode tmpNode2 = currentNode.next;
                leftNode.next = currentNode;
                leftNode.next.next = tmpNode;
//                currentNode.next = tmpNode;
                currentNode = tmpNode2;

            }else{
                // 未触发翻转的情况
                leftNode = currentNode;
                currentNode = currentNode.next;
            }
            i++;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution92 solution92 = new Solution92();
        ListNode result = solution92.reverseBetween(head,2,4);
    }
}
