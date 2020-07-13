package solution;


import bean.ListNode;
import solution.solution_other.IntersectionOfTwoArraysII;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution1_20 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length;  i++){

            Integer otherInt = target - nums[i];
            if(map.containsKey(otherInt) && map.get(otherInt) != i){
                return new int[]{i, map.get(otherInt)};
            }else if(map.containsKey(otherInt) && otherInt == nums[i]){
                return new int[]{ map.get(otherInt), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two Nums matched");
    }

    public int reverse_integer(int x) {

        int result = 0;
        while(x != 0){

            int j = x % 10;
            x = x / 10;
            if(result > Integer.MAX_VALUE /10 || (result == Integer.MAX_VALUE / 10 && j > 7)){
                return 0;
            }
            if(result < Integer.MIN_VALUE /10 || (result == Integer.MIN_VALUE / 10 && j < -8)){
                return 0;
            }
            result = result * 10 + j;

        }
        return result;
    }

    public int romanToInt(String s) {
        HashMap<String , Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("IV",3);
        map.put("V",5);
        map.put("IX",8);
        map.put("X",10);
        map.put("XL",30);
        map.put("L",50);
        map.put("XC",80);
        map.put("C",100);
        map.put("CD",300);
        map.put("D",500);
        map.put("CM",800);
        map.put("M",1000);
        int result = 0;
        for(int i = 0; i<s.length(); i++){
            String current = s.substring( i-1 < 0 ? 0 : i-1, i+1);
            if(map.containsKey(current)){
                result += map.get(current);
            }else{
                result += map.get(s.substring(i,i+1));
            }
        }
        return result;
    }


    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length ==0 || strs[0].length()==0) return "";
        String shortestStr = strs[0];
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() < shortestStr.length()){
                shortestStr = strs[i];
            }
        }

        for(int i = shortestStr.length() ; i > 0; i--){
            result = shortestStr.substring(0,i);
            Boolean found = true;
            for(int j = 0; j < strs.length; j++){
                if(strs[j].indexOf(result) != 0){
                    found = false;
                    break;
                }
            }

            if(found){
                break;
            }
            result = "";
        }
        return result;
    }

    public boolean valid_parentheses(String s) {
        Boolean result = true;
        Stack<String> stringStack= new Stack<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("}","{");
        map.put("]","[");
        map.put(")","(");
        for(int i = 0; i < s.length(); i ++){
            String current = s.substring(i,i+1);
            if(map.containsKey(current) ){
                if(stringStack.isEmpty()){
                    return false;
                }
                if(!stringStack.pop().equals(map.get(current)) ){
                    return false;
                }
            }else{
                stringStack.push(current);
            }
        }
        if(!stringStack.isEmpty()){
            return false;
        }
        return result ;
    }

    // id 2




    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode header = result;
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        if(l1 == null && l2 == null){
            return result;
        }
        int sum = l1.val + l2.val;
        result.val = sum >= 10 ? sum - 10 : sum;
        int plus = sum >= 10 ? 1 : 0;
        while(l1.next != null && l2.next !=null){
            int temp1 = l1.next.val;
            int temp2 = l2.next.val;
            sum = temp1 + temp2 + plus;
            result.next = new ListNode(0);
            result = result.next;
            result.val = sum >= 10 ? sum - 10 : sum;
            plus = sum >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1.next!= null){
            int temp1 = l1.next.val;
            sum = temp1 + plus;
            result.next = new ListNode(0);
            result = result.next;
            result.val = sum >= 10 ? sum - 10 : sum;
            plus = sum >= 10 ? 1 : 0;
            l1 = l1.next;
        }
        while(l2.next!= null){
            int temp2 = l2.next.val;
            sum = temp2+ plus;
            result.next = new ListNode(0);
            result = result.next;
            result.val = sum >= 10 ? sum - 10 : sum;
            plus = sum >= 10 ? 1 : 0;
            l2 = l2.next;
        }
        if (plus == 1){
            result.next = new ListNode(1);
        }
        return header;
    }

    // id 3
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        // 字符在s中出现的最大位置
        Map<Character, Integer> charPosMap = new HashMap<>();
        // 子串起始位置
        Integer left = 0;
        for(int i = 0; i < s.length(); i++){
            if(charPosMap.containsKey(s.charAt(i))){
                // 丢弃重复字符出现位置，以及左侧的所有字符
                // charPosMap 存储的是重复字符的上一次出现位置
                left = Math.max(left, charPosMap.get(s.charAt(i))+1);
            }
            charPosMap.put(s.charAt(i), i);
            result = Math.max(result, i - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1_20 solution1_20 = new Solution1_20();

//        // id 2
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        ListNode result = solution1_20.addTwoNumbers(l1, l2);
//        while(result != null){
//            System.out.println(result.val);
//            result = result.next;
//        }
        // id 3
        int result = solution1_20.lengthOfLongestSubstring("aaaaabcabbb");
        System.out.println(result);
    }
}
