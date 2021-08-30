package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MonthTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] tmp = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == -1) {
                        tmp[i][j] = 0;
                    } else {
                        sum += map[i][j];
                        for (int go = 1; go < N; go++) {
                            if (i - go >= 0 && i - go < N && j - go >= 0 && j - go < N) {
                                if (map[i - go][j - go] != -1) {
                                    sum += map[i - go][j - go];
                                } else {
                                    break;
                                }

                            }
                        }
                        for (int go = 1; go < N; go++) {
                            if (i - go >= 0 && i - go < N && j + go >= 0 && j + go < N) {
                                if (map[i - go][j + go] != -1) {
                                    sum += map[i - go][j + go];
                                } else {
                                    break;
                                }
                            }
                        }
                        for (int go = 1; go < N; go++) {
                            if (i + go >= 0 && i + go < N && j + go >= 0 && j + go < N) {
                                if (map[i + go][j + go] != -1) {
                                    sum += map[i + go][j + go];
                                } else {
                                    break;
                                }

                            }
                        }
                        for (int go = 1; go < N; go++) {
                            if (i + go >= 0 && i + go < N && j - go >= 0 && j - go < N) {
                                if (map[i + go][j - go] != -1) {
                                    sum += map[i + go][j - go];
                                } else {
                                    break;
                                }

                            }
                        }

                    }
                    tmp[i][j] = sum;
                    sum = 0;
                }
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, tmp[i][j]);
                }
            }
            System.out.println("#" + tc + " " + max);

        }
    }
}
