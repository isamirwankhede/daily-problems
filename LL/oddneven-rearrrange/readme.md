# 🔗 Odd Even Linked List (Hinglish Guide)

Leetcode = >https://leetcode.com/problems/odd-even-linked-list/

## 🧩 Problem Samajh Lo

Tumhe ek singly linked list di hai.
Tumhe usko aise rearrange karna hai ki:

* Pehle **odd index wale nodes**
* Fir **even index wale nodes**

⚠️ Indexing **1-based** hai (0-based nahi)

---

## 📌 Example

```id="ex1"
Input:  1 → 2 → 3 → 4 → 5
Output: 1 → 3 → 5 → 2 → 4
```

---

# 🐢 Brute Force Approach (List use karke)

## 💡 Idea

* Ek list me odd values store karo
* Dusri list me even values store karo
* Dono ko merge karke wapas linked list me daal do

---

## 🧠 Steps (Simple Hinglish)

1. `oddList` aur `evenList` banao
2. Linked list traverse karo
3. Agar index odd hai → `oddList` me add karo
4. Agar even hai → `evenList` me add karo
5. Dono lists merge karo
6. Dobara linked list me values fill karo

---

## 💻 Code (Brute Force)

```java id="bfcode"
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        ListNode temp = head;
        int index = 1;

        while (temp != null) {
            if (index % 2 == 1) {
                odd.add(temp.val);
            } else {
                even.add(temp.val);
            }
            temp = temp.next;
            index++;
        }

        odd.addAll(even);

        temp = head;
        int i = 0;

        while (temp != null) {
            temp.val = odd.get(i++);
            temp = temp.next;
        }

        return head;
    }
}
```

---

## ⏱️ Complexity

* Time: **O(N)**
* Space: **O(N)** ❌ extra space lag raha hai

---

# ⚡ Optimal Approach (In-place, BEST)

## 💡 Core Idea

* Odd aur even nodes ko **alag chain** me todna hai
* Fir end me even list ko odd ke peeche attach karna hai

👉 Koi extra list nahi banegi — sab in-place hoga

---

## 🧠 Step-by-Step Hinglish Explanation

### 🔹 Step 1: Initial Setup

```java id="opt1"
ListNode odd = head;        // 1
ListNode even = head.next;  // 2
ListNode evenHead = even;   // store even start
```

👉 `evenHead` is important
Baad me even list ko attach karne ke liye use hoga

---

### 🔹 Step 2: Loop chalayenge

```java id="opt2"
while (even != null && even.next != null)
```

👉 Yeh check isliye:

* `even.next` safe hona chahiye
* warna null pointer error aa jayega ❌

---

### 🔹 Step 3: Main Logic

```java id="opt3"
odd.next = even.next;
```

👉 Odd node ko next odd se jod diya

```java id="opt4"
even.next = even.next.next;
```

👉 Even node ko next even se jod diya

```java id="opt5"
odd = odd.next;
even = even.next;
```

👉 Dono pointers ek step aage badha diye

---

## 🔍 Dry Run

### Start:

```id="dr1"
1 → 2 → 3 → 4 → 5
odd = 1
even = 2
```

---

### Iteration 1:

```id="dr2"
odd.next = 3
even.next = 4
```

List:

```id="dr3"
1 → 3 → 4 → 5
2 → 4 → 5
```

Move:

```id="dr4"
odd = 3
even = 4
```

---

### Iteration 2:

```id="dr5"
odd.next = 5
even.next = null
```

List:

```id="dr6"
1 → 3 → 5
2 → 4
```

---

### Loop End

---

### 🔹 Step 4: Final Attach

```java id="opt6"
odd.next = evenHead;
```

Final Answer:

```id="final"
1 → 3 → 5 → 2 → 4
```

---

## 💻 Code (Optimal)

```java id="optcode"
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
```

---

## ⏱️ Complexity

* Time: **O(N)**
* Space: **O(1)** ✅ (best)

---

# ⚠️ Common Mistakes

❌ `head.next != null` base condition galat
❌ `odd = odd.next.next` (double jump mat karo)
❌ `even = even.next.next`

👉 Rule yaad rakho:

> **Link change karo, fir sirf 1 step move karo**

---

# 🚀 Summary

| Approach    | Time | Space | Notes                |
| ----------- | ---- | ----- | -------------------- |
| Brute Force | O(N) | O(N)  | Easy but extra space |
| Optimal     | O(N) | O(1)  | Best for interviews  |

---

## 🏁 Final Line

👉 Interview me **Optimal approach hi bolna**
👉 Brute force sirf understanding ke liye use karo

---
