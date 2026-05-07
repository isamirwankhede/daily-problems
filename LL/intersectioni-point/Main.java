class Node {
    int num;
    Node next;
    Node(int val) {
        num = val;
        next = null;
    }
}

class Solution {
    // Utility function to insert node at the end of the linked list
    public void insertNode(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Utility function to check presence of intersection
    public Node intersectionPresent(Node head1, Node head2) {
        Node d1 = head1;
        Node d2 = head2;

        // Traverse both lists, when one reaches the end, redirect it to the head of the other list
        while (d1 != d2) {
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }

        return d1;  // If they meet, return the intersection node, otherwise NULL
    }

    // Utility function to print linked list
    public void printList(Node head) {
        while (head != null && head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        if (head != null) {
            System.out.print(head.num);
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Creation of both lists
        Node head = new Node(1);
        sol.insertNode(head, 3);
        sol.insertNode(head, 1);
        sol.insertNode(head, 2);
        sol.insertNode(head, 4);
        Node head1 = head;
        head = head.next.next.next;  // Intersection point
        Node headSec = new Node(3);
        Node head2 = headSec;
        headSec.next = head;  // Creating intersection

        // Printing the lists
        System.out.print("List1: ");
        sol.printList(head1);
        System.out.print("List2: ");
        sol.printList(head2);

        // Checking if intersection is present
        Node answerNode = sol.intersectionPresent(head1, head2);
        if (answerNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("The intersection point is " + answerNode.num);
        }
    }
}
