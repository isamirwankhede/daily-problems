

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



public class Convert2Arr{
    

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

    public static void main(String[] args) {
        int arr[] = {12 , 5 , 7 ,8 };
        Node head = convertarr2ll(arr);
        System.out.println(head.data);
    }
}

