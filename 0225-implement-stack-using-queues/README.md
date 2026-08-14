<h2><a href="https://leetcode.com/problems/implement-stack-using-queues/">225. Implement Stack using Queues</a></h2><h3>Easy</h3><hr><p>Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (<code>push</code>, <code>top</code>, <code>pop</code>, and <code>empty</code>).</p>

<p>Implement the <code>MyStack</code> class:</p>

<ul>
	<li><code>void push(int x)</code> Pushes element x to the top of the stack.</li>
	<li><code>int pop()</code> Removes the element on the top of the stack and returns it.</li>
	<li><code>int top()</code> Returns the element on the top of the stack.</li>
	<li><code>boolean empty()</code> Returns <code>true</code> if the stack is empty, <code>false</code> otherwise.</li>
</ul>

<p><b>Notes:</b></p>

<ul>
	<li>You must use <strong>only</strong> standard operations of a queue, which means that only <code>push to back</code>, <code>peek/pop from front</code>, <code>size</code> and <code>is empty</code> operations are valid.</li>
	<li>Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue&#39;s standard operations.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;MyStack&quot;, &quot;push&quot;, &quot;push&quot;, &quot;top&quot;, &quot;pop&quot;, &quot;empty&quot;]
[[], [1], [2], [], [], []]
<strong>Output</strong>
[null, null, null, 2, 2, false]

<strong>Explanation</strong>
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= x &lt;= 9</code></li>
	<li>At most <code>100</code> calls will be made to <code>push</code>, <code>pop</code>, <code>top</code>, and <code>empty</code>.</li>
	<li>All the calls to <code>pop</code> and <code>top</code> are valid.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Can you implement the stack using only one queue?</p>





# 225. Implement Stack using Queues (Hinglish)

## 🎯 Problem

Hume **Stack (LIFO)** banana hai, lekin hum **sirf Queue (FIFO)** use kar sakte hain.

- **Stack:** Last In First Out
- **Queue:** First In First Out

Example:

    Push: 1, 2, 3

Stack:

    TOP
     3
     2
     1

Pop → 3

---

# Approach 1: Costly Push ✅

## Idea

Jab bhi new element push kare, usko sabse aage le aao.

Isliye:

1. `x` ko `q2` me daalo.
2. `q1` ke saare elements `q2` me shift karo.
3. `q1 = q2`
4. `q2` ko empty bana do.

### Dry Run

Push(1)

    q1 = []
    q2 = []

    q2 = [1]
    q1 = [1]

Push(2)

    q1 = [1]

    q2 = [2]

Shift

    q2 = [2,1]

Final

    q1 = [2,1]

Push(3)

    q1 = [2,1]

    q2 = [3]

Shift

    q2 = [3,2,1]

Final

    q1 = [3,2,1]

Ab front hi top ban gaya.

### Pop

Before:

    q1 = [3,2,1]

Pop:

    return 3

After:

    q1 = [2,1]

### Code

    class MyStack {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int x) {

            q2.offer(x);

            while(!q1.isEmpty()){
                q2.offer(q1.poll());
            }

            q1 = q2;
            q2 = new LinkedList<>();
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

### Complexity

| Operation | Time |
|---|---:|
| Push | O(n) |
| Pop | O(1) |
| Top | O(1) |
| Empty | O(1) |

**Remember:** Push me mehnat, Pop easy.

---

# Approach 2: Costly Pop ✅

## Idea

Push bilkul normal queue ki tarah hoga.

Jab Pop karna ho tab last element tak jaayenge.

### Push

    q1 = []

Push(1)

    q1 = [1]

Push(2)

    q1 = [1,2]

Push(3)

    q1 = [1,2,3]

### Pop Dry Run

Current:

    q1 = [1,2,3]
    q2 = []

Step 1

    move 1

    q1 = [2,3]
    q2 = [1]

Step 2

    move 2

    q1 = [3]
    q2 = [1,2]

Stop because only one element left.

Last element = 3

    pop = 3

Swap queues

    q1 = [1,2]

Done ✅

### Top Dry Run

Current:

    q1 = [1,2,3]

Move until one remains

    q2 = [1,2]
    q1 = [3]

Peek

    val = 3

Important ⚠️

Top remove nahi karta.

Isliye dubara `3` ko `q2` me daalenge.

    q2 = [1,2,3]

Swap

    q1 = [1,2,3]

Stack same hi raha.

### Code

    class MyStack {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int x){
            q1.offer(x);
        }

        public int pop(){

            while(q1.size() > 1){
                q2.offer(q1.poll());
            }

            int val = q1.poll();

            q1 = q2;
            q2 = new LinkedList<>();

            return val;
        }

        public int top(){

            while(q1.size() > 1){
                q2.offer(q1.poll());
            }

            int val = q1.peek();

            q2.offer(val);

            q1 = q2;
            q2 = new LinkedList<>();

            return val;
        }

        public boolean empty(){
            return q1.isEmpty();
        }
    }

### Complexity

| Operation | Time |
|---|---:|
| Push | O(1) |
| Pop | O(n) |
| Top | O(n) |
| Empty | O(1) |

**Remember:** Push easy, Pop me mehnat.

---

# Interview Trick 🤯

| Feature | Costly Push | Costly Pop |
|---|---|---|
| Push | O(n) | O(1) |
| Pop | O(1) | O(n) |
| Top | O(1) | O(n) |
| Best When | Pop zyada ho | Push zyada ho |

---

# One Line Memory Hack 🧠

- **Costly Push:** "Naya element ko sabse aage le aao."
- **Costly Pop:** "Last element nikalne ke liye sabko temporarily dusri queue me bhejo."
