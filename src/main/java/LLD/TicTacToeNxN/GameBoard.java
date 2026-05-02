package main.java.LLD.TicTacToeNxN;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {
    char[][] board;
    int boardSize;
    Queue<Player> nextTurn;
    Scanner input;

    public GameBoard(int boardSize, Player[] players) {
        this.boardSize = boardSize;
        this.board = new char[(2 * boardSize - 1)][(2 * boardSize - 1)];
        initialiseBoard(board);
        nextTurn = new LinkedList<>();
        nextTurn.offer(players[0]);
        nextTurn.offer(players[1]);
        input = new Scanner(System.in);
    }

    private void initialiseBoard(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(i % 2 == 0 && j % 2 != 0) board[i][j] = '|';
                if(i % 2 != 0 && j % 2 == 0) board[i][j] = '-';
                if(i % 2 != 0 && j % 2 != 0) board[i][j] = '+';
            }
        }
    }

    private void printBoard() {
        for(char[] row: board) {
            for(char col: row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public void startGame() {
        int count = 0;
        while(true) {
            count++;
            if(count == boardSize * boardSize + 1) {
                System.out.println("Match draw");
                break;
            }
            Player p = nextTurn.poll();
            int[] position = getUserInput(p);
            int row = position[0];
            int col = position[1];

            board[row][col] = p.getPlayerSymbol();
            printBoard();
            if(count >= boardSize && checkEndGame(p, row, col)) break;
            nextTurn.offer(p);
        }
    }

    private int[] getUserInput(Player p) {
        System.out.println(p.getPlayerName() + " please enter row number between 0 - " + (boardSize - 1));
        int row = input.nextInt();
        System.out.println(p.getPlayerName() + " please enter column number between 0 - " + (boardSize - 1));
        int col = input.nextInt();
        while (!validateInput(row, col)) {
            System.out.println("Please try again!");
            System.out.println(p.getPlayerName() + " please enter row number between 0 - " + (boardSize - 1));
            row = input.nextInt();
            System.out.println(p.getPlayerName() + " please enter column number between 0 - " + (boardSize - 1));
            col = input.nextInt();
        }
        return new int[]{2 * row, 2 * col};
    }

    private boolean validateInput(int row, int col) {
        if(row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            System.out.println("The row/col size is out of bound");
            return false;
        }

        if((int) board[2 * row][2 * col] != 0) {
            System.out.println("Position already filled");
            return false;
        }
        return true;
    }

    private boolean checkEndGame(Player p, int row, int col) {
        StringBuilder winString = new StringBuilder();

        for(int i = 0; i < boardSize; i++) {
            winString.append(p.getPlayerSymbol());
        }

        StringBuilder rowString = new StringBuilder();
        StringBuilder colString = new StringBuilder();
        StringBuilder diagonalString = new StringBuilder();
        StringBuilder reverseDiagonalString = new StringBuilder();

        for(int i = 0; i < board.length; i += 2) {
            rowString.append(board[row][i]);
            colString.append(board[i][col]);

            if(row == col) {
                diagonalString.append(board[i][i]);
            }

            if((row + col) == board.length - 1) {
                reverseDiagonalString.append(board[board.length - 1 - i][i]);
            }
        }

        if (winString.equals(rowString) || winString.equals(colString) || winString.equals(diagonalString) || winString.equals(reverseDiagonalString)) {
            System.out.println(p.getPlayerName() + " has won the game!");
            return true;
        }
        return false;
    }
}
