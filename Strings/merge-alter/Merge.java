class Merge{
    public static String mergeStrings(String a , String b){
        int i =0 ;
        StringBuilder ans = new StringBuilder();
        while( i < a.length() || i < b.length()){
            if( i < a.length()){
                ans.append(a.charAt(i));

            }
            if( i < b.length()){
                ans.append(b.charAt(i));
                
            }
            i++;
        }

        return ans.toString();
        
    } 
    public static void main (String args[]){
        String a = "ab";
        String b = "cdef";
        System.out.println(mergeStrings(a, b));
    }
}