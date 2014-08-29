package leecode.suroundedregion;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    static class Point {
        int x;int y;
        public Point(int xx, int yy) {
            x = xx;y=yy;
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length==0 || board[0].length==0) return;
        Deque<Point> queue = new LinkedList<>();
        for (int i = 0; i < board.length;i++) {
            if (board[i][0] == 'O') {
                queue.add(new Point(i,0));
            }
            if (board[i][board[i].length-1] == 'O') {
                queue.add(new Point(i,board[i].length-1));
            }
        }
        for (int j = 0; j < board[0].length;j++) {
            if (board[0][j] == 'O') {
                queue.add(new Point(0,j));
            }
            if (board[board.length-1][j] == 'O') {
                queue.add(new Point(board.length-1,j));
            }
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            board[p.x][p.y] = 'C';
            if (p.x>0 && board[p.x-1][p.y] == 'O') {
                queue.offer(new Point(p.x-1,p.y));
            }
            if (p.y>0 && board[p.x][p.y-1] == 'O') {
                queue.offer(new Point(p.x,p.y-1));
            }
            if (p.x < board.length-1 && board[p.x+1][p.y] == 'O') {
                queue.offer(new Point(p.x+1, p.y));
            }
            if (p.y < board[p.x].length-1 && board[p.x][p.y+1] == 'O') {
                queue.offer(new Point(p.x, p.y+1));
            }
        }
        for (int i = 0;i < board.length;i++) {
            for (int j = 0; j < board[i].length;j++) {
                if (board[i][j] == 'C') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

}