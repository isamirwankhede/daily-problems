# Beauty Sum of All Substrings

### LEETCODE:
https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

### GFG:
https://www.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118/1

### CODESTUDIO:
https://www.naukri.com/code360/problems/sum-of-beauty-of-all-substrings_8143656?leftPanelTabValue=SUBMISSION

## Problem Statement

Given a string `s`, return the **sum of beauty of all substrings** of `s`.

### Beauty of a String

Beauty of string =

```text
Highest Frequency Character - Lowest Frequency Character
```

> Note: Sirf non-zero frequencies consider hongi.

---

# Intuition (Hinglish)

Hum har possible substring generate karenge.

Har substring ke liye:

- Character frequencies count karenge
- Maximum frequency nikalenge
- Minimum non-zero frequency nikalenge
- Dono ka difference answer me add karenge

---

# Approach

## Step 1

Outer loop `i` substring ka starting point hoga.

## Step 2

Inner loop `j` substring ka ending point hoga.

## Step 3

Har step par frequency update karenge.

## Step 4

Beauty calculate karenge:

```text
beauty = maxFreq - minFreq
```

Aur final sum me add kar denge.

---

# Dry Run

## Input

```text
s = "aabcb"
```

### Example Substring

```text
"aabc"
```

### Frequency Count

```text
a -> 2
b -> 1
c -> 1
```

### Beauty

```text
maxFreq = 2
minFreq = 1

beauty = 2 - 1 = 1
```

---

# Code

```java
public class Solution {

    private static int maxFreq(int freq[]) {

        int maxcnt = 0;

        for (int i = 0; i < freq.length; i++) {
            maxcnt = Math.max(maxcnt, freq[i]);
        }

        return maxcnt;
    }

    private static int minFreq(int freq[]) {

        int mincnt = Integer.MAX_VALUE;

        for (int i = 0; i < freq.length; i++) {

            if (freq[i] != 0) {
                mincnt = Math.min(mincnt, freq[i]);
            }
        }

        return mincnt;
    }

    private static int beautySum(String s) {

        int n = s.length();

        int sum = 0;

        for (int i = 0; i < n; i++) {

            int freq[] = new int[26];

            for (int j = i; j < n; j++) {

                freq[s.charAt(j) - 'a']++;

                int beauty = maxFreq(freq) - minFreq(freq);

                sum += beauty;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        String s = "aabcb";

        System.out.println(beautySum(s));
    }
}
```

---

# Important Functions   

## maxFreq()

Yeh function maximum frequency return karta hai.

```java
private static int maxFreq(int freq[]) {

    int maxcnt = 0;

    for (int i = 0; i < freq.length; i++) {
        maxcnt = Math.max(maxcnt, freq[i]);
    }

    return maxcnt;
}
```

---

## minFreq()

Yeh function minimum non-zero frequency return karta hai.

```java
private static int minFreq(int freq[]) {

    int mincnt = Integer.MAX_VALUE;

    for (int i = 0; i < freq.length; i++) {

        if (freq[i] != 0) {
            mincnt = Math.min(mincnt, freq[i]);
        }
    }

    return mincnt;
}
```

---

# Mistakes I Did (Revision Notes)

## Mistake 1 → Static Error

### Wrong

```java
private int maxFreq(int freq[])
```

### Correct

```java
private static int maxFreq(int freq[])
```

### Reason

`beautySum()` static method tha, isliye helper methods bhi static hone chahiye.

---

## Mistake 2 → minFreq Logic Error

### Wrong

```java
mincnt = Math.max(mincnt, freq[i]);
```

### Correct

```java
mincnt = Math.min(mincnt, freq[i]);
```

### Reason

Hume minimum frequency chahiye thi, maximum nahi.

---

# Time Complexity

## Complexity

```text
O(N² * 26)
```

Since `26` constant hai:

```text
Overall ≈ O(N²)
```

---

# Space Complexity

```text
O(26)
```

```text
≈ O(1)
```

---

# Key Learnings

- Frequency Array ka use
- Substring generation
- Nested loops
- Max & Min frequency calculation
- Static vs Non-static methods
- Brute Force approach

---

# Tags

```text
Strings
Hashing
Frequency Array
Brute Force
Substrings
```