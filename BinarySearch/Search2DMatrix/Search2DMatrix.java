import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }
        if (!(top <= bot)) {
            return false;
        }
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[row][m] < target) {
                l = m + 1;
            } else if (matrix[row][m] > target) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static int[][] parseMatrix(String matrixLine) {
        matrixLine = matrixLine.replace("[[", "").replace("]]", "");
        String[] rows = matrixLine.split("\\],\\[");
        // System.out.println(Arrays.toString(rows));
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] values = rows[i].split(",");
            matrix[i] = new int[values.length];
            for (int j = 0; j < values.length; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }
        return matrix;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide testcase");
            return;
        } 
        Solution solution = new Solution();
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            int numArgs = Integer.parseInt(scanner.nextLine().trim());
            String matrixLine = scanner.nextLine().trim();
            int[][] matrix = parseMatrix(matrixLine);
            int target = Integer.parseInt(scanner.nextLine().trim());

            System.out.println(solution.searchMatrix10(matrix, target));

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in input.");
        }
    }

    public boolean searchMatrix10(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS-1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}