<h2><a href="https://leetcode.com/problems/daily-temperatures">739. Daily Temperatures</a></h2><h3>Medium</h3><hr><p>Given an array of integers <code>temperatures</code> represents the daily temperatures, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is the number of days you have to wait after the</em> <code>i<sup>th</sup></code> <em>day to get a warmer temperature</em>. If there is no future day for which this is possible, keep <code>answer[i] == 0</code> instead.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> temperatures = [73,74,75,71,69,72,76,73]
<strong>Output:</strong> [1,1,4,2,1,1,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,40,50,60]
<strong>Output:</strong> [1,1,1,0]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,60,90]
<strong>Output:</strong> [1,1,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
	<li><code>30 &lt;=&nbsp;temperatures[i] &lt;= 100</code></li>
</ul>


# 739. Daily Temperatures

## 🧠 Problem Statement

Tumhe ek array diya gaya hai jisme har index ek din ka **temperature** represent karta hai.

Har din ke liye batana hai ki **kitne din wait karna padega ek warmer temperature milne ke liye**.

- Agar future me warmer temperature milta hai → days count return karo.
- Agar nahi milta → `0` return karo.

---

## 💡 Intuition

Har element ke liye agar brute force lagayenge to uske baad ke saare elements check karne padenge.

Example:

```
73
```

Uske baad

```
74
75
71
69
72
76
73
```

Har baar future scan karna padega.

Time Complexity:

```
O(N²)
```

Ye large constraints (`10^5`) ke liye slow hai.

Isliye hum **Monotonic Stack** use karte hain.

---

# 🔥 Main Idea

Hum **Right → Left** traverse karenge.

Reason?

Kyuki hume future ka warmer day chahiye.

Right side already processed hogi.

Stack me hum **indexes** store karenge.

Kyun?

Kyuki answer me temperature nahi,
**days ka difference** chahiye.

```
answer = futureIndex - currentIndex
```

---

# 📌 Logic

### Step 1

Right se Left traverse karo.

```
for(i = n-1 → 0)
```

---

### Step 2

Current temperature se chhote ya equal temperatures remove kar do.

```java
while(!stack.isEmpty() && temp[stack.peek()] <= temp[i])
{
    stack.pop();
}
```

Ye future me kisi ka answer nahi ban sakte.

---

### Step 3

Agar stack empty nahi hai.

Top index hi nearest warmer day hai.

```java
ans[i] = stack.peek() - i;
```

---

### Step 4

Current index stack me push kar do.

```java
stack.push(i);
```

---

# 🧩 Why Store Index Instead of Temperature?

Suppose

```
73 74 75
```

Agar stack me sirf

```
74
75
```

store karoge,

to answer kaise nikaloge?

Question puch raha hai

```
Kitne din baad?
```

Difference chahiye

```
futureIndex - currentIndex
```

Isliye stack me **index** store karte hain.

---

# 📌 Dry Run

Example

```
temp = [73,74,75,71,69,72,76,73]
```

Initially

```
Stack = []

Answer = [0,0,0,0,0,0,0,0]
```

---

### i = 7

```
73

Stack empty

Push index 7

Stack = [7]
```

---

### i = 6

```
76

73 <= 76

Pop

Stack empty

Answer = 0

Push 6

Stack = [6]
```

---

### i = 5

```
72

Top = 76

Warmer mil gaya

Answer = 6-5 = 1

Push 5

Stack = [6,5]
```

---

### i = 4

```
69

Top =72

Answer =5-4 =1

Push4

Stack=[6,5,4]
```

---

### i =3

```
71

69<=71

Pop

Top=72

Answer=5-3=2

Push3
```

---

### i =2

```
75

71<=75

Pop

72<=75

Pop

Top=76

Answer=6-2=4

Push2
```

---

### i =1

```
74

Top=75

Answer=2-1=1

Push1
```

---

### i =0

```
73

Top=74

Answer=1-0=1

Push0
```

Final Answer

```
[1,1,4,2,1,1,0,0]
```

---

# 🤔 Why Pop Smaller or Equal Temperatures?

```java
while(temp[stack.peek()] <= temp[i])
```

Example

```
Current = 75

Stack

69
71
72
```

Ye sab current se colder hain.

Future me agar kisi aur ko warmer chahiye,
to current 75 inse better candidate hai.

Isliye ye sab useless ho gaye.

Pop kar do.

---

# 🤔 Why Right to Left?

Hume future ka answer chahiye.

Agar left se right chaloge to future process hi nahi hua hoga.

Right se left me future already stack me hota hai.

Isi wajah se O(N) solution possible hota hai.

---

# 🤔 Why Stack Top is the Answer?

Stack hamesha maintain karta hai

```
Nearest warmer temperature
```

Kyuki beech ke saare colder temperatures already remove ho chuke hote hain.

Isliye top index hi first warmer day hota hai.

---

# ⏱ Complexity

### Time

```
O(N)
```

Har index maximum

- 1 baar push
- 1 baar pop

---

### Space

```
O(N)
```

Stack + Answer Array

---

# ✅ Java Code

```java
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;

        int ans[] = new int[n];
        Arrays.fill(ans, 0);

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && temp[st.peek()] <= temp[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }

            st.push(i);
        }

        return ans;
    }
}
```

---

# 📝 Revision Notes (1 Minute)

✅ Future element chahiye → Right to Left traversal.

✅ Monotonic **Decreasing Stack** use karo (temperature ke basis par).

✅ Stack me **indexes** store karo.

✅ Pop all smaller/equal temperatures.

✅ Stack top = Nearest warmer day.

✅ Answer =

```java
stack.peek() - currentIndex
```

✅ Agar stack empty ho → Answer = `0`.

---

# 🚀 Pattern

Ye problem bhi **Monotonic Stack** pattern follow karti hai.

Similar Problems:

- Next Greater Element I
- Next Greater Element II
- Daily Temperatures
- Stock Span Problem
- Largest Rectangle in Histogram
- Trapping Rain Water (Stack Approach)

### 🧠 Pattern Yaad Rakho

> **"Nearest Greater Element on Right + Distance Required = Right to Left + Monotonic Stack of Indexes."**
