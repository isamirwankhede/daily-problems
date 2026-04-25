public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (!Character.isLetter(chars[i])) {
                i++;
            } else if (!Character.isLetter(chars[j])) {
                j--;
            }

            else {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }

        return new String(chars);

    }

    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.println(reverseOnlyLetters(s));
    }
}