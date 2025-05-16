import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list2 = slow.next;
        slow.next = null;
        
        ListNode prev = null;
        while (list2 != null) {
            ListNode temp = list2.next;
            list2.next = prev;
            prev = list2;
            list2 = temp;
        }
        list2 = prev;

        ListNode list1 = head;
        while (list2 != null) {
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;
            list1.next = list2;
            list2.next = temp1;
            list1 = temp1;
            list2 = temp2;
        }
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

        ListNode head = buildLinkedList(input);
        printLinkedList(head);

        Solution solution = new Solution();
        solution.reorderList(head);
        printLinkedList(head);
    }
}