# 🔁 Reverse Vowels in a String (Java)

## 📌 Problem Statement

Given a string, reverse only the vowels in the string and return the modified string.

---

## 🧠 Approach Used

We use the **Two Pointer Technique**:

* One pointer starts from the beginning (`i`)
* Another pointer starts from the end (`j`)
* Swap only when both pointers point to vowels

---

## 🔧 Functions Explanation

### 🔹 `isVowels(char ch)`

Checks whether a given character is a vowel or not.

#### ✅ Logic:

* Returns `true` if character is:

  * `a, e, i, o, u` (lowercase)
  * `A, E, I, O, U` (uppercase)
* Otherwise returns `false`

```java
static boolean isVowels(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
           ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
}
```

---

### 🔹 `reverseVowels(String s)`

Reverses only the vowels in the string.

#### ✅ Steps:

1. Convert string to character array
2. Initialize two pointers:

   * `i = 0` (start)
   * `j = n - 1` (end)
3. Loop while `i < j`
4. Skip non-vowels
5. Swap vowels when found
6. Convert array back to string

```java
static String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    int i = 0, j = chars.length - 1;

    while (i < j) {
        if (!isVowels(chars[i])) i++;
        else if (!isVowels(chars[j])) j--;
        else {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    return new String(chars);
}
```

---

### 🔹 `main(String[] args)`

Entry point of the program.

```java
public static void main(String[] args) {
    String s = "IceCreAm";
    System.out.println(reverseVowels(s));
}
```

---

## 🧪 Example

### Input:

```
IceCreAm
```

### Output:

```
AceCreIm
```

---

## ⏱️ Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(n)

---

## 🚀 Key Concepts Used

* Two Pointer Technique
* String to Char Array Conversion
* Conditional Swapping

---

## 📂 How to Run

```bash
javac ReverseVowels.java
java ReverseVowels
```

---

## 💡 Interview Tip

This problem is based on **two pointers**, which is commonly asked in coding interviews.

---

## ⭐ Author

Sameer Wankhede
