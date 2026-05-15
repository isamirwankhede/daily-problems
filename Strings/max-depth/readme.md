# 1614. Maximum Nesting Depth of the Parentheses

### LEETCODE : 
https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

### GFG :
https://www.geeksforgeeks.org/problems/maximum-nesting-depth-of-the-parentheses/1

### CODESTUDIO : 
https://www.naukri.com/code360/problems/maximum-nesting-depth-of-the-parentheses_8144741


## Problem
Given a valid parentheses string `s`, return the maximum nesting depth of parentheses.

### Example

Input:
```text
(1+(2*3)+((8)/4))+1
```

Output:
```text
3
```

---

# Approach (Hinglish)

Humko maximum nesting depth find karna hai.

- `(` → andar ja rahe hai → depth increase
- `)` → bahar aa rahe hai → depth decrease
- Maximum depth ko `res` me store karte hai

---

# Logic

## Step 1: Variables

```java
int curr = 0;
int res = 0;
```

- `curr` = current depth
- `res` = maximum depth

---

## Step 2: Traverse String

```java
for(char ch : s.toCharArray())
```

String ka har character check karenge.

---

## Step 3: Opening Bracket

```java
if(ch == '('){
    curr++;
    res = Math.max(res, curr);
}
```

### Explanation
- Opening bracket matlab ek level andar gaye
- Isliye `curr++`
- Fir maximum depth update karte hai

---

## Step 4: Closing Bracket

```java
if(ch == ')'){
    curr--;
}
```

### Explanation
- Closing bracket matlab ek level bahar aaye
- Isliye depth decrease kar di

---

# Dry Run

Input:

```text
((()))
```

| Character | Current Depth | Max Depth |
|---|---|---|
| `(` | 1 | 1 |
| `(` | 2 | 2 |
| `(` | 3 | 3 |
| `)` | 2 | 3 |
| `)` | 1 | 3 |
| `)` | 0 | 3 |

Final Answer = `3`

---

# Code

```java
class Solution {
    public int maxDepth(String s) {

        int curr = 0;
        int res = 0;

        for(char ch : s.toCharArray()){

            if(ch == '('){
                curr++;
                res = Math.max(res, curr);
            }

            if(ch == ')'){
                curr--;
            }
        }

        return res;
    }
}
```

---

# Complexity Analysis

## Time Complexity
```text
O(n)
```

## Space Complexity
```text
O(1)
```