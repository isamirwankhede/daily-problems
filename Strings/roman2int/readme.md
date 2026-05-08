# Roman to Integer

## Problem Statement
Roman numeral string ko integer me convert karna hai.

## Problems :
### LEETCODE :
https://leetcode.com/problems/roman-to-integer/?envType=problem-list-v2&envId=string

### GFG -
https://www.geeksforgeeks.org/problems/roman-number-to-integer3201/1

### CODESTUDIO - 
https://www.naukri.com/code360/problem-details/roman-number-to-integer_981308



### Example

```text
Input: "III"
Output: 3

Input: "IV"
Output: 4

Input: "MCMXCIV"
Output: 1994
```

---

# Roman Numeral Values

| Roman | Value |
| ------ | ----- |
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

---

# Logic (Hinglish)

Agar smaller value bigger value ke pehle aati hai to subtract karte hai.

Example:

```text
IV = 5 - 1 = 4
IX = 10 - 1 = 9
```

Otherwise add karte hai.

```text
VI = 5 + 1 = 6
```

---

# Approach

1. Roman numerals ko HashMap me store karo.
2. String ko right se left traverse karo.
3. Agar current numeral next numeral se chota hai:
   - subtract karo
4. Otherwise:
   - add karo
5. Final result return karo.

---

# Java Code

```java
import java.util.HashMap;

class Solution {

    public int romanToInt(String s) {

        HashMap<Character, Integer> mpp = new HashMap<>();

        mpp.put('I', 1);
        mpp.put('V', 5);
        mpp.put('X', 10);
        mpp.put('L', 50);
        mpp.put('C', 100);
        mpp.put('D', 500);
        mpp.put('M', 1000);

        int n = s.length();

        int res = mpp.get(s.charAt(n - 1));

        for (int i = n - 2; i >= 0; i--) {

            if (mpp.get(s.charAt(i)) < mpp.get(s.charAt(i + 1))) {
                res = res - mpp.get(s.charAt(i));
            } else {
                res = res + mpp.get(s.charAt(i));
            }
        }

        return res;
    }
}
```

---

# Dry Run

## Input

```text
MCMXCIV
```

## Process

```text
V = 5

I < V
5 - 1 = 4

C > I
4 + 100 = 104

X < C
104 - 10 = 94

M > X
94 + 1000 = 1094

C < M
1094 - 100 = 994

M > C
994 + 1000 = 1994
```

## Output

```text
1994
```

---

# Time Complexity

```text
O(N)
```

String ko ek baar traverse kar rahe hai.

---

# Space Complexity

```text
O(1)
```

HashMap ka size fixed hai.

---

# Common Mistake

❌ Wrong

```java
mpp.put('m', 1000);
```

✅ Correct

```java
mpp.put('M', 1000);
```

Roman numerals uppercase me hote hai.

---

# Author

Made with Java 🚀