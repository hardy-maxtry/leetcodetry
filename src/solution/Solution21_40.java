package solution;

import bean.ListNode;

public class Solution21_40 {

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode result ;
        if(l1.val <= l2.val){
            result = new ListNode(l1.val);
            l1 = l1.next;
        }else{
            result = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode tmp = result;
        while(l1 !=null && l2 != null){
            if(l1.val <= l2.val){
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;

        return result;

    }


    public int removeuplicatesFromSortedArray(int[] nums) {
        int i = 0;
        for(int j = 0; j<nums.length; j++){
            if(nums[i] == nums[j]){
                continue;
            }else{
                i++;
                nums[i] =  nums[j];

            }
        }
        return i+1;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j<nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
                continue;
            }else{
                if(j+1 < nums.length){
//                    j++;
                    nums[i] =  nums[j+1];
                }


            }
        }
        return i;

    }

    public int implementStrStr(String haystack, String needle) {
        int result = -1;
        if(needle.length() > haystack.length()){
            return -1;
        }
        if(needle.equals("")){
            return 0;
        }
        int j = 0;
        for(int i=0; i < haystack.length(); i++){
            String currentHayStack = haystack.substring(i, i+1);
            String currentNeedle = needle.substring(j, j+1);
            if(currentHayStack.equals(currentNeedle) ){
                if(result == -1){
                    result = i;

                }
                j++;
                if(j == needle.length()){
                    return result;
                }
            }else{
                j = 0;
                if(result >= 0){
                    i= result;
                }

                result = -1;


            }
        }
        if(j < needle.length()){
            return -1;
        }
        return result;
    }

    public int implementStrStr2(String haystack, String needle) {
        int result = -1;
        if(needle.length() > haystack.length()){
            return -1;
        }
        if(needle.equals("")){
            return 0;
        }
        int j = 0;
        for(int i=0; i < haystack.length(); i++){
            if(i+needle.length() > haystack.length()){
                return -1;
            }
            String currentHayStack = haystack.substring(i, i+needle.length());

            if(currentHayStack.equals(needle) ){
                return i;
            }
        }
//        if(j < needle.length()){
//            return -1;
//        }
        return result;
    }
}
