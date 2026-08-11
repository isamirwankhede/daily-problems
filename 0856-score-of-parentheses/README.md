<h2><a href="https://leetcode.com/problems/score-of-parentheses">886. Score of Parentheses</a></h2><h3>Medium</h3><hr><p>Given a balanced parentheses string <code>s</code>, return <em>the <strong>score</strong> of the string</em>.</p>

<p>The <strong>score</strong> of a balanced parentheses string is based on the following rule:</p>

<ul>
	<li><code>&quot;()&quot;</code> has score <code>1</code>.</li>
	<li><code>AB</code> has score <code>A + B</code>, where <code>A</code> and <code>B</code> are balanced parentheses strings.</li>
	<li><code>(A)</code> has score <code>2 * A</code>, where <code>A</code> is a balanced parentheses string.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;()&quot;
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(())&quot;
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;()()&quot;
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 50</code></li>
	<li><code>s</code> consists of only <code>&#39;(&#39;</code> and <code>&#39;)&#39;</code>.</li>
	<li><code>s</code> is a balanced parentheses string.</li>
</ul>


# 856. Score of Parentheses

**LeetCode Problem:** 856  
**Difficulty:** Medium  
**Topics:** Stack, String

---

## 📝 Problem Statement

Given a balanced parentheses string `s`, calculate its score.

Rules:

- `()` has score `1`
- `AB` has score `score(A) + score(B)`
- `(A)` has score `2 × score(A)`

### Example

    Input: "(()())"
    Output: 4

---

## 💡 Approach

Hum is problem ko **Stack** ki help se solve karenge.

### Main Idea

Stack mein hum har opening bracket `(` ke liye ek new score level maintain karenge.

Initially:

    st = [0]

Jab `(` mile:

    st.push(0)

Matlab ek naya parenthesis group start ho gaya.

Jab `)` mile:

1. Stack se current group ka score nikalo.
2. Agar current score `0` hai, iska matlab direct `()` mila hai.
3. `()` ka score `1` hoga.
4. Agar score already present hai, toh `(A)` ka score `2 × A` hoga.
5. Calculated score ko parent level ke score mein add kar do.

---

## 🔍 Why `Math.max(2 * val, 1)`?

Code mein:

    int score = Math.max(2 * val, 1);

Yahan do cases hain.

### Case 1: `()`

Agar directly `()` hai:

    val = 0

Agar hum sirf `2 * val` karenge:

    2 * 0 = 0

Lekin problem ke according:

    () = 1

Isliye:

    Math.max(0, 1) = 1

---

### Case 2: `(A)`

Agar parentheses ke andar already koi score hai:

    val > 0

Toh:

    score = 2 * val

Example:

    (())

Inner `()` ka score:

    1

Outer parentheses:

    2 * 1 = 2

So:

    (()) = 2

---

## 🧠 Dry Run

Let's take:

    s = "(()())"

Initially:

    [0]

### Step 1: `(`

New level create:

    [0, 0]

### Step 2: `(`

Again new level:

    [0, 0, 0]

### Step 3: `)`

Current value:

    val = 0

So:

    score = max(2 * 0, 1)
          = 1

Parent score mein add:

    [0, 1]

### Step 4: `(`

New level:

    [0, 1, 0]

### Step 5: `)`

Again:

    val = 0
    score = 1

Parent mein add:

    [0, 2]

### Step 6: `)`

Now:

    val = 2

So:

    score = 2 * 2
          = 4

Parent mein add:

    [4]

Final answer:

    4

Therefore:

    (()()) = 4

---

## 🔥 Understanding the Stack

Stack ko simple way mein aise samjho:

> Har `0` ek new `(` level ko represent karta hai.

Example:

    ((()))

Initially:

    [0]

After first `(`:

    [0, 0]

After second `(`:

    [0, 0, 0]

After third `(`:

    [0, 0, 0, 0]

Ab closing brackets:

    ) → () = 1

    [0, 0, 0, 1]

