package solution.solution100_200;

import bean.ListNode;

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if ( head==null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode start = head;
        int pos = 0;
        int previousInsertPos = -1;
        int previousInsertValue = Integer.MAX_VALUE;
        while(current.next != null){
            ListNode next = current.next;
            if(next.val >= current.val){
                // next比末尾更大
                current = current.next;
                pos++;
                continue;
            }
            ListNode temp2 = start;
            ListNode temp3 = null;
            int i = 0;
            if (next.val > previousInsertValue){
                i = previousInsertPos + 1;
            }
            for (; i <= pos; i++){
                if (next.val < temp2.val ){
                    break;
                }
//                if (i > 0){
//                    temp3 = temp2;
//                }
                temp3 = temp2;
                temp2 = temp2.next;
            }
            previousInsertPos = i;
            if (i==0){
                // next比起点更小
//                ListNode temp3 = next;
                current.next = next.next;
                next.next = start;
                start = next;
            }else{
                current.next = next.next;
                next.next = temp2;
                temp3.next = next;
            }
            pos++;
        }
        return start;
    }

    public static  ListNode build(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode start = head;
        for (int i = 1; i < arr.length; i++){
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return start;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(4);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(3);
//        ListNode head = new ListNode(-1);
//        head.next = new ListNode(5);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(0);

        int[] arr = {-84,142,41,-17,-71,170,186,183,-21,-76,76,10,29,81,112,-39,-6,-43,58,41,111,33,69,97,-38,82,-44,-7,99,135,42,150,149,-21,-30,164,153,92,180,-61,99,-81,147,109,34,98,14,178,105,5,43,46,40,-37,23,16,123,-53,34,192,-73,94,39,96,115,88,-31,-96,106,131,64,189,-91,-34,-56,-22,105,104,22,-31,-43,90,96,65,-85,184,85,90,118,152,-31,161,22,104,-85,160,120,-31,144,115};
        ListNode head = build(arr);

        Solution147 solution147 = new Solution147();
        ListNode h = solution147.insertionSortList(head);
        while (h!=null){
            System.out.println(h.val);
            h=h.next;

        }
    }
}
