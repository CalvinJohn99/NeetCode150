import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode buildLinkedList(String input, int index) {
        if (input.equals("")) {
            return null;
        }
        String[] nums = input.split(",");
        ListNode head = new ListNode(Integer.parseInt(nums[0]));
        ListNode curr = head;
        ListNode cycleStart = null;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(Integer.parseInt(nums[i]));
            curr = curr.next;
            if (i == index) {
                cycleStart = curr;
            }
        }
        curr.next = cycleStart;
        return head;
    }

    public static void printLinkedList(ListNode node) {
        if (node == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[" + node.val);
        int counter = 0;
        while (node.next != null && counter < 10) {
            counter++;
            node = node.next;
            System.out.print("," + node.val);
        }
        System.out.print("]\n");
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().replaceAll("[\\[\\]]", "");
        int index = Integer.parseInt(scanner.nextLine().trim());
        scanner.close();

        ListNode head = buildLinkedList(input, index);
        System.out.println("List: ");
        printLinkedList(head);
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));
    }
}