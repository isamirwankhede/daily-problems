# 🔍 First Unique Character in a String (Java)

## 📌 Problem Statement

Given a string `s`, find the index of the **first non-repeating (unique) character**.
If no such character exists, return `-1`.

---

## 🧠 Approach Used

We use a **Frequency Array (Counting Technique)**:

1. Count how many times each character appears
2. Traverse the string again
3. Return the index of the first character with frequency = 1

---

## 🔧 Functions Explanation

### 🔹 Frequency Counting Logic

We use an array of size 26 to store frequency of lowercase characters.

```java
int[] freq = new int[26];

for (char c : s.toCharArray()) {
    freq[c - 'a']++;
}
```

#### ✅ Explanation:

* `c - 'a'` gives index (0 to 25)
* Example:

  * `'a' - 'a' = 0`
  * `'b' - 'a' = 1`

---

### 🔹 Finding First Unique Character

```java
for (int i = 0; i < s.length(); i++) {
    if (freq[s.charAt(i) - 'a'] == 1) {
        return i;
    }
}
```

#### ✅ Logic:

* Traverse original string (to maintain order)
* Return first index where frequency = 1

---

### 🔹 Complete Code

```java
class UniqueChar {

    public static int firstUniqChar(String s) {

        int[] freq = new int[26];

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Find first unique
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
```

---

## 🧪 Example

### Input:

```
leetcode
```

### Output:

```
0
```

### Explanation:

* `l` appears only once → index = 0

---

## ⏱️ Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1) (fixed array of size 26)

---

## 🚀 Key Concepts Used

* Frequency Array
* String Traversal
* Character Index Mapping

---

## ⚠️ Important Note

This solution works for:

* Lowercase English letters (`a - z`)

If string contains:

* Uppercase / special characters
  👉 Use `HashMap` instead

---

## 📂 How to Run

```bash
javac UniqueChar.java
java UniqueChar
```

---

## 💡 Interview Tip

* Brute Force → O(n²)
* Optimized → O(n) using frequency array 🔥

---

## ⭐ Author

Sameer Wankhede
