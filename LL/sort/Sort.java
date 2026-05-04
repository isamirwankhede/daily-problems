
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


public class Sort {
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
    

     public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge2(Node list1 , Node list2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 != null) temp.next = list1;
        else temp.next = list2;

        return dummyNode.next;
    }

    public static Node insertionSort(Node head) {
        if(head == null || head.next == null) return head;

        Node middle = findMiddle(head);
        Node rightHead = middle.next;
        middle.next = null;
        Node leftHead = head;

        leftHead = insertionSort(leftHead);
        rightHead = insertionSort(rightHead);

        return merge2(leftHead , rightHead);
    }

    public static void main(String[] args) {
        int arr[] = { 3 ,2 , 1 , 5 ,4 };
        Node head = convertarr2ll(arr);
        head = insertionSort(head);
        print(head);
        // System.out.println(insertionSort(head));
    }
}