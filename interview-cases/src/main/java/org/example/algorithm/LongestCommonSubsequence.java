package org.example.algorithm;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String text1 = "abcd";
        String text2 = "dbca";
        int res=lcs.logestCommonSubsequence(text1, text2);
        System.out.println(res);
    }
    public int logestCommonSubsequence(String text1, String text2){
        int longest=0;
        int[] dp =new int[text1.length()];
        for(char c:text1.toCharArray()){
            int curLength = 0;
            for (int i=0;i<dp.length;i++){
                if(curLength<dp[i]){
                    curLength = dp[i];
                }else if(c==text1.charAt(i)){
                    dp[i]=curLength+1;
                    longest=Math.max(longest,curLength+1);
                }

            }

        }
        return longest;
    }
}
