# 1903. Largest Odd Number in String 🚀

### LEETCODE
https://leetcode.com/problems/largest-odd-number-in-string/

### GFG
https://www.geeksforgeeks.org/problems/largest-odd-number-in-string/1

## Problem Statement

Ek string `num` di gayi hai jo ek bada integer represent karti hai.

Hume largest-valued **odd integer** return karna hai jo:
- non-empty ho
- `num` ka substring ho

Agar koi odd number exist nahi karta toh empty string `""` return karo.

---

# Java Solution ✅

```java
class Solution {
    public String largestOddNumber(String num) {
        int n = num.length() - 1;

        while (n >= 0) {
            int d = num.charAt(n) - '0';

            if (d % 2 != 0)
                return num.substring(0, n + 1);

            n--;
        }

        return "";
    }
}
```

---

# Approach 🧠

## Important Observation

Koi bhi number **odd** tab hota hai jab uska **last digit odd** ho.

Odd digits:
```text
1, 3, 5, 7, 9
```

Isliye:
- Hume string ko right se traverse karna hai
- First odd digit milte hi
- Us index tak ka substring return kar dena hai

---

# Dry Run 🔍

## Example 1

### Input
```text
num = "52"
```

### Traversal

| Digit | Odd? |
|------|------|
| 2 | ❌ |
| 5 | ✅ |

### Output
```text
"5"
```

---

## Example 2

### Input
```text
num = "4206"
```

### Traversal

| Digit | Odd? |
|------|------|
| 6 | ❌ |
| 0 | ❌ |
| 2 | ❌ |
| 4 | ❌ |

No odd digit found.

### Output
```text
""
```

---

## Example 3

### Input
```text
num = "35427"
```

Last digit = `7`

`7` odd hai ✅

### Output
```text
"35427"
```

---

# Line by Line Explanation 🔥

## 1️⃣ Last Index

```java
int n = num.length() - 1;
```

String ka last index store kiya.

---

## 2️⃣ Reverse Traversal

```java
while (n >= 0)
```

Right se left traverse karenge.

---

## 3️⃣ Character → Integer

```java
int d = num.charAt(n) - '0';
```

Example:
```java
'7' - '0' = 7
```

Character ko integer me convert kiya.

---

## 4️⃣ Odd Check

```java
if (d % 2 != 0)
```

Agar digit odd hai toh:

```java
return num.substring(0, n + 1);
```

Return complete prefix.

---

# substring(0, n + 1) Kyu? 🤔

Java me:
```java
substring(start, end)
```

`end` exclusive hota hai.

Example:
```java
substring(0, 3)
```

Ye return karega:
```text
index 0,1,2
```

Isliye `n + 1` use kiya.

---

# Time Complexity ⏱️

```text
O(N)
```

Kyuki maximum ek baar string traverse ho rahi hai.

---

# Space Complexity 📦

```text
O(1)
```

Extra space use nahi ho raha.

---

# Key Concept ⭐

Largest odd substring =  
Rightmost odd digit tak ka pura prefix.

Kyuki bada prefix → bada number.

---

# Final Summary 🎯

✅ Right se first odd digit find karo  
✅ Us index tak substring return karo  
✅ Agar odd digit nahi mile → `""`

---

# Tags 🏷️

- Strings
- Greedy
- Easy
- Java

---