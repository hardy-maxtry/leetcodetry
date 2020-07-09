package solution.solution_other;

public class ReSpacelcci {
    public int respace(String[] dictionary, String sentence) {
        if(sentence.length() == 0){
            return 0;
        }
        // dp下标相当于sentence长度
        int[] dp = new int[sentence.length()+1];
        dp[0] = 0;
        if(dictionary.length== 0){
            return sentence.length();
        }

        for(int i = 1 ; i < sentence.length() +1; i ++){
            dp[i] = dp[i-1]+1;
            for(String s : dictionary){
                if (i - s.length() >= 0 && sentence.substring(i-s.length(), i).equals(s)){
//                    System.out.println(i + ":" + sentence.substring(i-s.length(), i));
                    dp[i] = Math.min(dp[i], dp[i-s.length()]);
                }
            }
//            System.out.println(dp[i]);
        }

        return dp[sentence.length()];
    }
    public static void main(String[] args) {
        ReSpacelcci divingBoardIcci = new ReSpacelcci();
        String[] dictionary = new String[]{"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";
        int result = divingBoardIcci.respace(dictionary, sentence);

        System.out.println(result);


    }
}


