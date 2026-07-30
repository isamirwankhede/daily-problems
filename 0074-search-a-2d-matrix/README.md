<h2><a href="https://leetcode.com/problems/search-a-2d-matrix/description/">74. Search a 2D Matrix</a></h2><h3>Medium</h3><hr><p>You are given an <code>m x n</code> integer matrix <code>matrix</code> with the following two properties:</p>

<ul>
	<li>Each row is sorted in non-decreasing order.</li>
	<li>The first integer of each row is greater than the last integer of the previous row.</li>
</ul>

<p>Given an integer <code>target</code>, return <code>true</code> <em>if</em> <code>target</code> <em>is in</em> <code>matrix</code> <em>or</em> <code>false</code> <em>otherwise</em>.</p>

<p>You must write a solution in <code>O(log(m * n))</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat2.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>-10<sup>4</sup> &lt;= matrix[i][j], target &lt;= 10<sup>4</sup></code></li>
</ul>


# 🔍 Search a 2D Matrix (Binary Search) - LeetCode 74

## 📝 Problem Statement

Ek `m x n` matrix diya gaya hai jisme:

1. Har row sorted hai (ascending order).
2. Har next row ka first element, previous row ke last element se bada hai.

Hume `target` value search karni hai.

Return:

- `true` → agar target matrix me present ho.
- `false` → agar target present nahi hai.

**Time Complexity Required:** `O(log(m * n))`

---

## 💡 Idea

Matrix dekhne me 2D hai, lekin given conditions ki wajah se ye almost ek sorted 1D array ki tarah behave karta hai.

Hum solution ko **2 Binary Search** me divide karte hain.

### Step 1 → Target kis row me ho sakta hai?

Har row ka:

- First Element
- Last Element

check karte hain.

Agar

```text
matrix[mid][0] <= target <= matrix[mid][m-1]
```

to target sirf isi row me ho sakta hai.

Agar target first element se bada hai to niche wali rows me search karo.

Warna upar wali rows me search karo.

---

### Step 2 → Selected row me Binary Search

Jab row mil jaye tab normal Binary Search laga do.

Agar target mil gaya → return true

Nahi mila → return false

---

## 🔄 Dry Run

### Input

```text
matrix =
[
 [1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]
]

target = 3
```

### First Binary Search (Row Search)

Initially

```text
top = 0
bottom = 2
```

### Iteration 1

```text
mid = 1
```

Current Row

```text
[10,11,16,20]
```

Check

```text
3 >= 10 ❌
```

Target chota hai.

Move upar

```text
bottom = mid - 1
```

Now

```text
top = 0
bottom = 0
```

---

### Iteration 2

```text
mid = 0
```

Current Row

```text
[1,3,5,7]
```

Check

```text
1 <= 3 <= 7 ✅
```

Target isi row me hoga.

---

## Second Binary Search

Search in

```text
[1,3,5,7]
```

Initially

```text
low = 0
high = 3
```

### Iteration 1

```text
mid = 1
```

Element

```text
3
```

Target mil gaya.

Return

```text
true
```

---

## 📈 Complexity Analysis

### Time Complexity

Row Search

```text
O(log m)
```

Column Search

```text
O(log n)
```

Overall

```text
O(log m + log n)
```

Aur mathematically,

```text
O(log(m × n))
```

same hi hota hai.

---

### Space Complexity

```text
O(1)
```

Koi extra space use nahi hui.

---

# ✅ Java Code

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n - 1;
        int row = -1;

        // Step 1: Find the correct row
        while (top <= bottom) {
            int mid = (top + bottom) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][m - 1]) {
                row = mid;
                break;
            } else if (target > matrix[mid][0]) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }

        if (row == -1)
            return false;

        // Step 2: Binary Search in the selected row
        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return false;
    }
}
```

---

# ⭐ Golden Rule

> **Pehle Binary Search se row dhoondo, phir us row ke andar Binary Search lagao.**

Yaad rakhne ka shortcut:

```text
Row Find ➜ Column Find
```

Ya

```text
Binary Search + Binary Search = Answer
```
