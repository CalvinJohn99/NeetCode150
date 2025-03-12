import java.util.ArrayList;
import java.util.List;
// import java.util.StringBuilder;

class Solution {
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str.length()).append('#').append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            result.add(str.substring(i, j));
            i = j;
        }
        return result;
    }

    public String encode2(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            StringBuilder encodedString = new StringBuilder();
            for (char c : str.toCharArray()) {
                encodedString.append((char) (c - 5));
            }
            result.append(str.length()).append("#").append(encodedString.toString());
        }
        return result.toString();
    }

    public List<String> decode2(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            String encodedString = str.substring(i, j);
            StringBuilder decodedString = new StringBuilder();
            for (char c : encodedString.toCharArray()) {
                decodedString.append((char) (c + 5));
            }
            result.add(decodedString.toString());
            i = j;
        }
        return result;
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an array of String's");
            return;
        }
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            strs.add(args[i]);
        }
        Solution solution = new Solution();
        String encodedString = solution.encode10(strs);
        List<String> decodedStringList = new ArrayList<>(solution.decode10(encodedString));
        System.out.println("strs: ");
        System.out.println(strs.toString());
        System.out.println("encoded string: " + encodedString);
        System.out.println("decoded string: " + decodedStringList.toString());
    }

    public String encode10 (List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append('#').append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode10 (String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }

}