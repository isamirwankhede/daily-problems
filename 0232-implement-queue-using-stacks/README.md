<h2><a href="https://leetcode.com/problems/implement-queue-using-stacks">232. Implement Queue using Stacks</a></h2><h3>Easy</h3><hr><p>Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (<code>push</code>, <code>peek</code>, <code>pop</code>, and <code>empty</code>).</p>

<p>Implement the <code>MyQueue</code> class:</p>

<ul>
	<li><code>void push(int x)</code> Pushes element x to the back of the queue.</li>
	<li><code>int pop()</code> Removes the element from the front of the queue and returns it.</li>
	<li><code>int peek()</code> Returns the element at the front of the queue.</li>
	<li><code>boolean empty()</code> Returns <code>true</code> if the queue is empty, <code>false</code> otherwise.</li>
</ul>

<p><strong>Notes:</strong></p>

<ul>
	<li>You must use <strong>only</strong> standard operations of a stack, which means only <code>push to top</code>, <code>peek/pop from top</code>, <code>size</code>, and <code>is empty</code> operations are valid.</li>
	<li>Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack&#39;s standard operations.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;MyQueue&quot;, &quot;push&quot;, &quot;push&quot;, &quot;peek&quot;, &quot;pop&quot;, &quot;empty&quot;]
[[], [1], [2], [], [], []]
<strong>Output</strong>
[null, null, null, 1, 1, false]

<strong>Explanation</strong>
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= x &lt;= 9</code></li>
	<li>At most <code>100</code>&nbsp;calls will be made to <code>push</code>, <code>pop</code>, <code>peek</code>, and <code>empty</code>.</li>
	<li>All the calls to <code>pop</code> and <code>peek</code> are valid.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Can you implement the queue such that each operation is <strong><a href="https://en.wikipedia.org/wiki/Amortized_analysis" target="_blank">amortized</a></strong> <code>O(1)</code> time complexity? In other words, performing <code>n</code> operations will take overall <code>O(n)</code> time even if one of those operations may take longer.</p>




# Implement Queue Using Two Stacks

## Problem

Humein **Queue** ko implement karna hai using **2 Stacks**.

Queue follows:

**FIFO → First In First Out**

Example:

```text
push(10)
push(20)
push(30)

Queue:
10 → 20 → 30

pop() → 10
```

But Stack follows:

**LIFO → Last In First Out**

```text
push(10)
push(20)
push(30)

Stack:

30 ← TOP
20
10

pop() → 30
```

Isliye 2 stacks ka use karke Stack ke LIFO behavior ko Queue ke FIFO behavior mein convert karna hai.

---

# Approach 1 — Push Costly

Is approach mein hum **push ke time hi elements ko correct queue order mein maintain** karte hain.

## Code

```java
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {

        // Move all elements from st1 to st2
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        // Insert new element
        st1.push(x);

        // Move everything back to st1
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }

    public int pop() {
        return st1.pop();
    }

    public int peek() {
        return st1.peek();
    }

    public boolean empty() {
        return st1.isEmpty();
    }
}
```

---

## Main Idea

Hum `st1` ko aise maintain karte hain ki:

```text
TOP
 ↓
10
20
30
```

Yaani **front element hamesha top par rahega**.

Isliye:

```java
pop()
```

directly:

```java
st1.pop()
```

kar sakta hai.

---

## Step-by-Step Example

Suppose:

```java
push(10)
```

Then:

```text
st1:

10 ← TOP
```

Now:

```java
push(20)
```

### Step 1: `st1 → st2`

```text
st1: empty

st2:
10 ← TOP
```

### Step 2: `20` ko `st1` mein push

```text
st1:
20 ← TOP
```

### Step 3: `st2 → st1`

```text
st1:

10 ← TOP
20
```

Ab `10` front par hai.

---

Again:

```java
push(30)
```

Finally:

```text
st1:

10 ← TOP
20
30
```

Now:

```java
pop()
```

returns:

```text
10
```

Exactly Queue ka behavior.

---

## Why Two `while` Loops?

### First loop

```java
while(!st1.isEmpty()){
    st2.push(st1.pop());
}
```

Existing elements ko temporarily `st2` mein move karta hai.

### Then:

```java
st1.push(x);
```

New element insert karta hai.

### Second loop

```java
while(!st2.isEmpty()){
    st1.push(st2.pop());
}
```

Existing elements ko wapas `st1` mein laata hai.

Isse new element **sabse neeche** chala jata hai aur oldest element **top** par rehta hai.

---

## Complexity

### `push()`

Existing `n` elements ko:

```text
st1 → st2
st2 → st1
```

move karna padta hai.

Therefore:

```text
Time: O(n)
```

### `pop()`

```java
return st1.pop();
```

```text
Time: O(1)
```

### `peek()`

```java
return st1.peek();
```

```text
Time: O(1)
```

### `empty()`

```java
return st1.isEmpty();
```

```text
Time: O(1)
```

---

# Approach 2 — Pop Costly / Optimized Approach

Ye tumhara **better approach** hai.

Is approach mein hum `push()` ko unnecessarily expensive nahi banate.

Hum simply new element ko `st1` mein push karte hain.

```java
public void push(int x) {
    st1.push(x);
}
```

Jab `pop()` ya `peek()` karna ho, tab zarurat padne par elements ko `st2` mein transfer karte hain.

## Code

```java
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }

        return st2.pop();
    }

    public int peek() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }

        return st2.peek();
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
```

---

# Main Idea of Approach 2

