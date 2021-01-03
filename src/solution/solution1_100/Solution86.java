package solution.solution1_100;

import bean.ListNode;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode preLeft = new ListNode(0);
        ListNode tmpLeft = preLeft;
        ListNode preRight = new ListNode(0);
        ListNode tmpRight = preRight;
        ListNode tmp = head;
        while(tmp!=null){
            if (tmp.val < x){
                tmpLeft.next = tmp;
                tmpLeft = tmpLeft.next;
                tmp = tmp.next;
                tmpLeft.next = null;
            }else{
                tmpRight.next = tmp;
                tmpRight = tmpRight.next;
                tmp = tmp.next;
                tmpRight.next = null;
            }

        }
//        tmpLeft = preLeft;
//        while (tmpLeft!=null){
//
//        }
        tmpLeft.next = preRight.next;
        return preLeft.next;
    }


    public static void main(String[] args) {
        Solution86 solution86 = new Solution86();
        int[] arr = {1,4,3,2,5,2};
        ListNode node = ListNode.build(arr);
        ListNode result = solution86.partition(node, 3);
        result.print();
    }
}
