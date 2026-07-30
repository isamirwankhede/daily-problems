<h2><a href="https://www.geeksforgeeks.org/problems/kth-element-in-matrix/1">Kth smallest element in a Matrix</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;"><span style="font-family: arial,helvetica,sans-serif;">Given a matrix&nbsp;<strong>mat[][]</strong>&nbsp;of size <strong>n*n</strong>, where each row and column is sorted in&nbsp;<strong>non-decreasing</strong>&nbsp;order. Find the&nbsp;<strong>kth</strong>&nbsp;smallest element in the matrix.</span></span></p>
<div><span style="font-size: 18px;"><span style="font-family: arial,helvetica,sans-serif;"><strong>Examples:</strong></span></span></div>
<pre><span style="font-size: 18px;"><span style="font-family: arial,helvetica,sans-serif;"><strong>Input: </strong>mat[][] = [[16, 28, 60, 64], k = 3<br>                [22, 41, 63, 91],<br>                [27, 50, 87, 93],<br>                [36, 78, 87, 94]]
<strong>Output: </strong>27
<strong>Explanation: </strong>27 is the 3<sup>rd</sup> smallest element.</span></span></pre>
<pre><span style="font-size: 18px;"><span style="font-family: arial,helvetica,sans-serif;"><strong>Input: </strong>mat[][] = [[10, 20, 30, 40], k = 7<br>                [15, 25, 35, 45],<br>                [24, 29, 37, 48],<br>                [32, 33, 39, 50]] 
<strong>Output: </strong>30
<strong>Explanation: </strong>30 is the 7<sup>th</sup> smallest element.</span></span></pre>
<p><span style="font-size: 18px;"><span style="font-family: arial,helvetica,sans-serif;"><strong>Constraints:</strong><br>1 ≤ n ≤ 500<br>1 ≤ mat[i][j] ≤ 10<sup>4</sup></span></span><br><span style="font-size: 18px;"><span style="font-family: arial,helvetica,sans-serif;">1 ≤ k ≤ n*n</span></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Accolite</code>&nbsp;<code>Amazon</code>&nbsp;<code>Samsung</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Matrix</code>&nbsp;<code>Heap</code>&nbsp;<code>Binary Search</code>&nbsp;

# 🔍 Search a 2D Matrix II (LeetCode 240)

## 📝 Problem Statement

Ek `m x n` matrix diya gaya hai jisme:

- Har **row** left → right ascending order me sorted hai.
- Har **column** top → bottom ascending order me sorted hai.

Hume `target` value search karni hai.

Return:

- `true` → agar target matrix me present hai.
- `false` → agar target present nahi hai.

---

# 💡 Idea

Yaha pe previous question (LeetCode 74) ki tarah Binary Search nahi lag sakti.

Kyun?

Kyuki yaha rows aur columns sorted hain, **poora matrix globally sorted nahi hai.**

Example:

```text
1   4   7
2   5   8
3   6   9
```

Ye ek sorted 1D array nahi ban sakta.

Isliye hum **Top Right Corner** se traversal start karte hain.

---

# 🤔 Top Right se hi kyu?

Start Point

```text
        ↓
1   4   7
2   5   8
3   6   9
        ↑
```

Top Right element ke paas do important properties hoti hain.

### Left side

Sab elements usse chote hote hain.

### Down side

Sab elements usse bade hote hain.

Isliye sirf ek comparison se ek poori row ya column eliminate kar sakte hain.

---

# 🔄 Algorithm

### Step 1

Start from

```text
row = 0
col = last column
```

---

### Step 2

Compare current element with target.

### Case 1

Current == Target

```text
Return true
```

---

### Case 2

Current < Target

Target bada hai.

Current row me left wale sab aur bhi chote honge.

Isliye

```text
row++
```

Neeche move karo.

---

### Case 3

Current > Target

Target chota hai.

Current column me neeche wale sab aur bade honge.

Isliye

```text
col--
```

Left move karo.

---

### Step 4

Jab matrix ke bahar chale jao

```text
Return false
```

---

# 🔄 Dry Run

## Input

```text
matrix =
[
[1,4,7,11,15],
[2,5,8,12,19],
[3,6,9,16,22],
[10,13,14,17,24],
[18,21,23,26,30]
]

target = 5
```

Start

```text
row = 0
col = 4
```

Current

```text
15
```

15 > 5

Move Left

```text
col = 3
```

Current

```text
11
```

11 > 5

Move Left

```text
col = 2
```

Current

```text
7
```

7 > 5

Move Left

```text
col = 1
```

Current

```text
4
```

4 < 5

Move Down

```text
row = 1
```

Current

```text
5
```

Target mil gaya.

Return

```text
true
```

---

# ❌ Example 2

Target = 20

Traversal

```text
15
↓

19
↓

22
←

16
↓

17
↓

24
←

...
```

Finally matrix ke bahar chale jayenge.

Return

```text
false
```

---

# 📈 Complexity Analysis

### Time Complexity

Har step me ya to

- ek row neeche jaate hain
- ya ek column left aate hain.

Maximum

```text
m + n
```

steps lagenge.

So,

```text
O(m + n)
```

---

### Space Complexity

```text
O(1)
```

Extra space use nahi hui.

---

# ✅ Java Code

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {
                row++;
            }
            else {
                col--;
            }
        }

        return false;
    }
}
```

---

# ⭐ Golden Rule

Top Right Corner se start karo.

```text
Current > Target
⬅ Left jao

Current < Target
⬇ Down jao
```

Yaad rakhne ka shortcut:

```text
Top Right

Bada mila → Left

Chota mila → Down
```

Har move me ek poori row ya column eliminate ho jata hai, isi wajah se solution efficient hai (`O(m + n)`).