`st1` ko input stack samjho.

`st2` ko output stack samjho.

```text
st1 → New elements
st2 → Elements ready for pop/peek
```

---

## Example

Suppose:

```java
push(10)
push(20)
push(30)
```

Since `push()` directly karta hai:

```text
st1:

30 ← TOP
20
10
```

`st2`:

```text
empty
```

Problem:

Queue ko chahiye:

```text
10 → 20 → 30
```

But `st1` se directly pop karenge to:

```text
30
```

mil jayega.

Isliye `pop()` ke time reverse karenge.

---

# First `pop()`

Initially:

```text
st1:

30 ← TOP
20
10

st2:
empty
```

Condition:

```java
if(st2.isEmpty())
```

true hai.

So:

```java
while(!st1.isEmpty()){
    st2.push(st1.pop());
}
```

Transfer ke baad:

```text
st1:
empty

st2:

10 ← TOP
20
30
```

Now:

```java
return st2.pop();
```

returns:

```text
10
```

Exactly Queue ka front element.

---

# Second `pop()`

Ab:

```text
st2:

10 was removed

20 ← TOP
30
```

`st2` empty nahi hai.

So transfer dobara nahi hoga.

Direct:

```java
st2.pop();
```

returns:

```text
20
```

Third `pop()`:

```text
30
```

---

# Why Don't We Transfer Every Time?

Ye approach ka sabse important concept hai.

Suppose:

```text
st2:

20
30
40
```

Agar `pop()` karna hai:

```java
st2.pop();
```

directly `20` mil jayega.

Humein `st1` se dobara elements transfer karne ki zarurat nahi hai.

Hum **sirf tab transfer karte hain jab `st2` empty ho.**

```java
if(st2.isEmpty()){
    // transfer
}
```

Isi wajah se approach efficient hai.

---

# `peek()`

`peek()` ka matlab:

> Front element return karo but remove mat karo.

```java
public int peek() {
    if(st2.isEmpty()){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
    }

    return st2.peek();
}
```

Example:

```text
st2:

10 ← TOP
20
30
```

`peek()`:

```text
10
```

But `10` remove nahi hoga.

---

# `empty()`

Queue empty tab hogi jab:

```text
st1 empty
AND
st2 empty
```

Isliye:

```java
return st1.isEmpty() && st2.isEmpty();
```

Example:

```text
st1 = empty
st2 = empty
```

Then:

```text
true
```

Agar kisi bhi stack mein element hai:

```text
false
```

---

# Complexity Comparison

| Operation | Approach 1 | Approach 2 |
|---|---:|---:|
| `push()` | O(n) | **O(1)** |
| `pop()` | O(1) | **O(1) amortized** |
| `peek()` | O(1) | **O(1) amortized** |
| `empty()` | O(1) | O(1) |
| Space | O(n) | O(n) |

---

# What is Amortized O(1)?

Ye important interview concept hai.

Suppose humare paas 5 elements hain:

```text
st1:

5
4
3
2
1
```

First `pop()` ke time:

```text
st1 → st2
```

5 elements transfer honge.

Cost:

```text
O(5)
```

But uske baad:

```text
pop() → O(1)
pop() → O(1)
pop() → O(1)
pop() → O(1)
```

Because elements already `st2` mein correct order mein hain.

So har operation individually O(1) nahi hai, but **many operations ko together dekho to average O(1)** hota hai.

This is called:

```text
Amortized O(1)
```

---

# Approach 1 vs Approach 2

## Approach 1

Hum kehte hain:

> "Push ke time hi queue ka order maintain kar do."

Therefore:

```text
push → O(n)
pop  → O(1)
peek → O(1)
```

### Simple visualization

```text
push(10)
push(20)
push(30)

st1:

10 ← TOP
20
30
```

Front already top par hai.

---

# Approach 2

Hum kehte hain:

> "Push ko simple rakho. Jab pop/peek ki zarurat ho tab order reverse kar do."

Therefore:

```text
push → O(1)
pop  → O(1) amortized
peek → O(1) amortized
```

Visualization:

```text
After push:

st1:

30 ← TOP
20
10
```

Then when `pop()` is required:

```text
st1 → st2

st2:

10 ← TOP
20
30
```

Now Queue order mil gaya.

---

# ⭐ Best Way to Remember

### Approach 1

```text
PUSH COSTLY
POP CHEAP
```

### Approach 2

```text
PUSH CHEAP
POP OCCASIONALLY COSTLY
```

But overall:

```text
Approach 2
→ Amortized O(1)
```

---

# Final Interview Explanation

Agar interviewer pooche:

**"How did you implement Queue using two Stacks?"**

Tum bol sakte ho:

> Queue follows FIFO whereas Stack follows LIFO. I used two stacks, `st1` and `st2`. In the optimized approach, I directly push new elements into `st1`, so push takes O(1). Whenever I need to perform `pop` or `peek`, I check whether `st2` is empty. If it is empty, I transfer all elements from `st1` to `st2`. This reverses their order, making the oldest element available at the top of `st2`. Then I perform pop or peek from `st2`. Each element is transferred from one stack to another at most once for a particular phase, so the amortized time complexity of pop and peek is O(1), with O(n) extra space.

---

# 🎯 One-Line Logic

```text
st1 = incoming elements
st2 = outgoing elements

Push → st1

Pop/Peek:
    if st2 empty:
        st1 → st2

    use st2
```

**Remember:**

> **Two stacks together reverse the order twice, allowing us to convert LIFO behavior into FIFO behavior.**
