import org.w3c.dom.NodeList;

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


public class Pallindrome {

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

    private static Node reverseList(Node head) {
        Node temp = head;
        Node prev = null;

        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;

        }


        return prev;
    }

    private static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        Node newHead = reverseList(slow.next);

        Node first = head;
        Node second = newHead;

        while (second != null) {
            if(first.data != second.data) {
                reverseList(newHead);
                return false;

            }
            first = first.next;
            second = second.next;

        }

        reverseList(newHead);
        return true;



    } 

    public static void main(String[] args) {
        int arr[] = { 1 ,2 , 3 , 3 ,2 ,1 };
        Node head = convertarr2ll(arr);
        // head = reverseList(head);
        // print(head);
        System.out.println(isPalindrome(head));
    }
}