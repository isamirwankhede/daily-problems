# 🔥 Power of Two (Java)

## 📌 Problem Statement

Given an integer `n`, check whether it is a **power of 2** or not.

A number is called a power of 2 if it can be written as:

```
2^0 = 1
2^1 = 2
2^2 = 4
2^3 = 8
...
```

---

## 💡 Simple Understanding (Hinglish)

Agar koi number ko **baar-baar 2 se divide karne par last me 1 milta hai**,
toh wo **power of 2** hai.

### ✅ Example:

```
n = 8

8 → 4 → 2 → 1 ✅
```

### ❌ Example:

```
n = 10

10 → 5 → 2.5 ❌
```

---

## 🛠 Approach 1: Loop Method (Easy for Exams)

### 🔹 Logic:

* Jab tak number 2 se divisible hai, divide karte raho
* Last me agar `1` aaya → true

### ✅ Code:

```java
public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;

    while (n % 2 == 0) {
        n = n / 2;
    }

    return n == 1;
}
```

---

## ⚡ Approach 2: Bit Manipulation (Fastest)

### 🔹 Logic:

Power of 2 numbers ka binary form me sirf **1 hi '1' hota hai**

Example:

```
2  = 10
4  = 100
8  = 1000
```

### Trick:

```
n & (n - 1) == 0
```

### ✅ Code:

```java
public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;
    return (n & (n - 1)) == 0;
}
```

---

## 🚀 Time Complexity

* Loop Method → O(log n)
* Bit Method → O(1)

---

## 🧠 Key Points

* Always check `n > 0`
* Bit method is best for interviews
* Loop method is best for writing in exams

---

## 🎯 Conclusion

👉 Agar number repeatedly 2 se divide hoke **1 ban jaye**, toh wo **Power of Two** hai.

---

## 🙌 Author

Made with 💻 + ❤️ for coding practice
