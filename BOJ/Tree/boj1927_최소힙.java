package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class boj1927_최소힙 {
    static int N;
    static PriorityQueue<Integer> heap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());

        heap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (heap.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(heap.poll()).append("\n");
                }
            } else {
                heap.add(value);
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
