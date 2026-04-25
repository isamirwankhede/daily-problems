# 📝 Ransom Note Problem (Hinglish Revision Notes)

## 📌 Problem Statement

Tumhe 2 strings diye hai:

* `ransomNote`
* `magazine`

👉 Check karna hai: kya `ransomNote`, `magazine` ke letters use karke bana sakte ho?

⚠️ Rule:

* Har letter sirf **ek hi baar use ho sakta hai**

---

## 💡 Simple Logic (Easy Hinglish)

Idea simple hai:

1. Pehle `magazine` ke saare letters ka **count store karo**
2. Fir `ransomNote` ke letters ko match karo
3. Agar koi letter nahi mila → **false**
4. Agar sab mil gaya → **true**

---

## ⚙️ Code Samajh (Line by Line)

### 🔹 Function: `canConstruct(String ransomNote, String magazine)`

### ✅ Step 1: Frequency Array Banana

```java
int freq[] = new int[26];
```

👉 Ye array `a` se `z` tak letters ka count store karega

* `'a' -> index 0`
* `'b' -> index 1`
* ...
* `'z' -> index 25`

---

### ✅ Step 2: Magazine ke letters count karna

```java
for(char ch : magazine.toCharArray()){
    freq[ch - 'a']++;
}
```

👉 Har character ka count badha rahe hai

Example:

```
magazine = "aaa"
freq['a'] = 3
```

---

### ✅ Step 3: Ransom Note check karna

```java
for(char ch : ransomNote.toCharArray()){
    if(freq[ch - 'a'] == 0) return false;
    freq[ch - 'a']--;
}
```

👉 Logic:

* Agar letter available nahi hai → return false
* Agar hai → use kar lo (count kam karo)

---

### ✅ Step 4: Final Return

```java
return true;
```

👉 Matlab sab letters mil gaye ✅

---

## 🔹 `main()` Function

```java
String ransomNote  = "aab";
String magazine   = "aaa";

System.out.println(canConstruct(ransomNote , magazine));
```

### 🧾 Output:

```
false
```

👉 Kyun?

* `"aab"` ko chahiye:

  * 2 'a' ✔
  * 1 'b' ❌ (magazine me nahi hai)

---

## ⏱️ Complexity

* Time: **O(n + m)**
* Space: **O(1)** (sirf 26 size array)

---

## 🔥 Important Concepts (Revision)

* Frequency Array
* Character Mapping (`ch - 'a'`)
* Greedy Approach
* String Traversal

---

## 🧪 Test Cases

| ransomNote | magazine | Output |
| ---------- | -------- | ------ |
| "a"        | "b"      | false  |
| "aa"       | "ab"     | false  |
| "aa"       | "aab"    | true   |
| "abc"      | "cba"    | true   |

---

## 🎯 Viva / Interview Tip

👉 Agar poocha:
**Array kyu use kiya HashMap ke jagah?**

Answer:

* Fast hota hai (O(1) access)
* Fixed size (sirf 26 letters)
* Memory efficient

---

## 📚 Short Summary

* Magazine ka count store karo
* RansomNote ke letters match karo
* Use karte waqt count kam karo
* Agar koi missing → false

---

## 🚀 Final Line (Yaad rakhne ke liye)

👉 **"Count karo → Match karo → Use karo → Check karo"**

---

Perfect revision note 💯
