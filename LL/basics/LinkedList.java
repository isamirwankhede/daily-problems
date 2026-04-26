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

public class LinkedList {
    // public static void main(String[] args) {
    // int arr[] = {2 , 5 , 7 , 8};
    // Node y = new Node(arr[3]);
    // System.out.println(y.data);
    // }

    // convert the array into linkedlist return the head
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

    // convert the array to linkedlist and print the head;

    // public static void main(String[] args) {
    // int arr[] = {12 , 5 , 7 ,8 };
    // Node head = convertarr2ll(arr);
    // System.out.println(head.data);
    // }

    // iterate and print the entire data of the array ;

    // public static void main(String[] args) {
    // int arr[] = {12 , 5 , 7 ,8 };
    // Node head = convertarr2ll(arr);
    // Node temp = head;

    // while(temp != null){
    // System.out.print(temp.data + " ");
    // temp = temp.next;
    // }

    // }

    // length the LL

    private static int lengthOfLL(Node head) {
        int cnt = 0;
        Node temp = head;

        while (temp != null) {
            // System.out.print(temp.data + " ");
            temp = temp.next;
            cnt++;

        }

        return cnt;
    }

    // public static void main(String[] args) {
    // int arr[] = {12 , 5 , 7 ,8 };
    // Node head = convertarr2ll(arr);
    // // Node temp = head;

    // System.out.println(lengthOfLL(head));

    // // element present or not

    // System.out.println(checkIsPresent(head , 10));

    // }

    // check the given element present tin the ll or not
    private static boolean checkIsPresent(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val)
                return true;
            temp = temp.next;

        }

        return false;
    }

    // public static void main(String[] args) {
    // int arr[] = {12 , 5 , 7 ,8 };
    // Node head = convertarr2ll(arr);

    // // element present or not

    // System.out.println(checkIsPresent(head , 10));

    // }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;

        }
    }

    private static Node removeHead(Node head) {
        if (head == null)
            return head;
        Node temp = head;

        head = head.next;
        return head;

    }

    private static Node removeTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;

        }
        temp.next = null;
        return head;

    }

    private static Node removeK(Node head, int k) {
        if (head == null)
            return head;

        if (k == 1) {
            Node temp = head;
            return head;
        }

        int cnt = 0;
        Node prev = null;
        Node temp = head;

        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;

    }
    private static Node removeEL(Node head, int el) {
        if (head.data == el)
            return head;

        Node prev = null;
        Node temp = head;

        while (temp != null) {
            
            if (temp.data == el) {
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;

    }

    private static Node insertNode( Node head , int val){
        Node temp = new Node(val ,head);

        return temp;
    }
    private static Node insertTail( Node head , int val){
        if(head ==null ) return new Node(val);

        Node temp = head;

        while(temp.next != null){
            temp = temp.next ;

        }

        Node newNode = new Node(val);
        temp.next = newNode;

        return head;
    }

    private static Node inserAtKth(Node head , int el , int k){
        if(head == null){
            if(k == 1) return new Node(el);
            else return head;

        }

        if(k == 1){
            return new Node(el , head);
        }

        int cnt =0;
        Node temp = head;

        while(temp != null){
            cnt++;

            if(cnt == (k - 1)){
                Node x = new Node(el , temp.next);
                temp.next = x ;
                break;
            } 

            temp = temp.next;

        }

        return head;
    }
    private static Node insertBeforeVal(Node head , int el , int val){
        if(head == null){
           return null;

        }

        if(head.data == val){
            return new Node(el , head);
        }

       
        Node temp = head;

        while(temp.next != null){
            if(temp.next.data == val){
                Node x = new Node(el , temp.next);
                temp.next = x ;
                break;
            } 

            temp = temp.next;

        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 5, 7, 8 };
        Node head = convertarr2ll(arr);
        // head = removeHead(head);

        // head = removeTail(head);

        // head = removeEL(head, 5);
        // head = insertNode(head , 100);
        // head = insertTail(head , 100);
        // head = inserAtKth(head , 100, 2);
        head = insertBeforeVal(head , 100, 12);
        print(head);

    }

}
