# 🔍 Group Anagrams - Java Solution

## 📌 Problem Statement

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

### 🧾 Example

**Input:**

["eat", "tea", "tan", "ate", "nat", "bat"]


**Output:**

[
["eat", "tea", "ate"],
["tan", "nat"],
["bat"]
]


---

## 🧠 What are Anagrams?

Anagrams are words that have:
- Same characters
- Same frequency of each character
- Different order

👉 Example:
- `"eat"`, `"tea"`, `"ate"` are anagrams

---

## 💡 Approach (Optimal - Frequency Count)

Instead of sorting each string, we use a **character frequency count**.

### 🔑 Key Idea

- Use an integer array of size `26` to store character frequencies.
- Convert this frequency array into a unique string key.
- Use a `HashMap` to group strings with the same key.

---

## ⚙️ Algorithm

1. Create a HashMap:

Map<String, List<String>>


2. For each string:
- Initialize a frequency array of size 26.
- Count each character.
- Convert frequency array into a string key.

3. Store strings in the map using this key.

4. Convert map values into the final result list.

---

## ✅ Java Implementation

```java
import java.util.*;

class Solution {
 public ArrayList<ArrayList<String>> anagrams(String[] strs) {
     
     if (strs.length == 0) {
         return new ArrayList<>();
     }

     Map<String, List<String>> ansMap = new HashMap<>();

     for (String s : strs) {
         int[] count = new int[26];

         for (char c : s.toCharArray()) {
             count[c - 'a']++;
         }

         StringBuilder sb = new StringBuilder();

         for (int i = 0; i < 26; i++) {
             sb.append("#");
             sb.append(count[i]);
         }

         String key = sb.toString();

         ansMap.putIfAbsent(key, new ArrayList<>());
         ansMap.get(key).add(s);
     }

     ArrayList<ArrayList<String>> result = new ArrayList<>();

     for (List<String> group : ansMap.values()) {
         result.add(new ArrayList<>(group));
     }

     return result;
 }
}

```
🔍 Dry Run

For input:

["eat", "tea", "bat"]
Word	Frequency Key	Group
eat	#1#0#...#1...	["eat"]
tea	same key	["eat", "tea"]
bat	different key	["bat"]
⏱️ Time Complexity
O(N * K)
N = number of strings
K = max length of a string

👉 Efficient because we avoid sorting.

💾 Space Complexity
O(N * K)
For storing grouped anagrams in the map
🔄 Alternative Approach (Sorting)
Idea:
Sort each string
Use sorted string as key
Example:
"eat" → "aet"
"tea" → "aet"
❌ Drawback:
Sorting takes O(K log K)
Slower than frequency count
⚖️ Comparison
Approach	Time Complexity
Sorting	O(K log K)
Frequency Count	O(K) ✅
