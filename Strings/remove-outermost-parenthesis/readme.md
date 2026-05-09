# 1021. Remove Outermost Parentheses

## Problem Statement
### gfg =  
https://www.geeksforgeeks.org/problems/outermost-parentheses/1

### LEETCODE ;
https://leetcode.com/problems/remove-outermost-parentheses/description/



---

Ek valid parentheses string diya gaya hai.  
Hume har primitive valid string ke outermost parentheses remove karne hai.

---

## Example

### Input
```txt
s = "(()())(())"
```

### Primitive Breakdown
```txt
"(()())" + "(())"
```

### Outer Parentheses Remove Karne Ke Baad
```txt
"()()" + "()"
```

### Output
```txt
"()()()"
```

---

# Java Solution

```java
class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == ')')
                cnt--;

            if (cnt != 0)
                sb.append(s.charAt(i));

            if (s.charAt(i) == '(')
                cnt++;
        }

        return sb.toString();
    }
}
```

---

# Approach (Hinglish Explanation)

Hum ek `cnt` variable use karenge jo track karega ki kitne brackets currently open hai.

- `(` aaye → count increase
- `)` aaye → count decrease

## Main Logic

### 1. Outermost Opening Bracket Skip Karna
Jab `cnt = 0` ho aur `(` mile,  
toh wo outermost opening bracket hota hai.

Isliye usko answer me add nahi karte.

---

### 2. Outermost Closing Bracket Skip Karna
Jab `)` ke baad `cnt = 0` ho jaye,  
matlab primitive string close ho gayi.

Toh wo outermost closing bracket hai.

Usko bhi skip karte hai.

---

# Dry Run

## Input
```txt
"(()())(())"
```

| Character | Count | Add in Answer? |
|-----------|-------|----------------|
| ( | 0→1 | No |
| ( | 1→2 | Yes |
| ) | 2→1 | Yes |
| ( | 1→2 | Yes |
| ) | 2→1 | Yes |
| ) | 1→0 | No |

First primitive:
```txt
()()
```

Second primitive:
```txt
()
```

Final Answer:
```txt
()()()
```

---

# Time Complexity

```txt
O(n)
```

Sirf ek baar string traverse kar rahe hai.

---

# Space Complexity

```txt
O(n)
```

Answer store karne ke liye.

---

# Key Point

✅ Jab `cnt == 0` before `(`  
→ skip opening bracket

✅ Jab `cnt == 0` after `)`  
→ skip closing bracket

Baaki sab answer me add karo.

---

# Tags

- String
- Stack
- Parentheses
- LeetCode Easy