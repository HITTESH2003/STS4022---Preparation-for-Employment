class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Loop_Detection {
    static Node head = null;

    static void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    static void createLoop(int position) {
        if (head == null) return;

        Node loopNode = null;
        Node current = head;
        int count = 1;

        while (current.next != null) {
            if (count == position) {
                loopNode = current;
            }
            current = current.next;
            count++;
        }

        if (loopNode != null) {
            current.next = loopNode;
        }
    }
    static boolean detectLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    static void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        add(10);
        add(20);
        add(30);
        add(40);
        add(50);

        System.out.println("Linked List before creating a loop:");
        printList();

        createLoop(2);

        if (detectLoop()) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
