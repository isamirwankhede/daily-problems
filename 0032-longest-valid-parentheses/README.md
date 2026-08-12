<h2><a href="https://leetcode.com/problems/longest-valid-parentheses">32. Longest Valid Parentheses</a></h2><h3>Hard</h3><hr><p>Given a string containing just the characters <code>&#39;(&#39;</code> and <code>&#39;)&#39;</code>, return <em>the length of the longest valid (well-formed) parentheses </em><span data-keyword="substring-nonempty"><em>substring</em></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(()&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> The longest valid parentheses substring is &quot;()&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;)()())&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest valid parentheses substring is &quot;()()&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;&quot;
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s[i]</code> is <code>&#39;(&#39;</code>, or <code>&#39;)&#39;</code>.</li>
</ul>


# 32. Longest Valid Parentheses

**LeetCode Problem:** [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)  
**Difficulty:** Hard  
**Topics:** String, Stack, Two Pointers

---

## 📝 Problem Statement

Given a string `s` containing only `'('` and `')'`, return the **length of the longest valid (well-formed) parentheses substring**.

### Example 1

```text
Input: s = "(()"
Output: 2

Explanation:
Longest valid substring = "()"
```

### Example 2

```text
Input: s = ")()())"
Output: 4

Explanation:
Longest valid substring = "()()"
```

### Example 3

```text
Input: s = ""
Output: 0
```

---

# Approach 1: Using Stack

## 💡 Intuition

Stack approach mein hum **indices store** karenge.

Sabse important trick:

```java
st.push(-1);
```

`-1` ek **base index** hai.

Ye help karta hai valid substring ki length calculate karne mein.

### Example

```text
s = "()()"
index:  0 1 2 3
        ( ) ( )
```

Jab `)` milta hai:

1. Stack se ek index pop karo.
2. Agar stack empty ho gaya → current `)` ek invalid boundary hai.
3. Otherwise:

```text
length = currentIndex - stack.peek()
```

---

## 🔍 Why `-1`?

Suppose:

```text
s = "()"
```

Initially:

```text
stack = [-1]
```

Index `0`:

```text
'(' → push 0

stack = [-1, 0]
```

Index `1`:

```text
')' → pop 0

stack = [-1]
```

Now:

```text
length = 1 - (-1)
       = 2
```

So answer `2`.

Without `-1`, length calculate karna difficult hota.

---

# 🧠 Stack Algorithm

For every character:

### If character is `'('`

Index ko stack mein push karo.

```java
st.push(i);
```

### If character is `')'`

Pehle ek opening bracket remove karo:

```java
st.pop();
```

Then two cases:

### Case 1: Stack empty

Matlab current `)` ka koi matching `(` nahi mila.

So current index ko new boundary bana do:

```java
st.push(i);
```

### Case 2: Stack not empty

Matlab current `)` successfully match hua.

Valid substring ki length:

```java
i - st.peek()
```

Then maximum update karo:

```java
max = Math.max(max, i - st.peek());
```

---

# 🔎 Stack Dry Run

Let's take:

```text
s = ")()())"
```

Index:

```text
0 1 2 3 4 5
) ( ) ( ) )
```

Initially:

```text
stack = [-1]
max = 0
```

### i = 0 → `)`

Pop:

```text
stack = []
```

Empty → push current index:

```text
stack = [0]
```

---

### i = 1 → `(`

Push:

```text
stack = [0, 1]
```

---

### i = 2 → `)`

Pop:

```text
stack = [0]
```

Length:

```text
2 - 0 = 2
```

```text
max = 2
```

---

### i = 3 → `(`

Push:

```text
stack = [0, 3]
```

---

### i = 4 → `)`

Pop:

```text
stack = [0]
```

Length:

```text
4 - 0 = 4
```

```text
max = 4
```

---

### i = 5 → `)`

Pop:

```text
stack = []
```

Empty → push `5`

```text
stack = [5]
```

Final answer:

```text
4
```

---

# 💻 Java Code — Stack Approach

```java
class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> st = new Stack<>();

        st.push(-1);

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                st.push(i);

            } else {

                st.pop();

                if (st.isEmpty()) {

                    st.push(i);

                } else {

                    max = Math.max(max, i - st.peek());
                }
            }
        }

        return max;
    }
}
```

---

# ⏱️ Complexity — Stack Approach

### Time Complexity

```text
O(n)
```

Har character ko maximum ek baar push aur pop karte hain.

### Space Complexity

```text
O(n)
```

Worst case mein stack mein `n` indices ho sakte hain.

---

# Approach 2: Two-Pass / Left-Right Counter

Ab ek **O(1) extra space** approach dekhte hain.

Yaha Stack ki zarurat nahi hai.

Hum sirf do counters maintain karenge:

```java
left
right
```

Where:

```text
left  = number of '('
right = number of ')'
```

