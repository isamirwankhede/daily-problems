<h2><a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid">957. Minimum Add to Make Parentheses Valid</a></h2><h3>Medium</h3><hr><p>A parentheses string is valid if and only if:</p>

<ul>
	<li>It is the empty string,</li>
	<li>It can be written as <code>AB</code> (<code>A</code> concatenated with <code>B</code>), where <code>A</code> and <code>B</code> are valid strings, or</li>
	<li>It can be written as <code>(A)</code>, where <code>A</code> is a valid string.</li>
</ul>

<p>You are given a parentheses string <code>s</code>. In one move, you can insert a parenthesis at any position of the string.</p>

<ul>
	<li>For example, if <code>s = &quot;()))&quot;</code>, you can insert an opening parenthesis to be <code>&quot;(<strong>(</strong>)))&quot;</code> or a closing parenthesis to be <code>&quot;())<strong>)</strong>)&quot;</code>.</li>
</ul>

<p>Return <em>the minimum number of moves required to make </em><code>s</code><em> valid</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;())&quot;
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(((&quot;
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s[i]</code> is either <code>&#39;(&#39;</code> or <code>&#39;)&#39;</code>.</li>
</ul>
# 921. Minimum Add to Make Parentheses Valid

**LeetCode Problem:** 921
**Difficulty:** Medium
**Topics:** String, Stack

---

## 📝 Problem Statement

Hume ek parentheses string `s` di gayi hai jisme sirf:

* `'('`
* `')'`

hote hain.

Hume minimum number of parentheses **insert** karne hain taaki string valid parentheses string ban jaye.

### Example

Input: `"())"`

Output: `1`

Ek `(` insert karke:

`"())" → "()()"`

Valid ban sakti hai.

---

## 💡 Approach

Hum yaha **Stack** ka use karenge.

Basic idea:

* Agar `'('` mile → stack mein push karo.
* Agar `')'` mile:

  * Agar stack empty nahi hai → ek matching `'('` mil gaya, isliye pop karo.
  * Agar stack empty hai → is `')'` ka koi matching `'('` nahi hai, isliye hume ek `'('` insert karna padega.

End mein agar stack mein kuch `'('` bache hue hain, to unke liye corresponding `')'` insert karne padenge.

Isliye:

`Answer = remaining '(' + unmatched ')'`

---

## 🔍 Step-by-Step

Maan lo:

`s = "())"`

### Character 1: `'('`

Stack empty hai, to push karenge.

`Stack = (`

### Character 2: `')'`

Stack empty nahi hai, to matching `'('` mil gaya.

`Pop '('`

Ab stack empty ho gaya.

### Character 3: `')'`

Ab stack empty hai.

Is `')'` ko match karne ke liye ek `'('` insert karna padega.

`closing = 1`

End mein:

`Stack size = 0`

`closing = 1`

Therefore:

`Answer = 0 + 1 = 1`

---

## 💻 Java Code

```
class Solution {

    public int minAddToMakeValid(String s) {

        Stack<Character> st = new Stack<>();
        int closing = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(ch);
            } else {

                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    closing++;
                }
            }
        }

        return st.size() + closing;
    }
}
```

---

## 🧠 Why `st.size() + closing`?

Do cases ho sakte hain:

### 1. Unmatched `')'`

Example:

`"))("`

Starting ke dono `)` ke liye opening `(` chahiye.

`closing = 2`

So 2 insertions required.

---

### 2. Unmatched `'('`

Example:

`"((("`

Stack mein 3 opening brackets bach jayenge.

`stack.size() = 3`

Har `'('` ke liye ek `')'` chahiye.

So:

`3 + 0 = 3`

---

## 🔥 Example

`s = "()))(("`

Processing:

* `(` → push
* `)` → pop
* `)` → unmatched → `closing++`
* `)` → unmatched → `closing++`
* `(` → push
* `(` → push

At the end:

`closing = 2`

`stack.size() = 2`

Therefore:

`Answer = 2 + 2 = 4`

---

## ⏱️ Complexity

### Time Complexity

`O(n)`

Hum string ko ek hi baar traverse kar rahe hain.

### Space Complexity

`O(n)`

Worst case mein saare characters `'('` ho sakte hain aur stack mein `n` characters store honge.

---

## 🎯 Simple Intuition

Bas ye yaad rakho:

`'(' → Stack mein daalo`

`')' → Agar '(' available hai to pair bana do, warna ek '(' insert karna padega`

End mein:

`Unmatched ')' → Opening brackets insert karo`

`Unmatched '(' → Closing brackets insert karo`

Hence:

`Minimum Additions = Unmatched ')' + Unmatched '('`

And code mein:

`return st.size() + closing;`




