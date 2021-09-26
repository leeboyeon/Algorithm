package Programmers;

import java.util.Stack;


public class 크레인인형뽑기 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int result = solution(board,moves);
        System.out.println(result);
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();


       for(int i=0;i<moves.length;i++){
           int cur = moves[i];
           for(int j=0;j<board.length;j++){
               if(board[j][cur-1] != 0){
                   if(stack.isEmpty()){
                        stack.push(board[j][cur-1]);
                        board[j][cur-1] = 0;
                        break;
                   }else{
                    if(stack.peek() == board[j][cur-1]){
                        stack.pop();
                        board[j][cur-1] = 0;
                        answer+=2;
                        break;
                    }
                    else{
                         stack.push(board[j][cur-1]);
                         board[j][cur-1] = 0;
                         break;
                    }
                   }
                  
               }else continue;
           }
       }
      
    
       System.out.println(stack.toString());
        return answer;
    }
}