Next:

    ) → (1) = 2

    [0, 0, 2]

Next:

    ) → (2) = 4

    [0, 4]

Final answer:

    4

---

## 💻 Java Code

    class Solution {
        public int scoreOfParentheses(String s) {
            Stack<Integer> st = new Stack<>();

            st.push(0);

            for (char ch : s.toCharArray()) {

                if (ch == '(') {
                    st.push(0);
                } else {
                    int val = st.pop();

                    int score = Math.max(2 * val, 1);

                    st.push(score + st.pop());
                }
            }

            return st.pop();
        }
    }

---

## 🔎 Code Explanation

### 1. Create Stack

    Stack<Integer> st = new Stack<>();

Integer stack use kar rahe hain kyunki hume har parenthesis level ka score store karna hai.

---

### 2. Initial Score

    st.push(0);

Ye outermost level ka score maintain karega.

---

### 3. Traverse String

    for (char ch : s.toCharArray())

String ke har character ko one by one process karte hain.

---

### 4. Opening Bracket

    if (ch == '(') {
        st.push(0);
    }

Har `(` ke liye ek new score level create karte hain.

---

### 5. Closing Bracket

    int val = st.pop();

Current parenthesis group ka score stack se nikalte hain.

---

### 6. Calculate Score

    int score = Math.max(2 * val, 1);

Agar:

    val = 0

Toh iska matlab direct:

    ()

Aur:

    () = 1

Otherwise:

    (A) = 2 * A

---

### 7. Parent Score Mein Add

    st.push(score + st.pop());

Yahan:

    st.pop()

parent level ka existing score deta hai.

Then:

    parentScore + currentScore

Stack mein push kar dete hain.

---

## ⏱️ Complexity

### Time Complexity

    O(n)

String ko ek baar traverse kar rahe hain.

### Space Complexity

    O(n)

Worst case mein completely nested parentheses hone par stack mein `n` elements ho sakte hain.

---

## 🎯 Key Takeaway

Is problem ka main pattern yaad rakho:

    ()     → 1
    (A)    → 2 × A
    AB     → A + B

Stack implementation:

    '(' → push(0)

    ')' →
        val = pop()
        score = max(2 * val, 1)
        score ko parent mein add karo

### Important Line

    int score = Math.max(2 * val, 1);

Ye single line dono cases handle karti hai:

    ()  → 1

    (A) → 2 × A

---

## 🚀 Final Pattern

    if '(':
        push(0)

    if ')':
        val = pop()
        score = max(2 * val, 1)
        add score to parent



### Optimized approach by using the shift opearator 

# 856. Score of Parentheses

**LeetCode:** 856  
**Difficulty:** Medium  
**Topics:** String, Stack, Bit Manipulation

---

## 📝 Problem Statement

Hume ek **balanced parentheses string** `s` di gayi hai.

Hume uska score calculate karna hai.

Rules:

- `()` ka score = `1`
- `(A)` ka score = `2 * score(A)`
- `AB` ka score = `score(A) + score(B)`

### Example

    Input: s = "(()())"
    Output: 4

Explanation:

    (()())
     ↓
    (()) + ()
     ↓
     2   + 1
     ↓
     3

Actually, let's calculate according to the structure:

    (()())
    ↓
    (()) + ()
    ↓
     2   + 1
    ↓
     3

So:

    Output = 3

---

# 💡 Approach

Normally hum is problem ko **Stack** se solve kar sakte hain.

But yaha hum **Stack use nahi karenge**.

Hum sirf do variables maintain karenge:

    int cnt = 0;
    int score = 0;

### `cnt`

`cnt` current **nesting depth** ko track karega.

### `score`

`score` final answer ko store karega.

---

# 🔥 Main Observation

Sabse important observation ye hai:

    ()
    (())
    ((()))
    (((())))

Inke scores:

    ()       = 1
    (())     = 2
    ((()))   = 4
    (((()))) = 8

Notice karo:

    1
    2
    4
    8

Ye powers of `2` hain.

