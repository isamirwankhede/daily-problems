<h2><a href="https://leetcode.com/problems/max-consecutive-ones-iii/">1046. Max Consecutive Ones III</a></h2><h3>Medium</h3><hr><p>Given a binary array <code>nums</code> and an integer <code>k</code>, return <em>the maximum number of consecutive </em><code>1</code><em>&#39;s in the array if you can flip at most</em> <code>k</code> <code>0</code>&#39;s.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> [1,1,1,0,0,<u><strong>1</strong>,1,1,1,1,<strong>1</strong></u>]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
<strong>Output:</strong> 10
<strong>Explanation:</strong> [0,0,<u>1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1</u>,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either 0 or 1.</li>
	<li><code>0 &lt;= k &lt;= nums.length</code></li>
</ul>


LeetCode 1004 — Max Consecutive Ones III

Difficulty: Medium
Topic: Sliding Window / Two Pointers
Language: Java

Problem

Given a binary array nums and an integer k, return the maximum number of consecutive 1s in the array if you can flip at most k 0s.

Example
Input:
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2

Output:
6

Explanation:

We can flip at most two 0s to 1s and obtain a longest valid subarray of length 6.

Approach — Sliding Window

We maintain a window using two pointers:

left  → starting point of window
right → ending point of window

We also maintain:

zeroCnt → number of zeros inside the current window
Rules
Move right from left to right.
If nums[right] == 0, increment zeroCnt.
If zeroCnt > k, the window has too many zeros.
Move left forward.
If the element removed by left is 0, decrement zeroCnt.
At the end, the size of the valid window represents the answer.
Key Idea

The current window is valid when:

zeroCnt <= k

Because that means we need to flip at most k zeros to make the entire window consist of 1s.

Java Solution
class Solution {
    public int longestOnes(int[] nums, int k) {

        int zeroCnt = 0;
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; right++) {

            // Add the current element to the window
            if (nums[right] == 0) {
                zeroCnt++;
            }

            // If zeros exceed k, shrink the window
            if (zeroCnt > k) {

                if (nums[left] == 0) {
                    zeroCnt--;
                }

                left++;
            }
        }

        return n - left;
    }
}
Dry Run

Consider:

nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2

Initially:

left = 0
zeroCnt = 0

As right moves:

[1]                  zeros = 0
[1,1]                zeros = 0
[1,1,1]              zeros = 0
[1,1,1,0]            zeros = 1
[1,1,1,0,0]          zeros = 2

The window is valid because:

zeroCnt <= k
2 <= 2

When another zero enters:

[1,1,1,0,0,0]

we get:

zeroCnt = 3
k = 2

So the window becomes invalid.

We move left forward until a zero leaves the window and reduce zeroCnt.

This process continues while right moves through the array.

The maximum valid window has length:

6

Therefore:

Answer = 6
Why Sliding Window?

A brute-force approach would check every possible subarray.

That can take:

O(n²)

The sliding window avoids repeatedly checking the same elements.

Both pointers move only forward:

left  → moves forward
right → moves forward

Therefore, the overall complexity is linear.

Complexity
Complexity	Value
Time	O(n)
Space	O(1)
Important Pattern

This problem belongs to the "Longest Valid Subarray" Sliding Window pattern.

General Template
int left = 0;

for (int right = 0; right < n; right++) {

    // Add nums[right] to window

    if (windowIsInvalid) {

        // Remove nums[left]

        left++;
    }

    // Calculate/update answer
}
Remember
RIGHT → Expand the window
LEFT  → Shrink the window

For this problem:

Window is valid → zeros <= k
Window is invalid → zeros > k
Interview Explanation

If asked "Explain your approach", you can say:

I use the sliding window technique with two pointers, left and right. I expand the window using the right pointer and keep track of the number of zeros in the window. If the number of zeros becomes greater than k, I move the left pointer forward and decrease the zero count when a zero leaves the window. This ensures that the window contains at most k zeros, which means all those zeros can be flipped to ones. The maximum window length gives the answer.

What I Learned
Sliding Window
Two Pointer Technique
Maintaining a count inside a window
Expanding and shrinking a window
Finding the longest valid subarray
O(n) optimization from a brute-force approach
LeetCode

Problem: 1004. Max Consecutive Ones III

Difficulty: Medium

Pattern:

Sliding Window + Two Pointers
