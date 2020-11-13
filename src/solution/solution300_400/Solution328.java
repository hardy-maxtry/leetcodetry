package solution.solution300_400;

import bean.ListNode;
import solution.solution100_200.Solution122;

import java.util.List;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        int i = 2;
        if (head==null){
            return head;
        }
        if (head.next == null){
            return head;
        }
        if (head.next.next == null){
            return head;
        }
//        ListNode evenNode = head.next;
        ListNode evenNode = null;
        ListNode evenNodeStart = head.next;
        ListNode oddNode = head;
        ListNode current = evenNodeStart;
        while(current != null){
            if (i%2 == 1){
                oddNode.next = current;
                oddNode = current;

            }else{
                if (evenNode == null){
                    evenNode = current;
                }else{
                    evenNode.next = current;
                    evenNode = current;
                }


            }
            i++;
            ListNode tmp = current;
            current = current.next;
            tmp.next = null;

        }

        current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = evenNodeStart;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution328 solution328 = new Solution328();
        solution328.oddEvenList(head);
    }
}
