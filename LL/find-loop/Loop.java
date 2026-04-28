
class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;

    }

    Node(int data1) {
        this.data = data1;
        this.next = null;

    }
}

public class Loop {

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;

        }
    }

    private static Node convertarr2ll(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;

        }

        return head;

    }

    private static boolean isLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;

        }

        return false;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Node head = convertarr2ll(arr);

        // Create loop: last node -> 3rd node
        Node temp = head;
        Node thirdNode = null;
        int count = 1;

        while (temp.next != null) {
            if (count == 3)
                thirdNode = temp;
            temp = temp.next;
            count++;
        }

        temp.next = thirdNode; // loop created

        System.out.println(isLoop(head)); // now TRUE
    }
}