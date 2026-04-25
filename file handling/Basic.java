public class Basic {
    public static void main(String[] args) {
        int i = 0;
        int j = 10;

        
        // i = 13/ i;  
        // here stop the execution sp we use try catch to handle
        int arr[] = new int[5];

        try {
           i = 12 / 2; 

           System.out.println(arr[5]);
        } catch (ArithmeticException e) {
            System.out.println("something went wrong :- " + e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("element cant accessible : " + e);
        }

    }
    
}