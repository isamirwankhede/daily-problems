# 28. Find the Index of the First Occurrence in a String

## problem 

### Ek string (needle) ko dusri string (haystack) ke andar search karna hai.

👉 Agar needle mil jaye → uska starting index return karo
👉 Agar nahi mile → -1 return karo

### 🧠 Simple Logic (Easy Samajh)

haystack = main string (jisme search karna hai)
needle = jo string dhundni hai

### 🔹 Steps
Loop chalao haystack par
Har index pe check karo:
Kya current character == needle ka first character?
Agar match mila:
substring() se poora word compare karo
Agar poora match ho gaya:
👉 index return kar do
Agar kahin bhi match nahi mila:
👉 -1 return karo

🔹 Code
```java
public static int strStr(String haystack, String needle) {
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        if (haystack.charAt(i) == needle.charAt(0)) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
    }
    return -1;
}
```
🔹 Example
haystack = "hello"
needle = "ll"

Output → 2

🔹 Key Points

Pehle character match check karte hai (optimization)
Fir full string compare karte hai
Time Complexity → O(n * m)


1. charAt(index)
Kisi string ka specific character return karta hai.

Example:

haystack.charAt(i)
2. substring(start, end)
String ka ek part nikalta hai.
start inclusive hota hai, end exclusive.

Example:

haystack.substring(i, i + needle.length())
3. equals()
Do strings ko compare karta hai (content same hai ya nahi).

Example:

.equals(needle)
4. length()
String ki length return karta hai.

Example:

haystack.length()