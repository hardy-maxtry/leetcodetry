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

    public Integer search_insert_position(int[] nums, int target){
        if(nums.length == 0){
            return 0;
        }
        Boolean found = false;
        Integer max = nums.length - 1;
        Integer min = 0;
        Integer current = (max - min) / 2;

        Integer result = -1;
        while (!found){
            if(nums[current] == target){
                result = current;
                break;
            }
            if(nums[current] > target){
                max = current;
            }
            if(nums[current] < target){
                min = current;
            }
            if(max == min){
                if(nums[max] > target){
                    result = max;
                }else{
                    result = max + 1;
                }
                break;

            }
            if(max-min == 1){
                if(target <= nums[min]){
                    result = min;
                } else if(nums[max] >= target){
                    result = max;
                }else if(target > nums[max]){
                    result = max + 1;
                }
                break;
            }
            current = max - (max - min) / 2;

        }

        return result;
    }

    public String countAndSay(int n) {
        String input = "1";
        StringBuilder output = new StringBuilder("1");

        for(int i = 1; i < n; i++){
            int count = 1;
            Character currentNum = input.charAt(0);
             output = new StringBuilder();
            for(int j = 1; j < input.length(); j++){
                Character tmpCurrentNum = input.charAt(j);
                if(currentNum.equals(tmpCurrentNum)){
                    count ++;
                }else{
                    output.append(String.valueOf(count) + currentNum);
                    count = 1;
                }
                currentNum = tmpCurrentNum;

            }
            output.append(String.valueOf(count) +currentNum);


            input  = output.toString();
        }
        return output.toString();
    }

    // id 37 数独
    public void solveSudoku(char[][] board) {
        // 第i行的数字X是否被占用
        boolean[][] line = new boolean[9][10];
        // 第j列的数字X是否被占用
        boolean[][] column = new boolean[9][10];
        // 第i行第j列所在的九宫格的数字X是否被占用
        boolean[][][] block = new boolean[3][3][10];

        // 初始化
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int num = board[i][j] - '0'; // char 可以直接运算 ， ascii
                if (num>=1 && num <=9){
                    line[i][num] = true;
                    column[j][num] = true;
                    block[i/3][j/3][num] = true;
                }
            }
        }
        // 从左上角开始遍历
        calcSudokuRecursive(board, line, column, block, 0, 0);
    }

    public boolean calcSudokuRecursive(char[][]board, boolean[][]line, boolean[][]column, boolean[][][]block, int row, int col){
        if (col == 9){
            // 从0行0列开始遍历，每次遍历时列+1，当列越界时，列=0，并遍历下一行，当行越界时，表示已经遍历所有格，直接返回true
            // col越界，说明当前行的每一列都遍历完成，需要遍历下一行
            row++;
            col = 0;
            // row越界，说明所有行都遍历完成，没有冲突，得到最终解
            if (row == 9){
                return true;
            }
        }

        if (board[row][col] == '.'){
            // 当前格为空是，1~9填充遍历
            for (int x = 1; x <= 9 ; x ++){
                // 判断行，列，九宫格中数字X是否已经被占用
                boolean used = line[row][x] || column[col][x] || block[row/3][col/3][x];
                if(used){
                    // 已占用, X换下一个数字
                    continue;
                }else {
                    // 当前位置填充为已使用
                    line[row][x] = true;
                    column[col][x] = true;
                    block[row/3][col/3][x] = true;

                    board[row][col] = (char)(x+'0');
                    //
                    boolean xIsValid = calcSudokuRecursive(board,line,column, block, row, col + 1);
                    if(xIsValid){
                        // 当前位置填写X后，在下一个位置可用
                        return true;
                    }else{
                        // 当前位置填写X后，在下一个位置不可用
                        // 回溯, 使用空白填充，并将已使用状态重置为未使用
                        board[row][col] = '.';
                        line[row][x] = false;
                        column[col][x] = false;
                        block[row/3][col/3][x] = false;
                    }

                }
            }
        }else{
            // 当前格已有数字，直接进行下一个单元格计算
            return calcSudokuRecursive(board, line, column, block , row, col+1);
        }
        // (board[row][col] 填写了 1~9，全部都冲突的情况，才会走到这里
        return false;
    }

    public static void main(String[] args){
        Solution21_40 solution21_40 = new Solution21_40();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        solution21_40.solveSudoku(board);
        System.out.println(1);

    }
}
