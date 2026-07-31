<h2><a href="https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1">Next Greater Element</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">You are given an array <strong>arr[]</strong> of integers, the task is to find the <strong>next greater element</strong> for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the <strong>right </strong>which is <strong>greater</strong> than the current element.<br>If there does not exist next greater of current element, then next greater element for current element is <strong>-1</strong>.</span></p>
<p><span style="font-size: 18px;"><strong>Examples<br></strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> arr[] = [1, 3, 2, 4]
<strong>Output:</strong> [3, 4, 4, -1]
<strong>Explanation:</strong> The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.
</span></pre>
<pre><span style="font-size: 18px;"><strong>Input</strong>: arr[] = [6, 8, 0, 1, 3]
<strong>Output</strong>: [8, -1, 1, 3, -1]
<strong>Explanation</strong>: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1, for 1 it is 3 and then for 3 there is no larger element on right and hence -1.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input</strong>: arr[] = [1, 2, 3, 5]
<strong>Output</strong>: [2, 3, 5, -1]
<strong>Explanation</strong>: For a sorted array, the next element is next greater element also except for the last element.</span></pre>
<pre><span style="font-size: 18px;"><strong style="font-size: 18px;">Input</strong><span style="font-size: 18px;">: arr[] = [5, 4, 3, 1]
</span><strong style="font-size: 18px;">Output</strong><span style="font-size: 18px;">: [-1, -1, -1, -1]
</span><strong style="font-size: 18px;">Explanation</strong><span style="font-size: 18px;">: There is no next greater element for any of the elements in the array, so all are -1.</span></span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ arr.size() ≤ 10<sup>6</sup><br>0 ≤ arr[i] ≤ 10<sup>9</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Flipkart</code>&nbsp;<code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>MakeMyTrip</code>&nbsp;<code>Adobe</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Stack</code>&nbsp;


# Next Greater Element (NGE) - Monotonic Stack

## Problem Statement

Har element ke liye uske **right side ka nearest greater element** find karna hai.

Agar right side me koi greater element exist nahi karta, to answer **-1** hoga.

### Example

**Input**
```text
arr = [1, 3, 2, 4]
```

**Output**
```text
[3, 4, 4, -1]
```

**Explanation**

- 1 → 3
- 3 → 4
- 2 → 4
- 4 → -1

---

# Approach (Monotonic Stack)

Brute Force approach me har element ke liye uske right side ko traverse karna padega.

**Time Complexity = O(N²)**

Ye large constraints ke liye efficient nahi hai.

Isliye hum **Monotonic Decreasing Stack** use karte hain jisse solution **O(N)** me solve ho jata hai.

---

# Intuition

Hum array ko **right se left** traverse karenge.

Reason:

Current element ka Next Greater sirf uske **right side** me ho sakta hai.

Jab hum right se left traverse karte hain tab current element ke right wale saare elements already process ho chuke hote hain.

---

# Code Explanation

### Step 1

```java
int n = arr.length;
```

Array ka size store kiya.

---

### Step 2

```java
ArrayList<Integer> ans = new ArrayList<>();
```

Answer store karne ke liye list banayi.

---

### Step 3

```java
for(int i = 0; i < n; i++){
    ans.add(-1);
}
```

Initially sab jagah **-1** fill kar diya.

Agar kisi element ka Next Greater Element nahi mila to wahi final answer rahega.

Example

```text
ans = [-1, -1, -1, -1]
```

---

### Step 4

```java
Stack<Integer> stack = new Stack<>();
```

Ek stack banaya.

Is stack me values store hongi.

Ye stack hamesha decreasing order maintain karega.

---

### Step 5

```java
for(int i = n-1; i >= 0; i--)
```

Hum last index se first index tak iterate karte hain.

Reason:

Current element ka answer uske right side me hota hai.

---

### Step 6

```java
while(!stack.isEmpty() && stack.peek() <= arr[i]){
    stack.pop();
}
```

Current element se chhote ya equal elements future me kisi ke bhi Next Greater nahi ban sakte.

Isliye unhe remove kar dete hain.

Example

```text
Stack = [4,2]

Current = 3

2 <= 3

Pop 2

Stack = [4]
```

Ab stack ka top current se bada hai.

---

### Step 7

```java
if(!stack.isEmpty()){
    ans.set(i, stack.peek());
}
```

Agar stack empty nahi hai,

to stack ka top hi current element ka Next Greater Element hai.

Example

```text
Stack = [4]

Current = 2

Answer = 4
```

---

### Step 8

```java
stack.push(arr[i]);
```

Current element ko stack me push kar dete hain.

Ye future me left side wale elements ke liye useful ho sakta hai.

---

# Dry Run

Input

```text
arr = [1,3,2,4]
```

Initially

```text
Stack = []
Answer = [-1,-1,-1,-1]
```

### i = 3

Current = 4

Stack empty

Answer = -1

Push 4

```text
Stack = [4]
```

---

### i = 2

Current = 2

Top = 4

Answer = 4

Push 2

```text
Stack = [4,2]
```

---

### i = 1

Current = 3

Top = 2

2 <= 3

Pop

```text
Stack = [4]
```

Top = 4

Answer = 4

Push 3

```text
Stack = [4,3]
```

---

### i = 0

Current = 1

Top = 3

Answer = 3

Push 1

```text
Stack = [4,3,1]
```

Final Answer

```text
[3,4,4,-1]
```

---

# Why do we pop smaller elements?

Suppose

```text
Stack = [8,5]

Current = 6
```

5 current se chhota hai.

Agar future me kisi element ka Next Greater 5 ho sakta tha,

to 6 bhi usse better answer hoga.

Isliye 5 kabhi useful nahi rahega.

Hum usse stack se remove kar dete hain.

Isi wajah se stack me sirf useful elements hi bachte hain.

---

# Time Complexity

Har element

- Ek baar push hota hai.
- Maximum ek baar pop hota hai.

**Time Complexity : O(N)**

---

# Space Complexity

Worst case me stack me saare elements aa sakte hain.

**Space Complexity : O(N)**

---

# Key Points to Remember

- Traverse array from **Right → Left**
- Stack me sirf useful greater elements rakhte hain.
- Chhote ya equal elements ko pop kar dete hain.
- Stack ka top hi Next Greater Element hota hai.
- Har element sirf ek baar push aur ek baar pop hota hai.
- Overall complexity **O(N)**.
