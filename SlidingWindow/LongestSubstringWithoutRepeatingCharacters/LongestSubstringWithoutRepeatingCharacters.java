import java.util.Set;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> checkDuplicates = new HashSet<>();
        int longest = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            while (checkDuplicates.contains(s.charAt(r))) {
                checkDuplicates.remove(s.charAt(l));
                l++;
            }
            checkDuplicates.add(s.charAt(r));
            longest = Math.max(longest, checkDuplicates.size());
            r++;
        }
        return longest;
    }

    public int lengthOfLongestSubstring2(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                Set<Character> checkDuplicates = new HashSet<>();
                String substr = s.substring(i, j);
                boolean hasDuplicate = false;
                for (char c : substr.toCharArray()) {
                    if (checkDuplicates.contains(c)) {
                        hasDuplicate = true;
                        break;
                    }
                    checkDuplicates.add(c);
                }
                if (hasDuplicate) {
                    continue;
                }
                longest = Math.max(longest, substr.length());
            }
        }
        return longest;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide a string");
            return;
        } 
        String s = args[0];
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring10(s));
    }

    public int lengthOfLongestSubstring10(String s) {
        int longest = 0;
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            longest = Math.max(charSet.size(), longest);
        }
        return longest;
    }
}