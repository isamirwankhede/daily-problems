# Make The String Great

## Problem

Hume ek string `s` di gayi hai jisme lowercase aur uppercase English letters hain.

Hume adjacent characters ko remove karna hai agar:

- Dono same alphabet hain.
- Lekin unka case different hai.

Ye process tab tak continue karna hai jab tak string "good" na ho jaye.

### Example

```text
Input:  "leEeetcode"
Output: "leetcode"
```

Yaha `E` aur `e` same letter hain but different cases mein hain, isliye dono remove ho jayenge.

---

## Approach

Is problem ko solve karne ke liye hum **StringBuilder ko Stack ki tarah** use kar rahe hain.

Normally hum `Stack<Character>` bhi use kar sakte the, lekin us approach mein end mein stack ke saare characters ko traverse karke ek `StringBuilder` ya `String` mein convert karna padega taaki final answer return kar sake.

Isliye hum directly `StringBuilder` ko hi Stack ki tarah use kar rahe hain.

Isse implementation simple bhi hai aur hume alag se Stack maintain karne ki zarurat nahi padti.

---

## StringBuilder as Stack

Hum `StringBuilder` ke operations ko Stack ki tarah use kar rahe hain:

```text
append()        → PUSH
charAt(len - 1) → PEEK
deleteCharAt()  → POP
```

Har character ke liye hum check karenge ki kya current character aur `StringBuilder` ka last character same letter hain but different cases mein hain.

Agar condition true hai:

- Last character ko remove karenge.
- Current character ko append nahi karenge.

Agar condition false hai:

- Current character ko `StringBuilder` mein append karenge.

---

## Code

```java
class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();

            if (len > 0 && Character.toLowerCase(sb.charAt(len - 1)) == Character.toLowerCase(ch)
                    && sb.charAt(len - 1) != ch) {
                sb.deleteCharAt(len - 1);
            }

            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
```

---

## How The Condition Works

Main condition:

```java
Character.toLowerCase(sb.charAt(len - 1)) == Character.toLowerCase(ch)
&& sb.charAt(len - 1) != ch
```

Isme hum do cheeze check kar rahe hain.

### 1. Same Character Hai Ya Nahi?

```java
Character.toLowerCase(sb.charAt(len - 1))
    == Character.toLowerCase(ch)
```

Example:

```text
'E' → 'e'
'e' → 'e'
```

So dono same letter hain.

### 2. Case Different Hai Ya Nahi?

```java
sb.charAt(len - 1) != ch
```

Example:

```text
'E' != 'e'
```

So dono ka case different hai.

Dono conditions true hone par pair ko remove kar dete hain.

---

## Dry Run

Example:

```text
s = "leEeetcode"
```

### Step 1

```text
l → "l"
```

### Step 2

```text
e → "le"
```

### Step 3

```text
E → "leE"
```

### Step 4

Current character = `e`

Last character = `E`

```text
'E' and 'e'
```

Same letter + different case.

So `E` ko delete kar dete hain:

```text
"leE" → "le"
```

Current `e` bhi append nahi hota.

### Remaining Characters

```text
e → "lee"
t → "leet"
c → "leetc"
o → "leetco"
d → "leetcod"
e → "leetcode"
```

Final answer:

```text
"leetcode"
```

---

## Why Not Brute Force?

Brute force approach mein hum repeatedly string ko traverse kar sakte hain aur adjacent invalid pairs ko remove kar sakte hain.

Example:

```text
leEeetcode
  ↑↑
  Ee remove

leetcode
```

Problem ye hai ki har removal ke baad hume dobara string ko traverse karna pad sakta hai.

Repeated traversal aur deletion ki wajah se worst case mein:

**Time Complexity = O(n²)**

ho sakti hai.

Isliye brute force optimal nahi hai.

---

## Why Not Use Stack?

Hum `Stack<Character>` bhi use kar sakte hain.

```java
Stack<Character> stack = new Stack<>();
```

Stack approach ki time complexity:

**O(n)**

hogi.

Lekin final answer return karne ke liye hume stack ke andar stored characters ko traverse karke ek `StringBuilder` ya `String` mein convert karna padega.

Yaani hume separately:

```text
Stack
+
StringBuilder/String
```

maintain karna padega.

Is problem mein `StringBuilder` already Stack ki tarah kaam kar sakta hai.

Isliye hum directly `StringBuilder` use kar rahe hain.

Ye implementation ko simple rakhta hai aur separate Stack maintain karne ki zarurat nahi padti.

---

## Important Mistake

Yaha ek important mistake ho sakti hai.

### Wrong

```java
int len = s.length();
```

### Correct

```java
int len = sb.length();
```

Reason:

`s` original string hai aur uski length change nahi hoti.

Lekin `sb` mein characters continuously add aur delete ho rahe hain.

Isliye hume `sb` ki **current length** chahiye.

Agar hum `s.length()` use karenge, to:

```java
sb.charAt(len - 1)
```

kisi invalid index ko access kar sakta hai.

Isse:

```text
StringIndexOutOfBoundsException
```

aa sakta hai.

---

# Complexity Analysis

## Time Complexity

**O(n)**

Hum input string ko ek baar traverse kar rahe hain.

Har character ke liye constant amount ka work perform ho raha hai:

- `charAt()`
- `toLowerCase()`
- `append()`
- `deleteCharAt()`

Isliye overall:

```text
Time Complexity = O(n)
```

---

## Space Complexity

**O(n)**

Worst case mein koi bhi character remove nahi hoga.

Example:

```text
abcdef
```

Is case mein `StringBuilder` ke andar `n` characters store honge.

Therefore:

```text
Space Complexity = O(n)
```

---

# Final Comparison

| Approach | Time Complexity | Space Complexity | Reason |
|---|---:|---:|---|
| Brute Force | O(n²) | O(n) | Repeated traversal and deletion |
| Stack | O(n) | O(n) | Stack + final conversion |
| StringBuilder as Stack | **O(n)** | **O(n)** | Direct and clean approach |

---

# Key Takeaway

`StringBuilder` ko Stack ki tarah use kar sakte hain:

```text
append()        → PUSH
charAt(len - 1) → PEEK
deleteCharAt()  → POP
```

Aur final answer directly:

```java
return sb.toString();
```

se mil jata hai.

## Optimal Approach

```text
StringBuilder as Stack

Time Complexity  → O(n)
Space Complexity → O(n)
```
