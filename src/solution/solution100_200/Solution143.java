package solution.solution100_200;

import bean.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        List<ListNode> listNodes = new LinkedList<>();
        ListNode tmp = head;
        do {
            listNodes.add(tmp);
            tmp = tmp.next;
        }while(tmp != null);
        int i = 0, j = listNodes.size() -1;
        while(i<j){
            listNodes.get(i).next = listNodes.get(j);
            i++;
            if (i==j){
                break;
            }
            listNodes.get(j).next = listNodes.get(i);
            j--;
        }
        // 结尾,也是原有链表的中点
        listNodes.get(i).next = null;


    }
}
