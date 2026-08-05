<h2><a href="https://leetcode.com/problems/evaluate-reverse-polish-notation">150. Evaluate Reverse Polish Notation</a></h2><h3>Medium</h3><hr><p>You are given an array of strings <code>tokens</code> that represents an arithmetic expression in a <a href="http://en.wikipedia.org/wiki/Reverse_Polish_notation" target="_blank">Reverse Polish Notation</a>.</p>

<p>Evaluate the expression. Return <em>an integer that represents the value of the expression</em>.</p>

<p><strong>Note</strong> that:</p>

<ul>
	<li>The valid operators are <code>&#39;+&#39;</code>, <code>&#39;-&#39;</code>, <code>&#39;*&#39;</code>, and <code>&#39;/&#39;</code>.</li>
	<li>Each operand may be an integer or another expression.</li>
	<li>The division between two integers always <strong>truncates toward zero</strong>.</li>
	<li>There will not be any division by zero.</li>
	<li>The input represents a valid arithmetic expression in a reverse polish notation.</li>
	<li>The answer and all the intermediate calculations can be represented in a <strong>32-bit</strong> integer.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> tokens = [&quot;2&quot;,&quot;1&quot;,&quot;+&quot;,&quot;3&quot;,&quot;*&quot;]
<strong>Output:</strong> 9
<strong>Explanation:</strong> ((2 + 1) * 3) = 9
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> tokens = [&quot;4&quot;,&quot;13&quot;,&quot;5&quot;,&quot;/&quot;,&quot;+&quot;]
<strong>Output:</strong> 6
<strong>Explanation:</strong> (4 + (13 / 5)) = 6
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> tokens = [&quot;10&quot;,&quot;6&quot;,&quot;9&quot;,&quot;3&quot;,&quot;+&quot;,&quot;-11&quot;,&quot;*&quot;,&quot;/&quot;,&quot;*&quot;,&quot;17&quot;,&quot;+&quot;,&quot;5&quot;,&quot;+&quot;]
<strong>Output:</strong> 22
<strong>Explanation:</strong> ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= tokens.length &lt;= 10<sup>4</sup></code></li>
	<li><code>tokens[i]</code> is either an operator: <code>&quot;+&quot;</code>, <code>&quot;-&quot;</code>, <code>&quot;*&quot;</code>, or <code>&quot;/&quot;</code>, or an integer in the range <code>[-200, 200]</code>.</li>
</ul>



# Evaluate Reverse Polish Notation (RPN)

## Intuition

Reverse Polish Notation (RPN) me operators (`+`, `-`, `*`, `/`) apne operands ke **baad** aate hain.

**Example:**

```text
Input:
["2","1","+","3","*"]

Normal Expression:
(2 + 1) * 3 = 9
```

Is problem ko efficiently solve karne ke liye **Stack** use karte hain. Stack hume latest operands ko store aur retrieve karne me help karta hai.

---

## Approach

1. Create an empty `Stack<Integer>`.
2. Traverse each token in the input array.
3. If the token is a number, convert it into an integer and push it into the stack.
4. If the token is an operator (`+`, `-`, `*`, `/`):
   - Pop two elements from the stack.
   - First pop is the **second operand (`b`)**.
   - Second pop is the **first operand (`a`)**.
   - Perform the operation `a op b`.
   - Push the result back into the stack.
5. After processing all tokens, the only element left in the stack is the final answer.

---

## Dry Run

### Input

```text
["2","1","+","3","*"]
```

### Step 1

Token = `2`

```text
Stack = [2]
```

### Step 2

Token = `1`

```text
Stack = [2, 1]
```

### Step 3

Token = `+`

```java
b = 1;
a = 2;
```

```text
2 + 1 = 3

Stack = [3]
```

### Step 4

Token = `3`

```text
Stack = [3, 3]
```

### Step 5

Token = `*`

```java
b = 3;
a = 3;
```

```text
3 * 3 = 9

Stack = [9]
```

Final Answer:

```text
9
```

---

## Why do we write?

```java
int b = st.pop();
int a = st.pop();
```

Stack follows the **LIFO (Last In First Out)** principle.

Example:

```text
Stack

2
1 <- Top
```

First pop:

```java
b = 1;
```

Second pop:

```java
a = 2;
```

Now the operation should be:

```java
a - b
```

i.e.

```text
2 - 1 = 1
```

Not

```text
1 - 2 = -1
```

Similarly,

```text
4 2 /
```

Correct:

```text
4 / 2 = 2
```

Wrong:

```text
2 / 4 = 0
```

Therefore, for every operator we always perform:

```java
result = a op b;
```

where:

- `b = st.pop();` → Second operand
- `a = st.pop();` → First operand

---

## Complexity Analysis

**Time Complexity:** `O(n)`

Each token is processed exactly once.

**Space Complexity:** `O(n)`

In the worst case, all numbers are stored in the stack.

---

## Code

```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {

                int b = st.pop();
                int a = st.pop();

                if (t.equals("+"))
                    st.push(a + b);
                else if (t.equals("-"))
                    st.push(a - b);
                else if (t.equals("*"))
                    st.push(a * b);
                else
                    st.push(a / b);

            } else {
                st.push(Integer.parseInt(t));
            }
        }

        return st.peek();
    }
}
```

---

## Key Takeaways

- Use a **Stack** because RPN naturally follows the **LIFO** principle.
- Push every number into the stack.
- When an operator is encountered, pop two elements.
- **First pop = Second operand (`b`)**
- **Second pop = First operand (`a`)**
- Always perform **`a op b`**.
- Push the result back into the stack.
- The last remaining element in the stack is the final answer.
