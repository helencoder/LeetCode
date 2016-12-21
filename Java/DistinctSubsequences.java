/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions 
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 * Here is an example:
 * S = "rabbbit", T = "rabbit"

 * Return 3. 
 */
public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        int sLength = S.length();
        int tLength = T.length();
        int[][] dp = new int[tLength + 1][sLength + 1];
        for (int i = 0; i < sLength; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= tLength; i++) {
            for (int j = 1; j <= sLength; j++) {
                dp[i][j] = dp[i][j - 1];
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[tLength][sLength];
    }

/**************************** updated 2014.09.24 *****************************/


    public int numDistinct(String S, String T) {
        int[] dp = new int[T.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < S.length(); i++) {
            for (int j = T.length() - 1; j >= 0; j--) {
                if (S.charAt(i) == T.charAt(j))
                    dp[j + 1] += dp[j];
            }
        }
        return dp[T.length()];
    }
}
