class Node{
    int data;
    Node next;

    Node(int data1 , Node next1){
        this.data = data1;
        this.next = next1;

    }

    Node ( int data1){
        this.data =  data1;
        this.next = null;

    }
}



public class LinkedList{
    // public static void main(String[] args) {
    //     int arr[] = {2 , 5 , 7 , 8};
    //     Node y = new Node(arr[3]);
    //     System.out.println(y.data);
    // }

    
    // convert the array into linkedlist return the head
    private static Node convertarr2ll(int arr[]){
        Node head = new Node (arr[0]);
        Node mover = head;


        for(int i =1 ; i< arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover =  temp;

        }

        return head;

    }

    // convert the array to linkedlist and print the head;


    // public static void main(String[] args) {
    //     int arr[] = {12 , 5 , 7 ,8 };
    //     Node head = convertarr2ll(arr);
    //     System.out.println(head.data);
    // }



    // iterate and print the entire data of the array ;

    // public static void main(String[] args) {
    //     int arr[] = {12 , 5 , 7 ,8 };
    //     Node head = convertarr2ll(arr);
    //     Node temp = head;

    //     while(temp != null){
    //         System.out.print(temp.data + " ");
    //         temp = temp.next;
    //     }
        
    // }



    // length the LL

    private static int lengthOfLL(Node head){
        int cnt = 0;
        Node temp = head;

        while(temp != null){
            // System.out.print(temp.data + " ");
            temp = temp.next;
            cnt++;
            
        }
        
        return cnt;
    }

    

    public static void main(String[] args) {
        int arr[] = {12 , 5 , 7 ,8 };
        Node head = convertarr2ll(arr);
        // Node temp = head;

        System.out.println(lengthOfLL(head));

        // element present or not

        System.out.println(checkIsPresent(head , 10));

        
    }

    // check the given element present tin the ll or not 
    private static boolean checkIsPresent(Node head , int val){
        Node temp = head;
        while (temp != null) {
            if(temp.data == val) return true;
            temp = temp.next;

        }

        return false;
    }
    
    public static void main(String[] args) {
        int arr[] = {12 , 5 , 7 ,8 };
        Node head = convertarr2ll(arr);


        // element present or not

        System.out.println(checkIsPresent(head , 10));

        
    }

}

