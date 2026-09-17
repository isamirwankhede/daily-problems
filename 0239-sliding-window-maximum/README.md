<h2><a href="https://leetcode.com/problems/sliding-window-maximum">239. Sliding Window Maximum</a></h2><h3>Hard</h3><hr><p>You are given an array of integers&nbsp;<code>nums</code>, there is a sliding window of size <code>k</code> which is moving from the very left of the array to the very right. You can only see the <code>k</code> numbers in the window. Each time the sliding window moves right by one position.</p>

<p>Return <em>the max sliding window</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,-1,-3,5,3,6,7], k = 3
<strong>Output:</strong> [3,3,5,5,6,7]
<strong>Explanation:</strong> 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       <strong>3</strong>
 1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
 1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
 1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
 1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
 1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1], k = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>

# Sliding Window Maximum

## Problem

Given an integer array `nums` and an integer `k`, find the maximum element in every sliding window of size `k`.

### Example

```text
Input:
nums = [1, 3, -1, -3, 5, 3, 6, 7]
k = 3

Output:
[3, 3, 5, 5, 6, 7]
```

### Explanation

```text
[1, 3, -1] → 3
[3, -1, -3] → 3
[-1, -3, 5] → 5
[-3, 5, 3] → 5
[5, 3, 6] → 6
[3, 6, 7] → 7
```

---

## Approach

We use a **Monotonic Deque** to solve this problem efficiently.

The Deque stores **indices** of the elements, not the actual values.

The main idea is:

* The front of the Deque always contains the index of the maximum element.
* Remove elements from the front if they are outside the current window.
* Remove smaller elements from the back because they can never become the maximum while the current larger element is present.
* Add the current index to the back.
* Once the window size becomes `k`, the element at the front is the maximum.

---

## Java Code

```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int result[] = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int right = 0; right < n; right++) {

            // Remove indices that are outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            // Add current index
            deque.addLast(right);

            // Store maximum when window size becomes k
            if (right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
```

---

## Code Explanation

### 1. Create Result Array

```java
int n = nums.length;
int result[] = new int[n - k + 1];
```

There are:

```text
n - k + 1
```

possible windows.

For example:

```text
n = 8
k = 3

8 - 3 + 1 = 6
```

So the result array will contain `6` answers.

---

### 2. Create Deque

```java
Deque<Integer> deque = new LinkedList<>();
```

The Deque stores **indices**.

Example:

```text
nums  = [1, 3, -1]
index =  0  1   2
```

If the Deque contains:

```text
[1, 2]
```

it means:

```text
nums[1] = 3
nums[2] = -1
```

---

## 3. Remove Out-of-Window Elements

```java
while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
    deque.pollFirst();
}
```

This removes indices that are no longer inside the current sliding window.

### Example

```text
k = 3
right = 3
```

Current window:

```text
[1, 2, 3]
```

Index `0` is outside the window.

So index `0` is removed from the front.

---

## 4. Remove Smaller Elements

```java
while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
    deque.pollLast();
}
```

This is the most important part.

Suppose:

```text
nums = [1, 3]
```

Current element is:

```text
3
```

The previous element is:

```text
1
```

Since:

```text
1 < 3
```

`1` can never become the maximum while `3` is inside the window.

Therefore, remove `1` from the back.

This keeps only useful maximum candidates inside the Deque.

---

## 5. Add Current Index

```java
deque.addLast(right);
```

After removing unnecessary smaller elements, add the current index to the back.

---

## 6. Store the Maximum

```java
if (right >= k - 1) {
    result[right - k + 1] = nums[deque.peekFirst()];
}
```

When `right >= k - 1`, the window has reached size `k`.

The maximum element is always at the front of the Deque:

```java
deque.peekFirst()
```

So:

```java
nums[deque.peekFirst()]
```

gives the maximum of the current window.

---

# Dry Run

### Input

```text
nums = [1, 3, -1, -3, 5, 3, 6, 7]
k = 3
```

---

### Window 1

```text
[1, 3, -1]
```

Processing:

```text
1 → add
3 → remove 1 because 1 < 3
-1 → add
```

Deque:

```text
[1, 2]
```

Maximum:

```text
nums[1] = 3
```

Result:

```text
[3]
```

---

### Window 2

```text
[3, -1, -3]
```

Maximum:

```text
3
```

Result:

```text
[3, 3]
```

---

### Window 3

```text
[-1, -3, 5]
```

When `5` arrives:

```text
5 > -3
5 > -1
```

So the smaller elements are removed.

Deque:

```text
[4]
```

Maximum:

```text
5
```

Result:

```text
[3, 3, 5]
```

---

### Remaining Windows

```text
[-3, 5, 3] → 5
[5, 3, 6]  → 6
[3, 6, 7]  → 7
```

Final result:

```text
[3, 3, 5, 5, 6, 7]
```

---

# Important Deque Rules

Remember these 4 rules:

### Rule 1: Remove expired indices from the front

```java
deque.pollFirst();
```

### Rule 2: Remove smaller elements from the back

```java
deque.pollLast();
```

### Rule 3: Add the current index to the back

```java
deque.addLast(right);
```

### Rule 4: Maximum is always at the front

```java
nums[deque.peekFirst()]
```

---

# Easy Visualization

Think of the Deque like this:

```text
FRONT                         BACK
  ↓                             ↓

[ Maximum Candidate → Smaller Candidates ]
```

If a bigger element comes:

```text
Deque:
[3, 2, 1]

Current:
5
```

Since `5` is bigger than all of them:

```text
[3, 2, 1] → []
```

Then add `5`:

```text
[5]
```

Therefore, the front always contains the maximum candidate.

---

# Why Deque?

### Brute Force Approach

For every window, scan all `k` elements to find the maximum.

Time complexity:

```text
O(n × k)
```

### Optimized Approach

Using a Monotonic Deque, every index is:

* Added once
* Removed at most once

Therefore:

```text
Time Complexity: O(n)
Space Complexity: O(k)
```

---

# Interview Explanation

A simple way to explain this in an interview:

> We use a monotonic deque to maintain indices of potential maximum elements. We remove elements that are outside the current window from the front and remove smaller elements from the back. Therefore, the front of the deque always contains the index of the maximum element of the current window.

---

# Key Concept to Remember

```text
Sliding Window
       +
Monotonic Deque
       ↓
Maximum of every window in O(n)
```

### Quick Memory Trick

```text
Front → Maximum
Back  → Remove Smaller
Outside Window → Remove
Current Index → Add
```

---

## Complexity

| Complexity | Value  |
| ---------- | ------ |
| Time       | `O(n)` |
| Space      | `O(k)` |

---

## Pattern

**Problem Pattern:** Sliding Window + Monotonic Deque

**Important Data Structure:** `Deque<Integer>`

**Java Methods Used:**

```java
peekFirst()
peekLast()
pollFirst()
pollLast()
addLast()
```

