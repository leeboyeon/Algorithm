package SWEA.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class swea1221_GNS {
    static int N;
    static int[] tmp;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken();
            }
            hash(arr);
            System.out.println("#" + tc);
        }
    }

    public static void hash(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        map.put("ZRO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THR", 3);
        map.put("FOR", 4);
        map.put("FIV", 5);
        map.put("SIX", 6);
        map.put("SVN", 7);
        map.put("EGT", 8);
        map.put("NIN", 9);
        tmp = new int[N];
        for (int i = 0; i < N; i++) {
            int value = map.get(arr[i]);
            tmp[i] = value;
        }
        Arrays.sort(tmp);
        arr = new String[N];
        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int value = (int) entry.getValue();
            for (int i = 0; i < N; i++) {
                if (tmp[i] == value) {
                    arr[i] = (String) entry.getKey();
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
