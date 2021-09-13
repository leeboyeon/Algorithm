package Programmers;

import java.util.Arrays;

public class kakao6 {
    public static void main(String[] args) {
        int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
        int[][] skill = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };
        solution(board, skill);
    }

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        for (int k = 0; k < skill.length; k++) {
            if (skill[k][0] == 1) {
                // -
                for (int i = skill[k][1]; i <= skill[k][3]; i++) {
                    for (int j = skill[k][2]; j <= skill[k][4]; j++) {
                        board[i][j] -= skill[k][5];
                    }
                }
            } else if (skill[k][0] == 2) {
                // +
                for (int i = skill[k][1]; i <= skill[k][3]; i++) {
                    for (int j = skill[k][2]; j <= skill[k][4]; j++) {
                        board[i][j] += skill[k][5];
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // System.out.print(board[i][j]);
                if (board[i][j] > 0) {
                    answer++;
                }
            }
            // System.out.println();
        }
        System.out.println(answer);
        return answer;

    }
}
