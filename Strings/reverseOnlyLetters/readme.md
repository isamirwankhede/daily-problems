# Reverse Only Letters (Java)
### Problem Statement
https://leetcode.com/problems/reverse-only-letters/

```java 
int n = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (!Character.isLetter(chars[i])) {
                i++;
            } else if (!Character.isLetter(chars[j])) {
                j--;
            }

            else {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }

        return new String(chars);
```
Given ek string s, sirf letters ko reverse karna hai
aur special characters (jaise -, @, #) ko same position par rakhna hai.

💡 Simple Samajh 

## String me jo letters (a-z, A-Z) hai unko reverse karo
## Baaki characters jaha hai waha hi rehne do

### Example

Input:  "ab-cd"
Output: "dc-ba"
Input:  "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

### Approach (2 Pointer Method)
### Logic:

Ek pointer i → start se (left)
Ek pointer j → end se (right)

### Rules:
Agar i pe letter nahi hai → i++
Agar j pe letter nahi hai → j--
Agar dono letters hai → swap karo + dono pointer move karo


1️⃣ toCharArray()

👉 String ko character array me convert karta hai

"ab-cd" → ['a','b','-','c','d']

👉 Isse hume characters easily swap karne me help milti hai

2️⃣ Character.isLetter()

👉 Check karta hai ki character letter hai ya nahi

Character.isLetter('a') → true  
Character.isLetter('-') → false

👉 Iska use karke hum decide karte hai:

skip karna hai ya
swap karna hai
3️⃣ new String(chars)

👉 Character array ko wapas String me convert karta hai

['d','c','-','b','a'] → "dc-ba"
4️⃣ Main Function Logic
while (i < j)

👉 Jab tak dono pointer cross nahi hote tab tak loop chalega

5️⃣ Swapping Logic
char temp = chars[i];
chars[i] = chars[j];
chars[j] = temp;

👉 Do characters ki position exchange karta hai

6️⃣ Pointer Movement
i++;
j--;

👉 Swap ke baad dono pointers aage badhte hai
