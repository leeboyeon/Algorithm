package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10804_카드역배치 {
    static Stack<Integer> s;
    static int[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[21];
        for (int i = 1; i < 21; i++) {
            map[i] = i;
        }
        int[] tmp = new int[21];
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map = solution(a, b, map);
        }

        for (int i = 1; i < map.length; i++) {
            System.out.print(map[i] + " ");
        }
    }

    public static int[] solution(int a, int b, int[] map) {
        s = new Stack<>();

        for (int j = a; j <= b; j++) {
            s.push(map[j]);
        }
        while (!s.isEmpty()) {
            for (int j = a; j <= b; j++) {
                map[j] = s.pop();
            }
        }
        return map;
    }
}
