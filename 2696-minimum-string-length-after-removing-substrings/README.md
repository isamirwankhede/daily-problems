<h2><a href="https://leetcode.com/problems/minimum-string-length-after-removing-substrings">2800. Minimum String Length After Removing Substrings</a></h2><h3>Easy</h3><hr><p>You are given a string <code>s</code> consisting only of <strong>uppercase</strong> English letters.</p>

<p>You can apply some operations to this string where, in one operation, you can remove <strong>any</strong> occurrence of one of the substrings <code>&quot;AB&quot;</code> or <code>&quot;CD&quot;</code> from <code>s</code>.</p>

<p>Return <em>the <strong>minimum</strong> possible length of the resulting string that you can obtain</em>.</p>

<p><strong>Note</strong> that the string concatenates after removing the substring and could produce new <code>&quot;AB&quot;</code> or <code>&quot;CD&quot;</code> substrings.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ABFCACDB&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> We can do the following operations:
- Remove the substring &quot;<u>AB</u>FCACDB&quot;, so s = &quot;FCACDB&quot;.
- Remove the substring &quot;FCA<u>CD</u>B&quot;, so s = &quot;FCAB&quot;.
- Remove the substring &quot;FC<u>AB</u>&quot;, so s = &quot;FC&quot;.
So the resulting length of the string is 2.
It can be shown that it is the minimum length that we can obtain.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ACBBD&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> We cannot do any operations on the string so the length remains the same.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code>&nbsp;consists only of uppercase English letters.</li>
</ul>

# 2696. Minimum String Length After Removing Substrings

**LeetCode Problem:** 2696  
**Difficulty:** Easy  
**Topics:** String, Stack

---

## 📝 Problem Statement

You are given a string `s` consisting only of uppercase English letters.

In one operation, you can remove any occurrence of either `"AB"` or `"CD"` from the string.

After removing a substring, the remaining characters concatenate together.

This can create new `"AB"` or `"CD"` substrings.

Return the **minimum possible length** of the resulting string.

---

## 💡 Examples

### Example 1

**Input:** `s = "ABFCACDB"`

**Output:** `2`

**Explanation:**

We can remove the substrings step by step:

```text
ABFCACDB
↓ Remove AB
FCACDB
↓ Remove CD
FCAB
↓ Remove AB
FC

Final length = 2

Example 2

Input: s = "ACBBD"

Output: 5

There is no "AB" or "CD" substring, so no operation can be performed.

Final string remains "ACBBD".

🚀 Approach

We use a StringBuilder as a Stack.

We traverse the string from left to right.

For every character, we check the last character stored in the StringBuilder.

There are only two removable pairs:

"AB"
"CD"

If the current character forms one of these pairs with the last character, we remove the last character.

Otherwise, we add the current character to the StringBuilder.

This approach automatically handles newly created "AB" or "CD" pairs after removing characters.

🔍 Algorithm
Create an empty StringBuilder.
Traverse every character of the string.
Check the last character of the StringBuilder.
If the last character is A and the current character is B, remove the last character.
Else if the last character is C and the current character is D, remove the last character.
Otherwise, append the current character.
Return the length of the StringBuilder.
🧠 Why StringBuilder?

We use StringBuilder like a stack.

append()        → Push
charAt(len - 1) → Peek
deleteCharAt()  → Pop

This allows us to efficiently check and remove the last character.

🔄 Dry Run

For s = "ABFCACDB":

A → A
B → AB found → Remove → ""

F → F
C → FC
A → FCA
C → FCAC
D → CD found → Remove → FCA
B → AB found → Remove → FC

Final string:

FC

Final length:

2
💻 Java Solution
class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();

            if (len > 0 && ch == 'B' && sb.charAt(len - 1) == 'A') {
                sb.deleteCharAt(len - 1);
            } 
            else if (len > 0 && ch == 'D' && sb.charAt(len - 1) == 'C') {
                sb.deleteCharAt(len - 1);
            } 
            else {
                sb.append(ch);
            }
        }

        return sb.length();
    }
}
📌 Important Conditions
Removing "AB"
ch == 'B' && sb.charAt(len - 1) == 'A'

If the stack top is A and the current character is B, then "AB" is formed and both characters are removed.

Removing "CD"
ch == 'D' && sb.charAt(len - 1) == 'C'

If the stack top is C and the current character is D, then "CD" is formed and both characters are removed.

🔄 Chain Reaction

Removing one pair can create another removable pair.

For example:

CABD

Processing:

C → C
A → CA
B → AB found → C
D → CD found → ""

Final result:

""

This is automatically handled by the stack approach.

⏱️ Complexity Analysis
Time Complexity

O(n)

We traverse the string once.

Space Complexity

O(n)

The StringBuilder can contain up to n characters.

🎯 Key Concept

Stack + Adjacent Substring Removal

The general pattern is:

If current character forms a removable pair
with the stack top:
    Remove the top
Else:
    Add current character

For this problem:

AB → Remove
CD → Remove
🔑 Takeaway

Whenever a problem asks you to repeatedly remove specific adjacent substrings, think about using a Stack.

Here, StringBuilder works as the stack:

append()        → Push
charAt(len - 1) → Peek
deleteCharAt()  → Pop

Overall:

String
   ↓
Traverse characters
   ↓
StringBuilder as Stack
   ↓
Check AB / CD
   ↓
Pair found?
   ↓
Yes → Remove
No  → Add
   ↓
Return Stack Length
🏆 Complexity
Time: O(n)
Space: O(n)
🔗 Pattern

Stack / Adjacent Substring Cancellation
