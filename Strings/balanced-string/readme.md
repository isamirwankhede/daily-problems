# ✔️ isBalanced (Even-Odd Sum Check) – Java

## 📌 Problem Statement
https://leetcode.com/problems/check-balanced-string/

Ek string `num` diya hai jo digits contain karta hai.
👉 Check karna hai ki:

**even index digits ka sum == odd index digits ka sum**

---

## 💡 Simple Samajh (Hinglish)

👉 String ke digits ko do parts me divide karo:

* Even index (0, 2, 4...)
* Odd index (1, 3, 5...)

👉 Dono ka sum compare karo

* Equal → true
* Not equal → false

---

## ✅ Example

```
Input: "1234"

Even index: 1 + 3 = 4  
Odd index:  2 + 4 = 6  

Output: false
```

```
Input: "121"

Even index: 1 + 1 = 2  
Odd index:  2       = 2  

Output: true
```

---

## 🛠 Approach

### 🔹 Steps:

1. Do variables lo → `evenSum`, `oddSum`
2. Loop chalao string par
3. Check karo index even hai ya odd
4. Uske according sum me add karo
5. End me dono compare karo

---

## 🔍 Code Explanation

### 1. Variables initialize

```java
int evenSum = 0;
int oddSum = 0;
```

👉 Dono sums store karne ke liye

---

### 2. Loop through string

```java
for(int i = 0; i < num.length(); i++)
```

👉 Har character par iterate kar rahe hai

---

### 3. Even / Odd check

```java
if(i % 2 == 0)
    evenSum += num.charAt(i) - '0';
else
    oddSum += num.charAt(i) - '0';
```

👉 Character ko number me convert karke add kar rahe hai
👉 `'0'` subtract karne se digit milta hai

---

### 4. Final comparison

```java
return evenSum == oddSum;
```

👉 Dono sums equal hai to true, warna false

---

## ✅ Full Code

```java
public boolean isBalanced(String num) {
    int evenSum = 0;
    int oddSum = 0;

    for (int i = 0; i < num.length(); i++) {
        if (i % 2 == 0)
            evenSum += num.charAt(i) - '0';
        else
            oddSum += num.charAt(i) - '0';
    }

    return evenSum == oddSum;
}
```

---

## 🚀 Time Complexity

* O(n) → ek baar string traverse hoti hai

---

## 🧠 Key Points

* Index 0 se start hota hai (important)
* `'char - '0'` se digit milta hai
* Even index aur odd index ka sum compare hota hai

---

## 🎯 Conclusion

👉 Agar **even position digits ka sum** aur
👉 **odd position digits ka sum same hai**,

toh number **balanced** hai.

---

## 🙌 Author

Made for coding practice
