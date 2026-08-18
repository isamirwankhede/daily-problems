<h2><a href="https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses">Minimum Remove to Make Valid Parentheses</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a string <font face="monospace">s</font> of <code>&#39;(&#39;</code> , <code>&#39;)&#39;</code> and lowercase English characters.</p>

<p>Your task is to remove the minimum number of parentheses ( <code>&#39;(&#39;</code> or <code>&#39;)&#39;</code>, in any positions ) so that the resulting <em>parentheses string</em> is valid and return <strong>any</strong> valid string.</p>

<p>Formally, a <em>parentheses string</em> is valid if and only if:</p>

<ul>
	<li>It is the empty string, contains only lowercase characters, or</li>
	<li>It can be written as <code>AB</code> (<code>A</code> concatenated with <code>B</code>), where <code>A</code> and <code>B</code> are valid strings, or</li>
	<li>It can be written as <code>(A)</code>, where <code>A</code> is a valid string.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;lee(t(c)o)de)&quot;
<strong>Output:</strong> &quot;lee(t(c)o)de&quot;
<strong>Explanation:</strong> &quot;lee(t(co)de)&quot; , &quot;lee(t(c)ode)&quot; would also be accepted.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a)b(c)d&quot;
<strong>Output:</strong> &quot;ab(c)d&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;))((&quot;
<strong>Output:</strong> &quot;&quot;
<strong>Explanation:</strong> An empty string is also valid.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either&nbsp;<code>&#39;(&#39;</code> , <code>&#39;)&#39;</code>, or lowercase English letter.</li>
</ul>



# Minimum Remove to Make Valid Parentheses

## 📌 Problem

Humein ek string `s` di gayi hai jisme:

- English letters ho sakte hain
- `(` opening parenthesis ho sakta hai
- `)` closing parenthesis ho sakta hai

Humein **minimum number of parentheses remove** karne hain taaki final string **valid parentheses string** ban jaaye.

### Example

```text
Input:
lee(t(c)o)de)

Output:
lee(t(c)o)de
```

Last `)` ka koi matching `(` nahi hai, isliye usse remove karna padega.

---

# 💡 Approach

Hum is problem ko **2 passes** mein solve karenge.

```text
Pass 1 → Invalid ')' remove karo
Pass 2 → Extra '(' remove karo
```

Is approach mein humein Stack ki zarurat nahi hai.

---

# 🔹 Pass 1: Invalid `)` Remove Karna

Sabse pehle hum `open` naam ka counter rakhenge.

```java
int open = 0;
```

Ye batayega ki currently kitne unmatched `(` available hain.

### Jab `(` mile:

```java
if (ch == '(') {
    open++;
    first.append(ch);
}
```

Matlab ek opening bracket aa gaya, to `open` increase hoga.

Example:

```text
Input:
( ( )

open:
1 → 2 → 1
```

---

### Jab `)` mile:

Yahan important condition hai:

```java
else if (ch == ')') {
    if (open > 0) {
        open--;
        first.append(ch);
    }
}
```

Agar:

```text
open > 0
```

iska matlab koi previous `(` available hai jo is `)` ko match kar sakta hai.

To hum `)` ko keep karenge.

```text
( )
↑ ↑
| |
opening closing
```

Lekin agar:

```text
open == 0
```

to iska matlab current `)` ka koi matching `(` nahi hai.

Example:

```text
)
```

Ye invalid hai.

Isliye hum ise simply **ignore/remove** kar denge.

---

# ❌ Original Code Mein Problem

Tumhare original code mein ye tha:

```java
else if (ch == ')') {
    open--;
    first.append(ch);
}
```

Problem ye hai ki tum bina check kiye:

```java
open--;
```

kar rahe ho.

Suppose:

```text
s = ")"
```

Initially:

```text
open = 0
```

`)' mila:

```text
open--
```

so:

```text
open = -1
```

Ye logically wrong hai.

Kyuki koi opening bracket tha hi nahi.

Correct logic:

```java
if (open > 0) {
    open--;
    first.append(ch);
}
```

---

# 🔹 Pass 2: Extra `(` Remove Karna

First pass ke baad invalid `)` remove ho chuke hain.

Lekin abhi bhi kuch unmatched `(` bach sakte hain.

Example:

```text
Input:
((abc)
```

First pass ke baad:

```text
((abc)
```

Yahan:

```text
( → unmatched
( → matched
) → matched
```

Ek extra `(` hai.

Humein ise remove karna hai.

---

## Right to Left Traverse

Hum string ko right se left traverse karenge:

```java
for (int i = first.length() - 1; i >= 0; i--)
```

Aur jab:

```java
ch == '('
```

aur:

```java
open > 0
```

ho, to us `(` ko remove kar denge.

```java
if (ch == '(' && open > 0) {
    open--;
}
```

Right se remove karne ka reason ye hai ki humein **sirf unmatched opening brackets** remove karne hain.

---

# 🔄 Complete Example

Consider:

```text
s = "a)b(c)d"
```

## Pass 1

Characters ko left to right check karenge:

```text
a → normal character
) → invalid, remove
b → normal character
( → open = 1
c → normal character
) → valid, open = 0
d → normal character
```

So:

```text
first = "ab(c)d"
```

Ab koi unmatched `(` nahi hai.

Final:

```text
ab(c)d
```

---

# 🔄 Another Example

```text
s = "((abc)"
```

### Pass 1

```text
( → open = 1
( → open = 2
a
b
c
) → open = 1
```

So:

```text
first = "((abc)"
```

But:

```text
open = 1
```

means ek unmatched `(` abhi bhi hai.

---

### Pass 2

Right se traverse:

```text
)
c
b
a
(
(
```

Pehla `(` mila:

```text
open > 0
```

So remove it.

Now:

```text
open = 0
```

Dusra `(` keep karenge.

Final:

```text
(abc)
```

---

# 💻 Final Code

```java
class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder first = new StringBuilder();
        int open = 0;

        // Pass 1: Remove invalid ')'
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
                first.append(ch);
            }

            else if (ch == ')') {

                if (open > 0) {
                    open--;
                    first.append(ch);
                }
            }

            else {
                first.append(ch);
            }
        }

        // Pass 2: Remove unmatched '('
        StringBuilder ans = new StringBuilder();

        for (int i = first.length() - 1; i >= 0; i--) {

            char ch = first.charAt(i);

            if (ch == '(' && open > 0) {
                open--;
            }

            else {
                ans.append(ch);
            }
        }

        return ans.reverse().toString();
    }
}
```

---

# 🧠 Easy Way to Remember

Is problem ko bas ye line yaad rakh ke solve karo:

```text
First pass:
Extra ')' hatao

Second pass:
Extra '(' hatao
```

### Pass 1

```text
( → count++
) → agar count > 0 hai tabhi keep karo
```

### Pass 2

```text
Right se jao
Extra '(' remove karo
```

---

# ⏱️ Complexity

Let `n = s.length()`.

### Time Complexity

```text
O(n)
```

Hum string ko maximum 2 baar traverse kar rahe hain.

```text
O(n) + O(n)
= O(n)
```

### Space Complexity

```text
O(n)
```

Kyuki hum `StringBuilder` use kar rahe hain.

---

# 🎯 Key Learning

Is problem ka main concept **Balanced Parentheses** hai.

Opening bracket:

```text
(
```

Closing bracket:

```text
)
```

Jab bhi `)` aaye, check karo:

```text
Kya mere paas koi unmatched '(' hai?
```

Agar:

```text
YES → ')' valid hai
NO  → ')' invalid hai
```

First pass ke baad sirf ek problem bachti hai:

```text
Extra '('
```

Isliye second pass mein unhe remove kar dete hain.

---

## ⭐ One-Line Interview Explanation

> "I solve this using two passes: first I remove invalid closing parentheses by maintaining an opening-parenthesis count, then I traverse from right to left to remove any remaining unmatched opening parentheses. This gives O(n) time complexity and O(n) space complexity."
