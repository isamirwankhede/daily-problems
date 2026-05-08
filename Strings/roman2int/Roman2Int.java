import java.util.*;


class Roman2Int{
    
    private static int roman2int(String s){
        HashMap<Character,Integer> mpp = new HashMap<>();

        mpp.put('I' , 1);
        mpp.put('V' , 5);
        mpp.put('X' , 10);
        mpp.put('L' , 50);
        mpp.put('C' , 100);
        mpp.put('D' , 500);
        mpp.put('M' , 1000);

        int n = s.length();
        int res = mpp.get(s.charAt(n-1));

        for(int i= n -2 ; i>=0; i--){
            if(mpp.get(s.charAt(i))< mpp.get(s.charAt(i+1))) {
                res = res - mpp.get(s.charAt(i));
            }else{
                res = res + mpp.get(s.charAt(i));
            }
        }

        return res;
    }

    public static void main(String args[]){
        String s = "LVIII";
        System.out.println(roman2int(s));
    }
}