import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }

    public static ListNode buildLinkedList(String input) {
        input = input.replace("head = ", "").replaceAll("[\\[\\]]", "");
        if (input.equals("")) {
            return null;
        }
        String[] nums = input.split(",");
        ListNode head = new ListNode(Integer.parseInt(nums[0]));
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(Integer.parseInt(nums[i]));
            node = node.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        ListNode node = head;
        System.out.print("[" + node.val);
        while (node.next != null) {
            node = node.next;
            System.out.print("," + node.val);
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        scanner.close();

        String[] inputs = input.split(", ");
        inputs[1] = inputs[1].replace("n = ", "");
        int n = Integer.parseInt(inputs[1]);

        ListNode head = buildLinkedList(inputs[0]);
        printLinkedList(head);

        Solution solution = new Solution();
        ListNode removedList = solution.removeNthFromNode(head, n);
        printLinkedList(removedList);
    }
}