---

# 🧠 Main Idea

Valid parentheses ke liye:

```text
number of '(' == number of ')'
```

Example:

```text
()()
```

Counts:

```text
left  = 2
right = 2
```

So length:

```text
2 * right = 4
```

---

# 🔥 First Pass — Left to Right

Hum string ko left se right traverse karenge.

### If `'('`

```java
left++;
```

### If `')'`

```java
right++;
```

Then:

### If

```text
left == right
```

Current substring valid ho sakta hai.

Length:

```java
2 * right
```

So:

```java
max = Math.max(max, 2 * right);
```

---

# ❗ Important Case

Suppose:

```text
s = ")()"
```

Start:

```text
left = 0
right = 0
```

First character:

```text
')'
```

So:

```text
left = 0
right = 1
```

Now:

```text
right > left
```

Matlab closing bracket zyada ho gaya.

Aage is substring ko valid nahi bana sakte.

So reset:

```java
left = right = 0;
```

---

# ⚠️ Why Second Pass?

First pass har situation handle nahi kar sakta.

Example:

```text
s = "(()"
```

Left to right:

```text
( → left = 1, right = 0
( → left = 2, right = 0
) → left = 2, right = 1
```

Kabhi:

```text
left == right
```

nahi hua.

But `"()"` valid substring hai.

Problem ye hai:

```text
left > right
```

extra opening brackets bache hue hain.

Isliye hume **right to left** bhi scan karna padega.

---

# 🔄 Second Pass — Right to Left

Ab string ko reverse direction mein traverse karenge.

Counters same rahenge:

```java
left
right
```

But reset condition change hogi.

Because ab hum right se left aa rahe hain.

If:

```text
left > right
```

Matlab opening brackets zyada ho gaye.

So reset:

```java
left = right = 0;
```

---

# 💻 Java Code — Two-Pass Approach

```java
class Solution {
    public int longestValidParentheses(String s) {

        int left = 0;
        int right = 0;
        int max = 0;

        // Left to Right
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right) {

                max = Math.max(max, 2 * right);

            } else if (right > left) {

                left = 0;
                right = 0;
            }
        }

        // Right to Left
        left = 0;
        right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right) {

                max = Math.max(max, 2 * right);

            } else if (left > right) {

                left = 0;
                right = 0;
            }
        }

        return max;
    }
}
```

---

# 🔎 Two-Pass Dry Run

Consider:

```text
s = "(()"
```

### Left → Right

```text
( → left=1 right=0
( → left=2 right=0
) → left=2 right=1
```

No equality.

So first pass finds:

```text
0
```

---

### Right → Left

String:

```text
( ( )
```

Start from right:

```text
) → left=0 right=1
```

Here:

```text
right > left
```

But in the reverse traversal, this condition is **not** the reset condition.

Next:

```text
( → left=1 right=1
```

Equal!

Therefore:

```text
length = 2 * right
       = 2
```

Answer:

```text
2
```

---

# ⏱️ Complexity — Two-Pass Approach

### Time Complexity

```text
O(n)
```

We traverse the string twice:

```text
O(n) + O(n) = O(n)
```

### Space Complexity

```text
O(1)
```

Only `left`, `right`, and `max` variables are used.

---

# 🆚 Stack vs Two-Pass

| Approach | Time | Space |
|---|---:|---:|
| Stack | O(n) | O(n) |
| Two-Pass | O(n) | O(1) |

### Which one is easier?

**Stack approach** is generally easier to understand because we directly track indices.

### Which one is space efficient?

**Two-Pass approach**, because it uses only constant extra space.

---

# 🧠 Interview Trick

For **Longest Valid Parentheses**, remember these two ideas:

### Stack

```text
Store indices
↓
Push '(' index
↓
For ')' → pop
↓
If stack empty → current index becomes boundary
↓
Otherwise → i - stack.peek()
```

### Two-Pass

```text
Count '(' and ')'
↓
If equal → valid length
↓
Invalid balance → reset
↓
Scan both directions
```

---

# ⭐ Key Takeaway

The most important thing to understand is:

```text
Valid parentheses
        ↓
'(' count == ')' count
```

But **equal counts alone are not enough**.

Example:

```text
")("
```

Counts are:

```text
'(' = 1
')' = 1
```

But it is **not valid**.

That's why:

- Left → Right scan handles extra `)`
- Right → Left scan handles extra `(`

And together they give the correct answer.

---

## 🚀 Final Recommendation

If you're learning this problem for interviews:

1. **Understand Stack approach first**
2. Master why `-1` is pushed
3. Understand why `i - st.peek()` gives the length
4. Then learn the **Two-Pass O(1) space optimization**

The Stack solution is usually easier to explain in an interview, while the Two-Pass solution is a nice optimization when the interviewer asks:

> **"Can you solve it without extra space?"**
