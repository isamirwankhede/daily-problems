# 🔄 String Rotation Check in Java

## 📌 Problem Statement


### LEETCODE :

https://leetcode.com/u/samirwankhede/


Given two strings `s` and `goal`, check whether `goal` is a rotation of `s` or not.

A string is called a rotation of another string if it can be obtained by moving characters from the beginning to the end.

---

# 🧠 Example

## Input
```java
s = "abcde"
goal = "eabcd"
```

## Output
```java
true
```

## Explanation

Rotate `"abcde"`:

```text
abcde
↓
eabcd
```

So `goal` is a valid rotation of `s`.

---

# 🚀 Java Solution

```java
class Solution {

    public static boolean isRotate(String s , String goal) {

        // Length check
        if(s.length() != goal.length())
            return false;

        // Rotation check
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {

        String s = "abcde";
        String goal = "eabcd";

        System.out.println(isRotate(s , goal));
    }
}
```

---

# 🔍 Hindi Explanation (Easy Revision Notes)

## Step 1 → Length Check

Sabse pehle check karte hain ki dono strings ki length same hai ya nahi.

```java
if(s.length() != goal.length())
    return false;
```

### Kyu?
Agar length alag hai to rotation possible hi nahi hai.

---

# Step 2 → Double the String

```java
s + s
```

Example:

```java
"abcde" + "abcde"
```

Result:

```java
"abcdeabcde"
```

---

# Step 3 → Check Substring

```java
(s + s).contains(goal)
```

Check karte hain ki `goal` string doubled string ke andar present hai ya nahi.

Example:

```java
"abcdeabcde".contains("eabcd")
```

Result:

```java
true
```

---

# 🧪 Dry Run

## Input

```java
s = "abcde"
goal = "eabcd"
```

---

## Process

### Double String

```java
s + s = "abcdeabcde"
```

---

### Check

```java
"abcdeabcde".contains("eabcd")
```

Result:

```java
true
```

---

# 📈 Time Complexity

## contains()

Worst Case:

```text
O(n)
```

So Total Complexity:

```text
O(n)
```

---

# 💾 Space Complexity

```text
O(n)
```

Because we create:

```java
s + s
```

---

# 🎯 Important Interview Trick

## Key Observation

If `goal` is rotation of `s`, then:

```text
goal will always be a substring of (s + s)
```

This is the most important concept of this problem.

---

# ✅ Edge Cases

## Case 1

```java
s = "abc"
goal = "cab"
```

Output:

```text
true
```

---

## Case 2

```java
s = "abc"
goal = "acb"
```

Output:

```text
false
```

---

## Case 3

```java
s = "a"
goal = "a"
```

Output:

```text
true
```

---

# 📝 Revision Notes

✅ Length same honi chahiye  
✅ `(s + s)` important trick hai  
✅ `contains()` se substring check hota hai  
✅ Rotation string doubled string ke andar milti hai  
✅ Easy and optimized solution  

---

# 📚 Similar Problems

- Rotate String
- Circular Rotation Check
- String Matching
- KMP Pattern Matching
- Cyclic String Problems

---

# ⭐ GitHub Repository Notes

## Tags

```text
#java
#strings
#rotation
#easy
#interview-question
```

---

# 👨‍💻 Author

Made for quick revision and interview preparation 🚀