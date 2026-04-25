# 📘 Prefix of Word – Hinglish Explanation (Java)

## 🔹 Problem
https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/

1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence

Tumhe ek **sentence** aur ek **searchWord** diya hai.
Tumhe find karna hai ki sentence ka **kaunsa word (1-based index)** us searchWord se start hota hai.

Agar koi bhi word match nahi karta → return `-1`

---

## 🔹 Code

```java
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String words[] = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) return i + 1;
        }

        return -1;
    }
}
```

---

## 🔹 Step-by-Step Samajh

### 1. Sentence ko todna (split)

```java
String words[] = sentence.split(" ");
```

👉 Sentence ko words me convert kar diya

Example:

```
"i love eating burger"
→ ["i", "love", "eating", "burger"]
```

---

### 2. Loop chalana

```java
for (int i = 0; i < words.length; i++)
```

👉 Har word ko ek-ek karke check kar rahe hain

---

### 3. Prefix check karna

```java
if (words[i].startsWith(searchWord))
```

👉 Check: kya current word `searchWord` se start hota hai?

---

### 4. Answer return karna

```java
return i + 1;
```

👉 `+1` isliye kyunki indexing 0 se start hoti hai,
par answer 1-based chahiye

---

### 5. Agar kuch nahi mila

```java
return -1;
```

👉 Koi bhi word match nahi hua

---

## 🔹 Example

```
sentence = "i love eating burger"
searchWord = "burg"
```

Check:

* i ❌
* love ❌
* eating ❌
* burger ✅

👉 Output: `4`

---

## 🔹 Yaad rakhne ka shortcut 🧠

👉 **"Split → Loop → startsWith → i+1 → else -1"**

---

## 🔹 Important Points

* `split(" ")` → sentence ko words me todta hai
* `startsWith()` → prefix check karta hai
* Answer hamesha **1-based index** me hoga

---

## 🔹 Common Mistakes

* ❌ `spilt` likh dena (galat spelling)
* ❌ `+1` bhool jana
* ❌ `contains()` use karna instead of `startsWith()`

---

## 🔹 Complexity

* Time: `O(n * m)`
* Space: `O(n)`

---

Bas itna yaad rakho:
👉 **Har word check karo → jo start kare searchWord se → uska index +1 return karo**

---
