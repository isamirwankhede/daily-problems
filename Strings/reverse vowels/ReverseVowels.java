class ReverseVowels {

    static boolean isVowels(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;

        } else {
            return false;
        }

    }

    static String reverseVowels(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            if (!isVowels(chars[i]))
                i++;
            else if (!isVowels(chars[j]))
                j--;
            else {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }

        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }

}