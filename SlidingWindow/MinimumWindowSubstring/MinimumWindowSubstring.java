import java.util.Map;
import java.util.HashMap;

class Solution {
    public String minWindowNeetCode(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tCounts = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCounts.put(c, tCounts.getOrDefault(c, 0) + 1);
        }
        int have = 0, need = tCounts.size();
        int resLength = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            // You must use .equals(), using '==' works with java cache (-127 to 128 vals)
            // beyond that range java creates Integer objects and doing '==' with 2
            // reference copies won't work
            if (tCounts.keySet().contains(c) && window.get(c).equals(tCounts.get(c))) {
                have++;
            }
            while (have == need) {
                if ((r - l + 1) < resLength) {
                    resLength = r - l + 1;
                    res[0] = l; res[1] = r;
                }
                c = s.charAt(l);
                window.put(c, window.get(c) - 1);
                // using .containsKey() slightly faster
                if (tCounts.keySet().contains(c) && window.get(c) < tCounts.get(c)) {
                    have--;
                }
                l++;
            }
        }
        // checking resLength != Integer.MAX_VALUE slightly faster
        return (resLength <= s.length()) ? s.substring(res[0], res[1] + 1) : "";
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide 2 Strings");
            return;
        }
        String s = args[0];
        String t = args[1];
        Solution solution = new Solution();
        System.out.println(solution.minWindow10(s, t));
    }

    public String minWindow10(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // length of valid min window, [left char index, right char index]
        int[] res = new int[]{Integer.MAX_VALUE, -1, -1};
        Map<Character, Integer> tCounts = new HashMap<>();
        Map<Character, Integer> sCounts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCounts.put(t.charAt(i), tCounts.getOrDefault(t.charAt(i), 0) + 1);
        }
        int need = tCounts.size(), have = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            sCounts.put(rightChar, sCounts.getOrDefault(rightChar, 0) + 1);
            if (tCounts.containsKey(rightChar) && sCounts.get(rightChar).equals(tCounts.get(rightChar))) {
                have++;
            }
            while (have == need) {
                if ((r - l + 1) < res[0]) {
                    res[0] = (r - l + 1);
                    res[1] = l;
                    res[2] = r;
                }
                char leftChar = s.charAt(l);
                sCounts.put(leftChar, sCounts.getOrDefault(leftChar, 1) - 1);
                if (tCounts.containsKey(leftChar) && sCounts.get(leftChar) < tCounts.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return (res[0] == Integer.MAX_VALUE) ? "" : s.substring(res[1], res[2] + 1);
    }
}