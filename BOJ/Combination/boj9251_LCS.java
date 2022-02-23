package BOJ.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class boj9251_LCS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] lcs = new int[len2 + 1][len1 + 1];

        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        
        System.out.println(lcs[len2][len1]);
    }
}
