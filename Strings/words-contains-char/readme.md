# 🧩 LeetCode 2942 - Find Words Containing Character

## 📌 Problem Statement

Given a **0-indexed array of strings** `words` and a character `x`, return an array of **indices** of the words that contain the character `x`.

👉 Output kisi bhi order me ho sakta hai.

---

## 🧾 Example

### Example 1:

```
Input: words = ["leet","code"], x = 'e'
Output: [0,1]
```

### Example 2:

```
Input: words = ["abc","bcd","aaaa","cbc"], x = 'a'
Output: [0,2]
```

### Example 3:

```
Input: words = ["abc","bcd","aaaa","cbc"], x = 'z'
Output: []
```

---

## 🧠 Approach (Hinglish Explanation)

Simple logic hai 👇

* Har word ko check karo
* Agar word ke andar `x` present hai → uska index answer me add karo

---

## ⚙️ Approach 1: Using `contains()`

### 💡 Idea:

Java ka built-in method `contains()` use karte hain.

### 💻 Code:

```java
import java.util.*;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                ans.add(i);
            }
        }

        return ans;
    }
}
```

---

## ⚙️ Approach 2: Manual Character Check (Interview Best)

### 💡 Idea:

* Har word ke characters pe loop chalao
* `x` mila → index add karo + break

### 💻 Code:

```java
import java.util.*;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (ch == x) {
                    ans.add(i);
                    break;
                }
            }
        }

        return ans;
    }
}
```

---

## ⏱️ Complexity Analysis

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(n * m)   |
| Space | O(k)       |

👉 `n` = number of words
👉 `m` = length of each word
👉 `k` = number of matched indices

---

## ⚠️ Edge Cases

* `x` kisi bhi word me nahi hai → return `[]`
* Empty array → return `[]`

---

## 🎯 Key Points

* `contains()` easy hai but interview me manual approach pucho jaata hai
* `break` use karna important hai (optimization ke liye)
* `char → String` conversion yaad rakho

---

## 🚀 Summary

* Loop through words
* Check if character exists
* Store index
* Return result

---

⭐ Easy problem but strong base banata hai string handling ke liye!
