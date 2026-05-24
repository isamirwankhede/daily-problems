# calculate the lenght of the last word :
### LEETCODE : 
https://leetcode.com/problems/length-of-last-word

🔍 Explanation
✅ trim() Function
Removes leading and trailing spaces

Example:

"   hello world   " → "hello world"
🔁 Loop Logic
Start from the last character
Count characters until:
A space ' ' is found → stop
This gives the length of the last word
📊 Example
Input:
s = "the sky is blue"
Process:
After trim → "the sky is blue"

Traverse from end:

e → u → l → b
Count = 4
Output:
4
⚡ Edge Cases
Input	Output
"hello"	5
" fly me "	2
"a "	1
" "	0
🚀 Time & Space Complexity
Time Complexity: O(n)
Space Complexity: O(1) (ignoring trimmed string copy)
💡 Key Takeaways
Always handle spaces carefully
trim() simplifies edge cases
Reverse traversal is efficient for “last word” problems
```java 
public int lengthOfLastWord(String s) {
        String st = s.trim();
        int cnt = 0;
    
        for(int i = st.length() -1 ; i >= 0 ; i--){
            if(st.charAt(i) != ' ') cnt++;
            else break;
        }

        return cnt ;

    }
```

here trim - remove spaces from left and right
