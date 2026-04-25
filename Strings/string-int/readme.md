
        // Sign check
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Digit conversion
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');

            // Overflow handling
            if (sign * num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign * num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * num);
    }
}
```

---

## 🔍 Step-by-Step Explanation

### 1. Trim Spaces

* `"   -42"` → `"-42"`

---

### 2. Empty Check

* Agar string empty ho jaye → return `0`

---

### 3. Sign Detection

* `-` → negative
* `+` → positive
* Default → positive

---

### 4. Number Build Karna

* `"123"` →
  `1 → 12 → 123`

---

### 5. Stop Condition

* Non-digit aate hi loop break
  `"1337c0d3"` → `1337`

---

### 6. Overflow Handling ⭐

* Range: **[-2³¹, 2³¹ - 1]**
* Agar exceed kare:

  * return `Integer.MAX_VALUE`
  * return `Integer.MIN_VALUE`

---

## 🧪 Example Dry Runs

### Example 1

Input: `"42"`
Output: `42`

---

### Example 2

Input: `"   -042"`
Output: `-42`

---

### Example 3

Input: `"1337c0d3"`
Output: `1337`

---

### Example 4

Input: `"0-1"`
Output: `0`

---

### Example 5

Input: `"words and 987"`
Output: `0`

---

## ⚠️ Edge Cases

* Empty string → `0`
* Only sign → `0`
* Large number → clamp to range
* Mixed characters → stop at first invalid

---

## ❌ Limitations in This Approach

* `long` use kiya hai (interview me avoid kar sakte ho)
* `trim()` extra space/time leta hai

---

## 🚀 Optimization Idea

👉 Use `int` only + check overflow before multiplication:

```java
if (num > (Integer.MAX_VALUE - digit) / 10)
```

---

## 🧠 One-Line Revision

👉 **"Spaces skip → sign detect → digits build → overflow handle → return"**

---

## 🎯 Time & Space Complexity

* **Time:** O(n)
* **Space:** O(1)

---

## 💡 Final Tip

Ye question **interview me frequently aata hai**, especially for:

* String parsing
* Edge case handling
* Overflow logic

👉 Isko confidently explain karna = strong DSA basics 🚀
