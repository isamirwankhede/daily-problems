# 151. Reverse Words in a String 
leetcode :  https://leetcode.com/problems/reverse-words-in-a-string/description/

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


s.split() in Java is used to break a string into parts (array of strings) based on a pattern (usually a delimiter).

🔹 In your code:
String[] words = s.split(" +");
🔸 What " +" means?
" " → space
"+" → one or more occurrences

👉 So " +" means:
split wherever there are one or more spaces

🔹 Example:
String s = "Hello   world  Java";
String[] words = s.split(" +");

👉 Output:

["Hello", "world", "Java"]

Even if there are multiple spaces, it treats them as a single separator.

🔹 Why we use this here?

In your function:

reverseWords(String s)

You want to:

Break sentence into words
Reverse them
Join back

👉 split(" +") helps ignore extra spaces and gives clean words.