class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i =0;

        //loop to the second last element coz we are doing check i++;

        while(i < sb.length() -1){
            char a =sb.charAt(i); 
            char b =sb.charAt(i+1); 
            if(
                (a == '(' && b == ')' ) ||   //check if i char ==  i++ char and they belng to the same family
                (a == '{' && b == '}') ||  
                (a == '[' && b == ']' )
            ){
                sb.delete( i , i+2); // delete the i an d i+ character why (i+2) coz this is excluded
                if( i >0) i--; 
                // if i ==0 " (()" in this condition we delete and there is left we need to move back
            }
            else{
                //if not match jut do i++;

                i++;
            }
             
        }

        return sb.length()==0;


    }
}