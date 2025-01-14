class Solution {
    public boolean isPalindrome (String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (!isAlphaNumeric(s.charAt(l)) && l < r) {
                l++;
            }
            while (!isAlphaNumeric(s.charAt(r)) && r > l) {
                r--;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isAlphaNumeric (char character) {
        if (character >= 'A' && character <= 'Z' || character >= 'a' && character <= 'z' || character >= '0' && character <= '9') {
            return true;
        }
        return false;
    }

    public boolean isPalindrome3 (String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder reverseS = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char character = s.charAt(i);
            // don't need following check since we replaced all non-alphanumeric characters with ""
            if (character >= 'A' && character <= 'Z' || character >= 'a' && character <= 'z' || character >= '0' && character <= '9') {
                reverseS.append(character);
            }
        }
        return (s).equals(reverseS.toString());
    }

    public boolean isPalindrome2 (String s) {
        StringBuilder alphaNumericS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                alphaNumericS.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return (alphaNumericS.toString().equals(alphaNumericS.reverse().toString()));
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide a string to check whether it's a palindrome");
            return;
        }
        String s = args[0];
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome10(s));
    }

    public boolean isPalindrome10 (String s) {
        
    }

    public boolean isAlphaNumeric10(char c) {

    }

}