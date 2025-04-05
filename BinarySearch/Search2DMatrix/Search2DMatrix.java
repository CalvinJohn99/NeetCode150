import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        int targetRow = -1;
        while (l <= r) {
            int m = l + ((r - l) / 2);
            int rowSize = matrix[m].length;
            if (target > matrix[m][rowSize - 1]) {
                l = m + 1;
            } else if (target < matrix[m][0]) {
                r = m - 1;
            } else {
                targetRow = m;
                break;
            }
        }
        if (targetRow == -1) {
            return false;
        } else {
            l = 0;
            r = matrix[targetRow].length - 1;
            while (l <= r) {
                int m = l + ((r - l) / 2);
                if (target > matrix[targetRow][m]) {
                    l = m + 1;
                } else if (target < matrix[targetRow][m]) {
                    r = m - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
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

            System.out.println(solution.searchMatrix(matrix, target));

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in input.");
        }
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
}