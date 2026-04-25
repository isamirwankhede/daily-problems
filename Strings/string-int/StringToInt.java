import java.util.stream.Gatherer.Integrator;

class StringToInt{
    public static int stringToInteger(String s){
        long num = 0;
        
        
        s = s.trim();
        int n =s.length();

        if(s.isEmpty()) return 0;

        int sign = 1;
        int i =0 ;
        
        if(s.charAt(i) == '-' || s.charAt(i) =='+'){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i< n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            
            if(sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;

        }

        return (int)(sign * num);


    }
    public static void main(String[] args) {
        String s = "0-1";
        System.out.println(stringToInteger(s));
        
    }
    
}