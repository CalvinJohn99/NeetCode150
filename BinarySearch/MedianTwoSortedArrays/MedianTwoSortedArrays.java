import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        int l = 0, r = A.length;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int ALeft = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
            int ARight = (i < A.length) ? A[i] : Integer.MAX_VALUE;
            int BLeft = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
            int BRight = (j < B.length) ? B[j] : Integer.MAX_VALUE;

            if (ALeft <= BRight && BLeft <= ARight) {
                if (total % 2 != 0) {
                    return Math.max(ALeft, BLeft);
                }
                return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
            } else if (ALeft > BRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
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

            String[] nums1Str = scanner.nextLine().trim().replace("[", "").replace("]", "").split(",");
            String[] nums2Str = scanner.nextLine().trim().replace("[", "").replace("]", "").split(",");
            int[] nums1 = new int[nums1Str.length];
            for (int i = 0; i < nums1Str.length; i++) {
                nums1[i] = Integer.parseInt(nums1Str[i]);
            }
            int[] nums2 = new int[nums2Str.length];
            for (int i = 0; i < nums2Str.length; i++) {
                nums2[i] = Integer.parseInt(nums2Str[i]);
            }
            System.out.println(solution.findMedianSortedArrays10(nums1, nums2));

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in input.");
        }
    }

    public double findMedianSortedArrays10(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        int l = 0, r = A.length;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int ALeft = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
            int ARight = (i < A.length) ? A[i] : Integer.MAX_VALUE;
            int BLeft = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
            int BRight = (j < B.length) ? B[j] :Integer.MAX_VALUE;

            if (ALeft <= BRight && BLeft <= ARight) {
                if (total % 2 != 0) {
                    return Math.max(ALeft, BLeft);
                } else {
                    return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
                }
            } else if (ALeft > BRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        
        return 0;
    }
}