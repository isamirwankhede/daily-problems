# Add Strings (Java)

## Problem Statement

Do numbers `num1` aur `num2` string format me diye gaye hai.
Inko integer me convert kiye bina add karna hai.

---

## Simple Samajh (Hinglish)

Jaise hum copy me addition karte hai (right se left), waise hi yaha bhi karna hai.

Example:

```
  123
+ 456
-----
  579
```

Bas yaha numbers string me hai.

---

## Code Samajh (Line by Line)

### 1. Pointers initialize

```java
int i = num1.length() - 1;
int j = num2.length() - 1;
```

Dono strings ke last index se start kar rahe hai (right to left).

---

### 2. Carry variable

```java
int carry = 0;
```

Addition me jo carry aata hai usko store karega.

---

### 3. Result store karne ke liye

```java
StringBuilder sb = new StringBuilder();
```

Final answer yaha store hoga (reverse order me).

---

### 4. Loop condition

```java
while(i >= 0 || j >= 0 || carry != 0)
```

Loop tab tak chalega jab tak:

* koi digit bacha hai
* ya carry bacha hai

---

### 5. Digits nikalna

```java
int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
```

Character ko number me convert kar rahe hai.

Example:

```
'5' - '0' = 5
```

---

### 6. Sum calculate

```java
int sum = digit1 + digit2 + carry;
```

---

### 7. Carry update

```java
carry = sum / 10;
```

Agar sum 10 ya usse bada hai to carry banega.

---

### 8. Result me digit add

```java
sb.append(sum % 10);
```

Last digit store karte hai.

---

### 9. Pointers move

```java
i--;
j--;
```

---

### 10. Final answer reverse

```java
return sb.reverse().toString();
```

Kyuki humne reverse order me store kiya tha.

---

## Example

```
num1 = "11"
num2 = "123"

Step:
1 + 3 = 4
1 + 2 = 3
0 + 1 = 1

Output = "134"
```

---

## Time Complexity

* O(n) -> ek baar traverse

---

## Key Points

* String ko integer me convert nahi karna
* Right se left add karna
* Carry handle karna important hai
* StringBuilder use karo for efficiency

---

## Conclusion

Same school wali addition logic, bas strings ke saath implement kiya hai.

---

## Author

Made for coding practice
