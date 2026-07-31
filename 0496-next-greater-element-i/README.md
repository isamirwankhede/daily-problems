<h2><a href="https://leetcode.com/problems/next-greater-element-i">496. Next Greater Element I</a></h2><h3>Easy</h3><hr><p>The <strong>next greater element</strong> of some element <code>x</code> in an array is the <strong>first greater</strong> element that is <strong>to the right</strong> of <code>x</code> in the same array.</p>

<p>You are given two <strong>distinct 0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, where <code>nums1</code> is a subset of <code>nums2</code>.</p>

<p>For each <code>0 &lt;= i &lt; nums1.length</code>, find the index <code>j</code> such that <code>nums1[i] == nums2[j]</code> and determine the <strong>next greater element</strong> of <code>nums2[j]</code> in <code>nums2</code>. If there is no next greater element, then the answer for this query is <code>-1</code>.</p>

<p>Return <em>an array </em><code>ans</code><em> of length </em><code>nums1.length</code><em> such that </em><code>ans[i]</code><em> is the <strong>next greater element</strong> as described above.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [4,1,2], nums2 = [1,3,4,2]
<strong>Output:</strong> [-1,3,-1]
<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,<u>4</u>,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [<u>1</u>,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,<u>2</u>]. There is no next greater element, so the answer is -1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [2,4], nums2 = [1,2,3,4]
<strong>Output:</strong> [3,-1]
<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,<u>2</u>,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,<u>4</u>]. There is no next greater element, so the answer is -1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length &lt;= nums2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li>
	<li>All integers in <code>nums1</code> and <code>nums2</code> are <strong>unique</strong>.</li>
	<li>All the integers of <code>nums1</code> also appear in <code>nums2</code>.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you find an <code>O(nums1.length + nums2.length)</code> solution?

# 496. Next Greater Element I

## Problem Statement

Given two arrays:

- **nums1** is a subset of **nums2**.
- All elements are **unique**.

For every element in `nums1`, find its **Next Greater Element** in `nums2`.

The **Next Greater Element (NGE)** is the first greater element present on the **right side** of that element in `nums2`.

If no greater element exists, return **-1**.

---

## Example

**Input**

```text
nums1 = [4,1,2]
nums2 = [1,3,4,2]
```

**Output**

```text
[-1,3,-1]
```

**Explanation**

- 4 → No greater element → -1
- 1 → 3
- 2 → No greater element → -1

---

# Approach

Instead of searching for every element of `nums1` separately (which is slow),

we first compute the **Next Greater Element for every element in nums2** using a **Monotonic Stack**.

Then we store those answers in a **HashMap**.

Finally, for every element in `nums1`, we simply fetch the answer from the map.

---

# Why HashMap?

Suppose after processing `nums2` we have

```text
1 -> 3
2 -> -1
3 -> 4
4 -> -1
```

Now if someone asks

```text
Next Greater of 1?
```

We don't need to search again.

We simply do

```java
map.get(1)
```

which takes **O(1)** time.

---

# Algorithm

### Step 1

Traverse `nums2` from **right to left**.

---

### Step 2

Use a **Monotonic Decreasing Stack**.

While stack top is smaller or equal to current element,

remove it.

```java
while(!stack.isEmpty() && stack.peek() <= nums2[i]){
    stack.pop();
}
```

---

### Step 3

If stack is empty,

Next Greater = -1

Else

Next Greater = stack.peek()

Store this in HashMap.

```java
map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
```

---

### Step 4

Push current element into stack.

```java
stack.push(nums2[i]);
```

---

### Step 5

Now traverse `nums1`.

For every element,

its answer is already present inside the HashMap.

```java
ans[i] = map.get(nums1[i]);
```

---

# Dry Run

### Input

```text
nums1 = [4,1,2]

nums2 = [1,3,4,2]
```

Initially

```text
Stack = []

Map = {}
```

---

### Current = 2

Stack empty

Map

```text
2 -> -1
```

Push 2

```text
Stack = [2]
```

---

### Current = 4

2 <= 4

Pop 2

Stack empty

Map

```text
4 -> -1
```

Push 4

```text
Stack = [4]
```

---

### Current = 3

Top = 4

Map

```text
3 -> 4
```

Push 3

```text
Stack = [4,3]
```

---

### Current = 1

Top = 3

Map

```text
1 -> 3
```

Push 1

```text
Stack = [4,3,1]
```

Final Map

```text
1 -> 3
2 -> -1
3 -> 4
4 -> -1
```

Now process nums1

```text
4 -> -1
1 -> 3
2 -> -1
```

Final Answer

```text
[-1,3,-1]
```

---

# Time Complexity

Processing `nums2`

- Every element is pushed once.
- Every element is popped at most once.

**O(N)**

Processing `nums1`

**O(M)**

Overall

**O(N + M)**

where

- N = nums2.length
- M = nums1.length

---

# Space Complexity

- Stack → **O(N)**
- HashMap → **O(N)**

Overall

**O(N)**

---

# Key Points to Remember

- Traverse `nums2` from **Right → Left**.
- Use a **Monotonic Decreasing Stack**.
- Store each element's Next Greater Element in a **HashMap**.
- Answer every query of `nums1` in **O(1)** using the map.
- Overall complexity is **O(N + M)**.
