import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseListRecursion(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseListRecursion(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }

    public static ListNode buildLinkedList(String input) {
        input = input.replace("head = ", "").replaceAll("[\\[\\]]", "");
        if (input.equals("")) {
            return null;
        }
        String[] nums = input.split(",");
        ListNode head = new ListNode(Integer.parseInt(nums[0]));
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(Integer.parseInt(nums[i]));
            curr = curr.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        ListNode curr = head;
        System.out.print("[" + curr.val);
        while (curr.next != null) {
            curr = curr.next;
            System.out.print("," + curr.val);
        }
        System.out.print("]\n");
    }

    public static void main(String args[]) {
        try {
            Scanner scanner = new Scanner(System.in);    
            String input = scanner.nextLine().trim();
            scanner.close();
            
            ListNode head = buildLinkedList(input); 
            System.out.println("Original List: ");
            printLinkedList(head);

            Solution solution = new Solution();
            ListNode reverseHead = solution.reverseListRecursion10(head);
            System.out.println("Reversed List: ");
            printLinkedList(reverseHead);
        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
    }

    public ListNode reverseList10(ListNode head) {
        ListNode prev = null; 
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseListRecursion10(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode newHead = head;
        if (curr.next != null) {
            newHead = reverseListRecursion10(curr.next);
            curr.next.next = curr;
        }
        head.next = null;
        return newHead;
    }
}