Mathematically:

    2^0 = 1
    2^1 = 2
    2^2 = 4
    2^3 = 8

Aur Java mein power of 2 ko left shift se represent kar sakte hain:

    1 << 0 = 1
    1 << 1 = 2
    1 << 2 = 4
    1 << 3 = 8

Isliye jab bhi hume primitive `()` milta hai, uska contribution:

    1 << currentDepth

hoga.

---

# 🧠 Why Does `1 << cnt` Work?

Suppose:

    ((()))

Jab last `)` process hoga, usse pehle:

    cnt = 3

Closing bracket par pehle:

    cnt--

So:

    cnt = 2

Ab:

    1 << 2

means:

    4

Therefore:

    ((())) = 4

---

# 🔍 Important Observation: `()` Kaise Detect Kare?

Hume sirf un closing brackets ko score mein add karna hai jo directly ek opening bracket ke baad aa rahe hain.

Example:

    ()

Yaha:

    s[i - 1] == '('

So hum check karenge:

    if(s.charAt(i - 1) == '(')

Agar ye true hai, iska matlab hume ek primitive `()` mila.

---

# 🚶 Step-by-Step Algorithm

### Step 1: Variables

    int cnt = 0;
    int score = 0;

`cnt` nesting depth ke liye hai.

`score` final answer ke liye hai.

---

### Step 2: Traverse String

String ko left to right traverse karenge:

    for(int i = 0; i < s.length(); i++)

---

### Step 3: If `(`

Agar current character opening bracket hai:

    if(s.charAt(i) == '('){
        cnt++;
    }

Nesting depth increase hogi.

