package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] word = new String[N];
        int[] len = new int[N];
        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }
        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return Integer.compare(o1.length(), o2.length());
                }
            }
        });
        System.out.println(word[0]);
        for (int i = 1; i < word.length; i++) {
            if (word[i - 1].equals(word[i]))
                continue;
            System.out.println(word[i]);
        }
    }
}
