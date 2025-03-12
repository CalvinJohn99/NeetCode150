import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (char c : s.toCharArray()) {
            countS.put(c, countS.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        return countS.equals(countT);
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        // for (int i = 0; i < s.length(); i++) {
        //     if (charCount.containsKey(s.charAt(i))) {
        //         charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
        //     } else {
        //         charCount.put(s.charAt(i), 1);
        //     }
        // } 
        // for (int i = 0; i < t.length(); i++) {
        //     if (!charCount.containsKey(t.charAt(i))) {
        //         return false;
        //     }
        //     charCount.put(t.charAt(i), charCount.get(t.charAt(i)) - 1);
        // }
        for (Character key : charCount.keySet()) {
            if (charCount.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        boolean[] matched = new boolean[t.length()];
        for (int i = 0; i < s.length(); i++) {
            boolean foundMatch = false;
            for (int j = 0; j < t.length(); j++) {
                if (!matched[j] && (s.charAt(i) == t.charAt(j))) {
                    matched[j] = true;
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an array of strings as arguments");
            return;
        }

        String s = args[0];
        String t = args[1];

        Solution solution = new Solution();
        boolean result = solution.isAnagram10(s, t);
        System.out.println(result);
    }

    public boolean isAnagram10(String s, String t) {
        
    }
}