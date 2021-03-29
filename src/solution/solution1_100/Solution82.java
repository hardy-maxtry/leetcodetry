package solution.solution1_100;

import bean.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode pre2 = pre;
        ListNode current = head;


        while (current != null){
            ListNode next = current.next;
            if (next!= null && current.val == next.val){
                while(next != null && next.val == current.val){
                    next = next.next;
                }
                pre2.next = next;
            }else{
                pre2 = current;
            }
            current = next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        String s = Integer.toHexString(1);
        int[] arr  = {1,2,3,3,4,4,5};
        ListNode head =  ListNode.build(arr);
        Solution82 solution82 = new Solution82();
        solution82.deleteDuplicates(head);
    }
}
