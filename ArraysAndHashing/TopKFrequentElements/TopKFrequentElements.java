import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        // Buckets for bucket sort
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0 && index < k; i--) {
            for (int num : buckets[i]) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }
        return new int[0];
    }

    public int[] topKFrequent4(int[] nums, int k) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        // We want ascending here, not descending order since we're using a min heap
        // Update the comparator implementation accordingly
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[1];
        }
        return result;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        List<Integer[]> sortedNumCounts = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            sortedNumCounts.add(new Integer[]{entry.getValue(), entry.getKey()});
        }
        sortedNumCounts.sort((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            result[i] = sortedNumCounts.get(i)[1];
        }
        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numCounts.put(nums[i], numCounts.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < k; i++) {
            result[i] = maxKey(numCounts);
        }
        return result;
    }

    public int maxKey(Map<Integer, Integer> inputMap) {
        // Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey()
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : inputMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        int toReturn = maxEntry.getKey();
        inputMap.remove(toReturn);
        return toReturn;
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an array of integers");
            return;
        }
        int k = Integer.parseInt(args[args.length - 1]);
        int[] nums = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        int[] result = solution.topKFrequent10(nums, k);
        for (int num : result) {
            System.out.println(num);
        }
    }

    public int[] topKFrequent10(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        int index = 0;
        for (int i = buckets.length - 1; (i >= 0) && (index < k); i--) {
            for (int value : buckets[i]) {
                res[index++] = value;
                if (index >= k) {
                    break;
                }
            }
        }
        return res;
    }

    public int maxKey10(Map<Integer, Integer> numCounts) {
        return 0;
    }
}