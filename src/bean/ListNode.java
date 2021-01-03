package bean;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode build(int[] arr){
        ListNode start = new ListNode(0);
        ListNode tmp = start;
        for (int i : arr){
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        return start.next;
    }

    public void print(){
        ListNode tmp = this;
        while(tmp != null){
            System.out.print(tmp.val);
            System.out.print(", ");
            tmp = tmp.next;
        }
    }
}