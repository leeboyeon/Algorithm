package BOJ.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj23757_아이들과선물상자 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> present = new LinkedList<>();
        // int[] present = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            present.add(value);
            max = Math.max(max, value);
        }
        st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> childs = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            childs.add(Integer.parseInt(st.nextToken()));
        }
        boolean flag = false;
        while (!childs.isEmpty()) {
            if (childs.peek() > max) {
                flag = true;
                break;
            }
            if (present.peek() >= childs.peek()) {
                int curP = present.poll();
                int curC = childs.poll();
                curP -= curC;
                present.offer(curP);
            }
        }
        if (flag == true) {
            sb.append("0");
            // System.out.println(0);
        } else {
            sb.append("1");
            // System.out.println(1);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        // System.out.println(sb.toString());
    }
}
