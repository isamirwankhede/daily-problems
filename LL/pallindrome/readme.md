# 🧠 Palindrome Linked List (Step-by-Step Guide)

---

## 📌 What is a Palindrome?

A **Palindrome** is a sequence that reads the same **forward and backward**.

### 🔹 Examples:

* ✅ `1 → 2 → 3 → 2 → 1` → Palindrome
* ❌ `1 → 2 → 3 → 4` → Not Palindrome

---

## 📌 Problem Statement

Given the `head` of a singly linked list, return **true** if it is a palindrome, otherwise return **false**.

---

# 🚀 Approaches

We will cover:

1. 🐢 **Brute Force Approach (Easy to understand)**
2. ⚡ **Optimal Approach (Interview Best)**

---

# 🐢 Brute Force Approach (Using Extra Space)

## 💡 Idea

* Store all values of linked list into an **array / list**
* Then check if the array is palindrome

---

## 🔹 Step-by-Step

### Step 1: Traverse and store values

```java
List<Integer> list = new ArrayList<>();
ListNode temp = head;

while(temp != null){
    list.add(temp.val);
    temp = temp.next;
}
```

---

### Step 2: Check palindrome

```java
int i = 0, j = list.size() - 1;

while(i < j){
    if(!list.get(i).equals(list.get(j))){
        return false;
    }
    i++;
    j--;
}
```

---

### Step 3: Return result

```java
return true;
```

---

## 💻 Full Code (Brute Force)

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        int i = 0, j = list.size() - 1;
        while(i < j){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
```

---

## ⏱️ Complexity

| Type  | Value  |
| ----- | ------ |
| Time  | O(n)   |
| Space | O(n) ❌ |

---

## ⚠️ Drawback

* Extra memory use hota hai (array list)

---

# ⚡ Optimal Approach (O(1) Space)

## 💡 Idea

* Find middle
* Reverse second half
* Compare both halves

---

## 🔹 Step 1: Find Middle

```java
ListNode slow = head;
ListNode fast = head;

while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
}
```

---

## 🔹 Step 2: Handle Odd Length

```java
if (fast != null) slow = slow.next;
```

👉 Middle element skip karte hain

---

## 🔹 Step 3: Reverse Second Half

```java
ListNode prev = null;

while(slow != null){
    ListNode next = slow.next;
    slow.next = prev;
    prev = slow;
    slow = next;
}
```

---

## 🔹 Step 4: Compare

```java
ListNode current = head;

while(prev != null){
    if(current.val != prev.val) return false;
    current = current.next;
    prev = prev.next;
}
```

---

## 🔹 Step 5: Return

```java
return true;
```

---

## 💻 Full Code (Optimal)

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Skip middle (odd case)
        if (fast != null) slow = slow.next;

        // Step 3: Reverse second half
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Step 4: Compare
        ListNode current = head;
        while(prev != null){
            if(current.val != prev.val) return false;
            current = current.next;
            prev = prev.next;
        }

        return true;
    }
}
```

---

# 🔥 Example

### Input:

```
1 → 2 → 3 → 2 → 1
```

### Output:

```
true
```

---

# 🧠 Summary (Hinglish)

* Brute force me → list banake compare kiya
* Optimal me → reverse + compare kiya
* Odd case me → middle skip kiya

---

# 🏁 Final Comparison

| Approach    | Time | Space | Notes                  |
| ----------- | ---- | ----- | ---------------------- |
| Brute Force | O(n) | O(n)  | Easy but extra space   |
| Optimal     | O(n) | O(1)  | Best for interviews 🚀 |

---

# 🎯 Interview Tip

👉 Pehle brute force batao
👉 Fir bolo: “We can optimize space”
👉 Fir optimal explain karo

---

Happy Coding 🚀
