import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> subBoxes = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                subBoxes.putIfAbsent(i/3 * 3 + j/3, new HashSet<>());
                if (rows.get(i).contains(board[i][j]) || cols.get(j).contains(board[i][j]) || subBoxes.get(i/3 * 3 + j/3).contains(board[i][j])) {
                    return false;
                }
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                subBoxes.get(i/3 * 3 + j/3).add(board[i][j]);
            }
        }
        return true;
    }

    // Method to parse the input into a char[][]
    private static char[][] parseInput(String input) {
    // Remove outer square brackets, quotation marks, white space, and split the rows
        input = input.replaceAll("\\[\\[", "").replaceAll("\\]\\]", "").replaceAll("\"", "").replaceAll("\\s", "");
        String[] rows = input.split("\\],\\[");
        char[][] board = new char[9][9];
        System.out.println("Rows: ");
        for (int i = 0; i < rows.length; i++) {
            System.out.println(rows[i]);
            String[] elements = rows[i].split(",");
            for (int j = 0; j < elements.length; j++) {
                board[i][j] = elements[j].charAt(0);
            }
        }
        return board;
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide the sudoku board.");
            return;
        }
        System.out.println("Raw input: " + args[0]);        
        char[][] board = parseInput(args[0]);
        System.out.println("Parsed board:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(board));
    }
}