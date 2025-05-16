import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0, r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r) {
            int k = (l + r) / 2;
            int hoursTaken = 0;
            for (int pile : piles) {
                hoursTaken += Math.ceil((double) pile / k);
            }
            if (hoursTaken <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide testcase");
            return;
        }
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);

            String pilesStr = scanner.nextLine().trim().replace("[", "").replace("]", "");
            String[] piles = pilesStr.split(",");
            int[] pilesInt = new int[piles.length];
            for (int i = 0; i < piles.length; i++) {
                pilesInt[i] = Integer.parseInt(piles[i]);
            }
            int h = Integer.parseInt(scanner.nextLine().trim());

            Solution solution = new Solution();
            System.out.println(solution.minEatingSpeed10(pilesInt, h));

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in input.");
        }
    }

    public int minEatingSpeed10(int[] piles, int h) {
        int res = Integer.MAX_VALUE;
        int maxPile = 0;
        for (int i = 0; i < piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]);
        }
        int l = 0, r = maxPile;
        while (l <= r) {
            int k = (l + r) / 2;
            int timeToEat = 0;
            for (int pile : piles) {
                timeToEat += Math.ceil((double) pile / k);
            }
            if (timeToEat <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
}