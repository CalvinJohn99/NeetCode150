import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        Map<Character, Integer> cCounts = new HashMap<>();
        int l = 0, maxF = 0;
        for (int r = 0; r < s.length(); r++) {
            cCounts.put(s.charAt(r), cCounts.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, cCounts.get(s.charAt(r)));
            while ((r-l+1) - maxF > k) {
                cCounts.put(s.charAt(l), cCounts.get(s.charAt(l)) - 1);
                l++;
            }
            longest = Math.max(longest, r-l+1);
        }   
        return longest;
    }

    public int characterReplacement2(String s, int k) {
        int longest = 0;
        Map<Character, Integer> Ccounts = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int windowLength = r - l + 1;
            Ccounts.put(s.charAt(r), Ccounts.getOrDefault(s.charAt(r), 0) + 1);
            while (windowLength - Collections.max(Ccounts.values()) > k && l <= r) {
                Ccounts.put(s.charAt(l), Ccounts.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide input");
            return;
        }
        String s = args[0];
        int k = Integer.parseInt(args[1]);
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement10(s, k));
    }

    public int characterReplacement10(String s, int k) {
        int res = 0;
        Map<Character, Integer> cCounts = new HashMap<>();
        int l = 0, maxF = 0;
        for (int r = 0; r < s.length(); r++) {
            cCounts.put(s.charAt(r), cCounts.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, cCounts.get(s.charAt(r)));
            while ((r-l+1) - maxF > k) {
                cCounts.put(s.charAt(l), cCounts.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}