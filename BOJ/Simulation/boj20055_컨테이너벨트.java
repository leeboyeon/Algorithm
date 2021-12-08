package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20055_컨테이너벨트 {
    static int N, K;
    static int[] container;
    static boolean[] check;
    static int blank;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        container = new int[N * 2 + 1];
        check = new boolean[N * 2 + 1];
        blank = 0;
        result = 0;
        container[0] = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N * 2 + 1; i++) {
            container[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            ++result;
            moveContainer();
            stepBy();
            if (blank >= K)
                break;
        }

        System.out.println(result);
    }

    // 1.벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    static void moveContainer() {
        container[0] = container[N * 2];
        check[0] = check[N * 2];
        for (int i = N * 2; i > 1; i--) {
            container[i] = container[i - 1];
            check[i] = check[i - 1];
        }
        container[1] = container[0];
        check[1] = check[0];

        // for (int i = 1; i < container.length; i++) {
        // System.out.print(container[i] + " ");
        // }
        // System.out.println();
    }

    // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한칸 이동할 수 있으면 이동.
    // 내구도 1이상이어야함
    static void stepBy() {
        if (check[N] == true) {
            check[N] = false;
        }

        for (int i = N - 1; i > 0; i--) {
            if (check[i] == false)
                continue;
            if (container[i + 1] > 0 && check[i + 1] == false) {
                check[i] = false;
                check[i + 1] = true;
                if (--container[i + 1] == 0)
                    blank++;
            }
        }
        if (container[1] > 0 && check[1] == false) {
            check[1] = true;
            if (--container[1] == 0)
                blank++;
        }

        if (check[N] == true)
            check[N] = false;

    }
}
