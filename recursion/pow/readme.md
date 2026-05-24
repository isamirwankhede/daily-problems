# Pow(x, n) - Binary Exponentiation

## Problem Statement
https://leetcode.com/problems/powx-n/


Implement power function:

```java
pow(x, n)
```

Which calculates:

```text
x raised to the power n (x^n)
```

---

# Approach Used

This solution uses **Binary Exponentiation** (Fast Power Algorithm).

Instead of multiplying `x` repeatedly `n` times, we reduce the exponent by half in every step.

This makes the solution very efficient.

---

# Java Solution

```java
class Solution {
    public double myPow(double x, int n) {

        double ans = 1.0;

        long nn = n;

        // Handle negative power safely
        if (nn < 0)
            nn = -1 * nn;

        while (nn > 0) {

            // If power is odd
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            }

            // If power is even
            else {
                x = x * x;
                nn = nn / 2;
            }
        }

        // For negative exponent
        if (n < 0)
            ans = 1.0 / ans;

        return ans;
    }
}
```

---

# Dry Run Example

## Input

```text
x = 2
n = 10
```

## Steps

| Step | x   | n  | ans |
|------|-----|----|-----|
| Start | 2 | 10 | 1 |
| Even | 4 | 5 | 1 |
| Odd | 4 | 4 | 4 |
| Even | 16 | 2 | 4 |
| Even | 256 | 1 | 4 |
| Odd | 256 | 0 | 1024 |

## Output

```text
1024
```

---

# Time Complexity

```text
O(log n)
```

Because exponent becomes half in every iteration.

---

# Space Complexity

```text
O(1)
```

No extra space is used.

---

# Key Concept

- If exponent is odd:
  
```text
x^n = x * x^(n-1)
```

- If exponent is even:

```text
x^n = (x*x)^(n/2)
```

This optimization is called:

```text
Binary Exponentiation
```

---

# Edge Cases Handled

✔ Negative exponent  
✔ Large values of n  
✔ Integer overflow using long  

---

# Author

Prepared for DSA / LeetCode practice.