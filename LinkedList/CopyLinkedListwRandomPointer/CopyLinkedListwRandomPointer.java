import java.util.*;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copies = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copies.put(curr, copy);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node copy = copies.get(curr);
            copy.next = copies.get(curr.next);
            copy.random = copies.get(curr.random);
            curr = curr.next;
        }
        return copies.get(head);
    }

    public static Node buildLinkedList(String input) {
        input = input.replace("head = ", "");
        input = input.substring(1, input.length() - 1);
        if (input.equals("")) {
            return null;
        }
        String[] nodes = input.split("\\],\\[");
        Map<Integer, Node> nodeIdxMap = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            String[] getNodeVal = nodes[i].replaceAll("[\\[\\]]", "").split(",");
            Node node = new Node(Integer.parseInt(getNodeVal[0]));
            nodeIdxMap.put(i, node);
        }
        for (int i = 0; i < nodes.length; i++) {
            if (i < nodes.length - 1) {
                nodeIdxMap.get(i).next = nodeIdxMap.get(i + 1);
            }
            String[] getRandomIdx = nodes[i].replaceAll("[\\[\\]]", "").split(",");
            if (!getRandomIdx[1].equals("null")) {
                int randomIdx = Integer.parseInt(getRandomIdx[1]);
                nodeIdxMap.get(i).random = nodeIdxMap.get(randomIdx);
            }
        }
        return nodeIdxMap.get(0);
    }

    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        Node node = head;
        Map<Node, Integer> nodeIdxMap = new HashMap<>();
        int index = 0;
        while (node != null) {
            nodeIdxMap.put(node, index++);
            node = node.next;
        }
        node = head;
        System.out.print("[");
        while (node != null) {
            Integer randIdx = node.random != null ? nodeIdxMap.get(node.random) : null;
            System.out.print("[" + node.val + "," + randIdx + "]");
            node = node.next;
            if (node != null) {
                System.out.print(",");
            }
        }
        System.out.print("]\n");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        scanner.close();

        Node head = buildLinkedList(input);
        printLinkedList(head);

        Solution solution = new Solution();
        Node copy = solution.copyRandomList(head);
        printLinkedList(copy); 
    }
}