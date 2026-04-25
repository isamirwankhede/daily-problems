Is Subsequence (Two Pointer Approach)

## Problem Statement

Do strings diye gaye hain s aur t. Hume check karna hai ki s, t ka subsequence hai ya nahi.

### 👉 Subsequence kya hota hai?
Aisa sequence jo kisi string se kuch characters delete karke (order same rakhte hue) banaya ja sake.

🧾 Examples
Input: s = "abc", t = "ahbgdc"
Output: true

Input: s = "axc", t = "ahbgdc"
Output: false


## 💡 Approach: Two Pointer Technique

Hum 2 pointers use karte hain:

i → string s ke liye
j → string t ke liye

### 🧠 Logic Samjho Simple Way Me

t ko traverse karte jao (j move karega)
Har step pe check karo:

Agar s[i] == t[j] → match mil gaya
👉 dono pointers aage badhao (i++, j++)

Agar match nahi mila
👉 sirf j++ (character skip karo)

👉 End me check karo:

Agar i == s.length() → poora s mil gaya → ✅ true
Warna → ❌ false

```java```
public boolean isSubsequence(String s, String t) {

    // Agar s empty hai toh wo hamesha subsequence hoga
    if (s.length() == 0) return true;

    int i = 0; // pointer for s
    int j = 0; // pointer for t

    while (i < s.length() && j < t.length()) {

        if (s.charAt(i) == t.charAt(j)) {
            i++; // next char in s
            j++; // next char in t
        } else {
            j++; // skip char in t
        }
    }

    return i == s.length();
}
```

## ⚡ Complexity Analysis

Time Complexity	 O(n)
Space Complexity O(1) 

🎯 Key Points
Order maintain hona zaroori hai
Continuous hona zaroori nahi hai
Single pass me solution ho jata hai
Interview me bahut common question hai