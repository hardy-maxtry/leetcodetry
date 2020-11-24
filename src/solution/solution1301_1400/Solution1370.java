package solution.solution1301_1400;

public class Solution1370 {
    public String sortString(String s) {
        int[] charArr= new int[26];
        StringBuffer result = new StringBuffer();
        for(Character c: s.toCharArray()){
            charArr[c-'a']=charArr[c-'a']+1;
        }
        while(true){
            String tmp = getStrSeq(charArr);
            if (tmp.length()==0) break;
            result.append(tmp);
            tmp = getStrReversed(charArr);
            if (tmp.length()==0) break;
            result.append(tmp);

        }
        return result.toString();
    }

    public String getStrSeq(int[] charArr){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 26;i++){
            if(charArr[i] > 0){
                charArr[i] = charArr[i] -1;
                stringBuffer.append((char)(i+'a'));
            }
        }
        return stringBuffer.toString();
    }
    public String getStrReversed(int[] charArr){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 25; i >=0;i--){
            if(charArr[i] > 0){
                charArr[i] = charArr[i] -1;
                stringBuffer.append((char)(i+'a'));
            }
        }
        return stringBuffer.toString();
    }
}
