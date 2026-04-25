# Roman to Integer Converter (Java) 🇮🇳

## 📌 Problem Samajh Lo

Roman numerals 7 symbols se bante hain:

| Symbol | Value |
| ------ | ----- |
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

Normally Roman numbers **left se right (bada → chhota)** likhe jaate hain.

👉 Example:

* II = 2
* XII = 12
* XXVII = 27

---

## 🔁 Special Case (Subtraction Rule)

Kabhi-kabhi chhota number bada ke pehle aata hai → **minus karte hain**

* IV = 4
* IX = 9
* XL = 40
* XC = 90
* CD = 400
* CM = 900

---

## 🎯 Goal

Given Roman string `s`, usko integer me convert karna hai.

---

## 🧠 Approach (Simple Hinglish Logic)

👉 String ko **right se left** traverse karo

👉 Rule yaad rakho:

* Agar current < next → **subtract**
* Warna → **add**

---

## ⚙️ Steps

1. Ek `HashMap` bana lo (Roman → Integer mapping)
2. Last character se start karo
3. Right se left loop chalao
4. Compare karo:

   * Chhota hai → minus
   * Bada ya equal hai → add
5. Final answer return karo

---

## 💻 Code

```java id="code123"
import java.util.HashMap;

public class RomanToInt {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        int n = s.length();

        mpp.put('I', 1);
        mpp.put('V', 5);
        mpp.put('X', 10);
        mpp.put('L', 50);
        mpp.put('C', 100);
        mpp.put('D', 500);
        mpp.put('M', 1000);

        int ans = mpp.get(s.charAt(n - 1));

        for (int i = n - 2; i >= 0; i--) {
            if (mpp.get(s.charAt(i)) < mpp.get(s.charAt(i + 1))) {
                ans -= mpp.get(s.charAt(i));
            } else {
                ans += mpp.get(s.charAt(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
    }
}
```

---

## 🔍 Example

### Input:

```
MCMXCIV
```

### Breakdown:

* M = 1000
* CM = 900
* XC = 90
* IV = 4

👉 Output = **1994**

---

## ⚡ Complexity

* ⏱ Time: O(n)
* 🧠 Space: O(1)

---

## 🚀 Quick Revision Trick

👉 Right se left jao
👉 Chhota before bada → **minus**
👉 Warna → **add**

---

## 🏁 Final Line

Simple sa rule hai:
**"Compare karo next element se — chhota ho toh minus, warna add"**

---