Example:

    (
    ↓
    cnt = 1

Then:

    ((
    ↓
    cnt = 2

---

### Step 4: If `)`

Agar closing bracket mila:

    else{
        cnt--;

        ...
    }

Closing bracket ke baad nesting depth ek level decrease hoti hai.

---

### Step 5: Check Primitive `()`

Ab check karenge:

    if(s.charAt(i - 1) == '(')

Agar previous character `(` tha, toh current `)` ke saath:

    ()

form hua.

Therefore iska score add karna hai.

---

### Step 6: Calculate Score Using Shift

    score += 1 << cnt;

Yaha:

    1 << cnt

means:

    2^cnt

Example:

    cnt = 0
    1 << 0 = 1

    cnt = 1
    1 << 1 = 2

    cnt = 2
    1 << 2 = 4

    cnt = 3
    1 << 3 = 8

---

# 🧪 Dry Run

Let's take:

    s = "(()())"

Correct answer:

    3

String:

    ( ( ) ( ) )

Let's process each character.

---

### `i = 0`

Character:

    (

So:

    cnt++

Now:

    cnt = 1
    score = 0

---

### `i = 1`

Character:

    (

So:

    cnt++

Now:

    cnt = 2
    score = 0

---

### `i = 2`

Character:

    )

First:

    cnt--

So:

    cnt = 1

Now check:

    s[i - 1] == '('

Yes.

So primitive `()` found.

Calculate:

    1 << cnt
    1 << 1
    = 2

Therefore:

    score = 2

---

### `i = 3`

Character:

    (

So:

    cnt++

Now:

    cnt = 2
    score = 2

---

### `i = 4`

Character:

    )

First:

    cnt--

So:

    cnt = 1

Previous character was `(`.

So primitive `()` found.

Calculate:

    1 << cnt
    1 << 1
    = 2

Therefore:

    score = 2 + 2
          = 4

---

### `i = 5`

Character:

    )

First:

    cnt--

So:

    cnt = 0

Previous character was `)`.

Therefore:

    s[i - 1] != '('

So kuch add nahi karenge.

Final:

    score = 4

Therefore:

    (()()) = 4

---

# ⚠️ Important Correction

Above dry run se clearly pata chalta hai:

    (()()) = 4

Not `3`.

Because:

    (()())
    = (()) + (())
    = 2 + 2
    = 4

Actually structure is:

    (()())
     ↑ ↑
    (()) ()

Let's carefully understand the scoring rules:

    (()())
    = ( () () )
    = 2 × (1 + 1)
    = 4

So final answer is:

    4

---

# 💻 Java Code

    class Solution {
        public int scoreOfParentheses(String s) {
            int cnt = 0;
            int score = 0;

            for(int i = 0; i < s.length(); i++) {

                if(s.charAt(i) == '(') {
                    cnt++;
                } 
                else {
                    cnt--;

                    if(s.charAt(i - 1) == '(') {
                        score += 1 << cnt;
                    }
                }
            }

            return score;
        }
    }

---

# 🔎 Code Explanation

### `int cnt = 0`

    int cnt = 0;

Ye current nesting depth track karta hai.

Example:

    (
    cnt = 1

    ((
    cnt = 2

    (((
    cnt = 3

Closing brackets par depth decrease hogi.

---

### `int score = 0`

    int score = 0;

Ye final answer store karta hai.

Har primitive `()` ka contribution isme add hota hai.

---

### Opening Bracket

    if(s.charAt(i) == '('){
        cnt++;
    }

Opening bracket aate hi depth increase.

---

### Closing Bracket

    else {
        cnt--;
    }

Closing bracket aate hi depth decrease.

Important: Hum `cnt--` **pehle** kar rahe hain.

Because `cnt` ko us depth par lana hai jahan primitive `()` ka score calculate hoga.

---

### Primitive Check

    if(s.charAt(i - 1) == '(')

Agar current `)` se just pehle `(` tha:

    ()

Toh primitive parentheses mile.

---

### Bitwise Shift

    score += 1 << cnt;

Ye sabse important line hai.

Left shift:

    1 << cnt

actually:

    2^cnt

represent karta hai.

Example:

    1 << 0 = 1
    1 << 1 = 2
    1 << 2 = 4
    1 << 3 = 8

---

# 🔥 Why No Stack Is Needed?

Stack solution mein hum har nesting level ka score store karte the.

But yaha hume actually previous scores store karne ki zarurat nahi hai.

Hume sirf ye pata hona chahiye:

    Current primitive "()" kis depth par hai?

Us depth se directly uska score calculate kar sakte hain:

    Score = 2^depth

Aur:

    2^depth = 1 << depth

Therefore sirf:

    cnt

maintain karna enough hai.

---

# 📊 Stack vs This Approach

| Approach | Time | Space |
|---|---:|---:|
| Stack | O(n) | O(n) |
| Depth + Bit Shift | O(n) | O(1) |

Both approaches have:

    Time = O(n)

But optimized approach has:

    Space = O(1)

because hum Stack use nahi kar rahe.

---

# 🎯 Most Important Concept

Is problem ka main trick hai:

    Primitive "()"
    
    ↓

    Find its nesting depth
    
    ↓

    Score = 2^depth
    
    ↓

    2^depth = 1 << depth

So:

    score += 1 << cnt;

---

# 🧠 Quick Revision

Yaad rakhne ke liye bas ye 4 points:

### 1. `cnt` = current depth

    '(' → cnt++
    ')' → cnt--

### 2. Primitive `()` detect karo

    s.charAt(i - 1) == '('

### 3. Score calculate karo

    1 << cnt

### 4. Answer mein add karo

    score += 1 << cnt

---

# 🚀 Final Pattern

    int cnt = 0;
    int score = 0;

    for(int i = 0; i < s.length(); i++) {

        if(s.charAt(i) == '(') {
            cnt++;
        }
        else {
            cnt--;

            if(s.charAt(i - 1) == '(') {
                score += 1 << cnt;
            }
        }
    }

    return score;

### Complexity

    Time: O(n)
    Space: O(1)

**Key takeaway:** Stack ki jagah sirf nesting depth track karo, aur primitive `()` ka score `1 << depth` se calculate karo.
**Stack ka use karke nested parentheses ko efficiently handle kar sakte hain.**
