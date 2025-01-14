import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Map, List<String>> anagramGroups = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> cCounts = new HashMap<>();
            for (char c : str.toCharArray()) {
                cCounts.put(c, cCounts.getOrDefault(c, 0) + 1);
            }
            anagramGroups.putIfAbsent(cCounts, new ArrayList<>());
            anagramGroups.get(cCounts).add(str);
        }
        // for (List<String> anagramGroup : anagramGroups.values()) {
        //     result.add(anagramGroup);
        // }
        return new ArrayList<>(anagramGroups.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] matched = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (matched[i]) {
                continue;
            }
            List<String> anagrams = new ArrayList<>();
            anagrams.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    matched[j] = true;
                    anagrams.add(strs[j]);
                }
            }
            result.add(anagrams);
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (char c : s.toCharArray()) {
            countS.put(c, countS.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        if (countS.equals(countT)) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an array of strings");
            return;
        }
        String[] strs = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            strs[i] = args[i];
        }
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(strs);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Anagram: " + i);
            List<String> anagram = result.get(i);
            for (int j = 0; j < anagram.size(); j++) {
                System.out.println(anagram.get(j));
            }
        }
    }
}