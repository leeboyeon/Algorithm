package CodingTEST;

public class st {
    public static void main(String[] args) {
        int n = 5;
        boolean clockwise = true;
        solution(n, clockwise);
    }

    public static void solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];

        if (clockwise) {
            // 시계방향
            changeArrClock(answer, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            // 반시계방향
        }
        // return answer;
    }

    static void changeArrClock(int[][] answer, int n) {
        int value = 1;
        int size = n * n;
        int x = 0, y = 0;
        int col = n - 1;
        int row = n - 1;
        int check = 1;
        int tmp = 1;
        while (check <= size) {

            value = tmp;
            for (int i = 0; i < col; i++) {
                // 오른쪽으로 가로이동
                answer[x][y] = value++;
                y++;
                check++;
            }
            value = tmp;
            for (int i = 0; i < row; i++) {
                // 아래로 세로이동
                answer[x][y] = value++;
                x++;
                check++;
            }
            value = tmp;
            for (int i = 0; i < col; i++) {
                // 왼쪽으로 가로이동
                answer[x][y] = value++;
                y--;
                check++;
            }
            value = tmp;
            for (int i = 0; i < row; i++) {
                // 위쪽으로 세로이동
                answer[x][y] = value++;
                x--;
                check++;
            }
            tmp = value;
            int resize = checkLength(answer, n);
            if (resize == 1) {
                answer[x + 1][y + 1] = value;
                break;
            }
            if (resize > 1) {
                col = resize - 1;
                row = resize - 1;
                x++;
                y++;
            }

        }
    }

    static int checkLength(int[][] answer, int n) {
        int count = 0;
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            if (answer[mid][i] == 0) {
                count++;
            }
        }
        return count;
    }
}
