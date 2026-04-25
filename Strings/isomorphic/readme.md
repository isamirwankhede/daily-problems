# 🔥 Isomorphic Strings (Java)

## 📌 Problem Statement

Given two strings `s` and `t`, determine if they are **isomorphic**.

👉 Two strings are isomorphic if:

* Each character in `s` maps to exactly one character in `t`
* No two characters in `s` map to the same character in `t`

---

## 🧠 Example

### ✅ Example 1:

```
s = "egg"
t = "add"
```

Mapping:

```
e → a
g → d
```

✔ Output: `true`

---

### ❌ Example 2:

```
s = "foo"
t = "bar"
```

Mapping:

```
f → b
o → a
o → r ❌ (conflict)
```

❌ Output: `false`

---

# 🚀 Approach 1: HashMap

## 💡 Idea

* Map characters from `s` → `t`
* Check consistency of mapping
* Ensure no duplicate values

## ✅ Code

```java
import java.util.HashMap;

public class Isomorphic {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (map.containsValue(ch2)) {
                    return false;
                }
                map.put(ch1, ch2);
            }
        }

        return true;
    }
}
```

## ⏱ Complexity

* Time: `O(n)`
* Space: `O(n)`

---

# ⚡ Approach 2: Array (Optimized)

## 💡 Idea

* Use two arrays to track last seen positions
* Compare patterns instead of mapping explicitly

## 🧠 Key Trick

```
mapS[s[i]] == mapT[t[i]]
```

If not equal → ❌ not isomorphic

---

## ✅ Code

```java
public class IsomorphicArray {
    public static boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
```

---

## 🔢 Why Array Size = 256?

* ASCII characters range from `0–255`
* Each character directly maps to an index

👉 Example:

```
'a' → 97
mapS[97]
```

---

## ⏱ Complexity

* Time: `O(n)`
* Space: `O(1)` (fixed size array)

---

# 🆚 HashMap vs Array

| Feature  | HashMap            | Array                 |
| -------- | ------------------ | --------------------- |
| Ease     | Easy to understand | Slightly tricky logic |
| Speed    | Slower             | Faster                |
| Space    | O(n)               | O(1)                  |
| Use Case | General            | ASCII-based problems  |

---

# 🎯 Final Summary

✔ One-to-one mapping required
✔ Same pattern check important
✔ Array approach is fastest

---

## 🚀 Tip for Interviews

* Start with HashMap (easy explanation)
* Then optimize using array

---

💡 **Pro Tip:** Always think in terms of *pattern matching*, not just mapping!
