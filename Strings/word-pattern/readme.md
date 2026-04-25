# Word Pattern problem

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.
 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false

 


 # approach 

 1) create a hashmap 
 2) now we just check some conditions

 steps = > 
 1) check if both pattern & given string lenghts same or not if not same we return false;

 2) converts words string to arrays

 we use split() => spilt the array on the basis of regex 
```jave s.split(" ")```

then iterate and check 

if this character is present or not in map 

 boolean containkey = containskey() 

```java  if(mpp.containsValue(arr[i]) && !containsKey) return false;
            if(containsKey &&  !mpp.get(ch).equals(arr[i])) return false;
            else {
                mpp.put(ch,arr[i]);
            } 
            
```
            

 now we  check some condtions 

 if key(pattern char ) not present but value of string present => return false 
 if key(pattern char )  present but value of string not equlas to the give string => return false 
 else
 we just put the key and value


 then return true;

 

 Problem

Check karna hai ki pattern aur string match karte hain ya nahi.

👉 Har character ka ek hi word hona chahiye
👉 Har word ka sirf ek hi character hona chahiye

🔹 Approach
String ko words me tod do:

String arr[] = s.split(" ");


Agar pattern aur words ka size alag hai → ❌ false

HashMap<Character, String> use karo mapping store karne ke liye

Loop chalao:

Agar word already kisi aur char ko mila hai → ❌ false

Agar char already mapped hai but word different hai → ❌ false

Warna mapping store karo

# Main Logic

1) if(mpp.containsValue(arr[i]) && !containsKey) return false;

2) if(containsKey && !mpp.get(ch).equals(arr[i])) return false;

3) else mpp.put(ch, arr[i]);

🔹 Example

pattern = "abba"
s = "dog cat cat dog" → ✅ true

pattern = "abba"

s = "dog cat cat fish" → ❌ false

# Key Points

Ek char → ek word (fix hona chahiye)

Ek word → ek char (duplicate nahi hona chahiye)

Order same hona chahiye