import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null) {
            node.next = list2;
        }
        return dummy.next;
    }

    public static ListNode buildLinkedList(String line) {
        if (line.equals("")) {
            return null;
        }
        String[] nums = line.split(",");
        ListNode head = new ListNode(Integer.parseInt(nums[0]));
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(Integer.parseInt(nums[i]));
            curr = curr.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode node) {
        if (node == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[" + node.val);
        while(node.next != null) {
            node = node.next;
            System.out.print("," + node.val);
        }
        System.out.print("]\n");
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine().trim().replaceAll("[\\[\\]]", "");
        String line2 = scanner.nextLine().trim().replaceAll("[\\[\\]]", "");
        scanner.close();

        ListNode list1 = buildLinkedList(line1);
        System.out.println("list1: ");
        printLinkedList(list1);
        ListNode list2 = buildLinkedList(line2);
        System.out.println("list2: ");
        printLinkedList(list2);

        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        System.out.println("Merged List: ");
        printLinkedList(mergedList);
    }
}