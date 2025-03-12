import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Counts[i] == s2Counts[i]) {
                matches++;
            }
        }
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }
            int index = s2.charAt(r) - 'a';
            s2Counts[index]++;
            if (s1Counts[index] == s2Counts[index]) {
                matches++;
            } else if (s1Counts[index] + 1 == s2Counts[index]) {
                matches--;
            }
            index = s2.charAt(l) - 'a';
            s2Counts[index]--;
            if (s1Counts[index] == s2Counts[index]) {
                matches++;
            } else if (s1Counts[index] - 1 == s2Counts[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }

    public boolean checkInclusionWithMap(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Counts = new HashMap<>();
        Map<Character, Integer> s2Counts = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Counts.put(s1.charAt(i), s1Counts.getOrDefault(s1.charAt(i), 0) + 1);
            s2Counts.put(s2.charAt(i), s2Counts.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int matching = 0;
        for (Character key : s2Counts.keySet()) {
            if (s1Counts.containsKey(key) && s1Counts.get(key).equals(s2Counts.get(key))) {
                matching++;
            }
        }
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matching == s1Counts.keySet().size()) {
                return true;
            }
            char c = s2.charAt(r);
            s2Counts.put(c, s2Counts.getOrDefault(c, 0) + 1);
            if (s1Counts.containsKey(c) && s1Counts.get(c).equals(s2Counts.get(c))) {
                matching++;
            } else if (s1Counts.containsKey(c) && (s2Counts.get(c)).equals(s1Counts.get(c)+1)) {
                matching--;
            }
            char leftChar = s2.charAt(l);
            s2Counts.put(leftChar, s2Counts.get(leftChar) - 1);
            if (s1Counts.containsKey(leftChar) && s1Counts.get(leftChar).equals(s2Counts.get(leftChar))) {
                matching++;
            } else if (s1Counts.containsKey(leftChar) && (s2Counts.get(leftChar).equals(s1Counts.get(leftChar)-1))) {
                matching--;
            }
            l++;
        }
        return matching == s1Counts.keySet().size();
    }

    public boolean checkInclusion3(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Counts = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Counts.put(c, s1Counts.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> s2Counts = new HashMap<>();
        for (char c : s2.substring(0, s1.length()).toCharArray()) {
            s2Counts.put(c, s2Counts.getOrDefault(c, 0) + 1);
        }
        if (s2Counts.equals(s1Counts)) {
            return true;
        }
        s2Counts.put(s2.charAt(0), s2Counts.get(s2.charAt(0)) - 1);
        if (s2Counts.get(s2.charAt(0)) == 0) {
            s2Counts.remove(s2.charAt(0));
        }
        int l = 1;
        for (int r = s1.length(); r < s2.length(); r++) {
            s2Counts.put(s2.charAt(r), s2Counts.getOrDefault(s2.charAt(r), 0) + 1);
            if (s2Counts.equals(s1Counts)) {
                return true;
            }
            s2Counts.put(s2.charAt(l), s2Counts.getOrDefault(s2.charAt(l), 1) - 1);
            if (s2Counts.get(s2.charAt(l)) == 0) {
                s2Counts.remove(s2.charAt(l));
            }
            l++;
        }
        return false;
    }

    // Solved myself with hints! Not optimal, but I used the sliding window technique!
    public boolean checkInclusion2(String s1, String s2) {
        Map<Character, Integer> s1Counts = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Counts.put(c, s1Counts.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        for (int r = s1.length(); r <= s2.length(); r++) {
            String substr = s2.substring(l, r);
            Map<Character, Integer> subCounts = new HashMap<>();
            for (char c : substr.toCharArray()) {
                subCounts.put(c, subCounts.getOrDefault(c, 0) + 1);
            }
            if (subCounts.equals(s1Counts)) {
                return true;
            }
            l++;
        }
        return false;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide 2 Strings");
            return;
        }
        String s1 = args[0];
        String s2 = args[1];
        Solution solution = new Solution();
        System.out.println(solution.checkInclusionWithMap(s1, s2));
    }

    public boolean checkInclusion10(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Counts = new HashMap<>();
        Map<Character, Integer> s2Counts = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Counts.put(s1.charAt(i), s1Counts.getOrDefault(s1.charAt(i), 0) + 1);
            s2Counts.put(s2.charAt(i), s2Counts.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int matching = 0;
        for (Character key : s2Counts.keySet()) {
            if (s1Counts.containsKey(key) && s1Counts.get(key).equals(s2Counts.get(key))) {
                matching++;
            }
        }
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matching == s1Counts.keySet().size()) {
                return true;
            }
            char c = s2.charAt(r);
            s2Counts.put(c, s2Counts.getOrDefault(c, 0) + 1);
            if (s1Counts.containsKey(c) && s1Counts.get(c).equals(s2Counts.get(c))) {
                matching++;
            } else if (s1Counts.containsKey(c) && (s2Counts.get(c)).equals(s1Counts.get(c)+1)) {
                matching--;
            }
            char leftChar = s2.charAt(l);
            s2Counts.put(leftChar, s2Counts.get(leftChar) - 1);
            if (s1Counts.containsKey(leftChar) && s1Counts.get(leftChar).equals(s2Counts.get(leftChar))) {
                matching++;
            } else if (s1Counts.containsKey(leftChar) && (s2Counts.get(leftChar).equals(s1Counts.get(leftChar)-1))) {
                matching--;
            }
            l++;
        }
        return matching == s1Counts.keySet().size();
    }
}