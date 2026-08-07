<h2><a href="https://leetcode.com/problems/backspace-string-compare">874. Backspace String Compare</a></h2><h3>Easy</h3><hr><p>Given two strings <code>s</code> and <code>t</code>, return <code>true</code> <em>if they are equal when both are typed into empty text editors</em>. <code>&#39;#&#39;</code> means a backspace character.</p>

<p>Note that after backspacing an empty text, the text will continue empty.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ab#c&quot;, t = &quot;ad#c&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> Both s and t become &quot;ac&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ab##&quot;, t = &quot;c#d#&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> Both s and t become &quot;&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a#c&quot;, t = &quot;b&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> s becomes &quot;c&quot; while t becomes &quot;b&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code><span>1 &lt;= s.length, t.length &lt;= 200</span></code></li>
	<li><span><code>s</code> and <code>t</code> only contain lowercase letters and <code>&#39;#&#39;</code> characters.</span></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Can you solve it in <code>O(n)</code> time and <code>O(1)</code> space?</p>


# Backspace String Compare (Stack Approach)

## 💡 Approach (Using Stack)

In this approach, we process both strings separately using a **Stack**.

A stack helps us simulate the backspace (`#`) operation easily.

## Idea

- If the current character is not `#`, push it onto the stack.
- If the current character is `#`:
  - If the stack is not empty, pop the top character.
  - Otherwise, do nothing.
- After processing the entire string, the stack contains the final string after applying all backspaces.

Finally, compare the processed strings of both inputs.

## Algorithm

1. Create an empty stack.
2. Traverse each character of the string.
3. If the character is not `#`, push it onto the stack.
4. If the character is `#` and the stack is not empty, pop the top element.
5. Build the final string from the stack.
6. Repeat the same process for the second string.
7. Compare both processed strings.
8. If they are equal, return `true`; otherwise, return `false`.

## Example

```text
Input:
s = "ab#c"
t = "ad#c"

Processing s:
a -> [a]
b -> [a, b]
# -> [a]
c -> [a, c]

Final String = "ac"

Processing t:
a -> [a]
d -> [a, d]
# -> [a]
c -> [a, c]

Final String = "ac"

Output: true
```

## Time Complexity

- **O(n + m)**

Each character is processed only once.

## Space Complexity

- **O(n + m)**

In the worst case, all characters may be stored in the stacks.

## Why This Approach?

- Simple and easy to understand.
- Naturally simulates the backspace operation.
- Great for beginners.
- Uses extra space, whereas the Two Pointer approach solves the problem in **O(1)** space.

# Backspace String Compare (Two Pointer Approach)

## 💡 Approach (Two Pointers)

Instead of building new strings or using a stack, we traverse both strings **from right to left** using two pointers.

The idea is to skip the characters that would be deleted by the backspace (`#`) and compare only the valid characters.

## Idea

- Start two pointers from the end of both strings.
- Maintain two counters (`skipS` and `skipT`) to keep track of how many characters need to be skipped.
- If a `#` is encountered, increase the skip counter.
- If a normal character is found and the skip counter is greater than 0, skip that character and decrease the counter.
- Once both pointers point to valid characters, compare them.
- If all valid characters match, return `true`.

## Algorithm

1. Initialize two pointers at the end of both strings.
2. Traverse backward while either pointer is valid.
3. Skip invalid characters in both strings using skip counters.
4. Compare the current valid characters.
5. If the characters are different, return `false`.
6. If only one string has characters remaining, return `false`.
7. Move both pointers to the previous character.
8. If the traversal completes without any mismatch, return `true`.

## Example

```text
Input:
s = "ab#c"
t = "ad#c"

Processing from the end:

s:
c ← valid
# ← skip previous character
b ← skipped
a ← valid

Final: "ac"

t:
c ← valid
# ← skip previous character
d ← skipped
a ← valid

Final: "ac"

Output: true
```

## Time Complexity

- **O(n + m)**

Each character is visited at most once.

## Space Complexity

- **O(1)**

Only a few variables and pointers are used. No extra data structure is required.

## Why This Approach?

- Optimal solution with **constant extra space**.
- More memory-efficient than the stack approach.
- Suitable for interviews as it avoids creating additional strings.
```
