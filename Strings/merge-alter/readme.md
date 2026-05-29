# 🚀 Merge Strings Alternately

### Leetcode :
https://leetcode.com/problems/merge-strings-alternately/

## 📌 Problem Statement
You are given two strings `word1` and `word2`.

Merge the strings by adding letters in **alternating order**, starting with `word1`.

If a string is longer than the other, append the remaining characters at the end.

---

## 🧠 Example

### Input

word1 = "abc"
word2 = "pqr"


### Output

apbqcr


### Explanation

word1: a b c
word2: p q r
merged: a p b q c r


---

## 💡 Approach (Hinglish)

- Ek index `i = 0` se start karo  
- Ek `StringBuilder` lo result store karne ke liye  
- Loop tab tak chalega jab tak dono strings complete nahi hoti  

### Logic:
- Agar `word1` me character hai → add karo  
- Agar `word2` me character hai → add karo  
- Har step ke baad `i++`

---

## 🧾 Java Code

```java
public class MergeStrings {
    public static String mergeAlternately(String a, String b) {
        int i = 0;
        StringBuilder ans = new StringBuilder();

        while (i < a.length() || i < b.length()) {

            if (i < a.length()) {
                ans.append(a.charAt(i));
            }

            if (i < b.length()) {
                ans.append(b.charAt(i));
            }

            i++;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

        System.out.println(mergeAlternately(word1, word2));
    }
}
```

⚙️ Dry Run


Input
a = "ab"
b = "pqrs"

Steps

i=0 → a, p → "ap"
i=1 → b, q → "apbq"
i=2 → r → "apbqr"
i=3 → s → "apbqrs"

Output
apbqrs


⏱️ Complexity
Time Complexity: O(n + m)
Space Complexity: O(n + m)


🎯 Key Points

Alternate merge karna hai
Short string khatam ho jaye toh long wali continue
Efficient solution using StringBuilder
