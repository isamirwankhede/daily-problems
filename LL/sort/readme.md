# 📘 Merge Sort on Linked List (Hinglish Explanation)
### gfg : 
https://www.geeksforgeeks.org/problems/insertion-sort-for-singly-linked-list/1
### leetcode 
https://leetcode.com/problems/sort-list/
### coding ninja
https://www.naukri.com/code360/problems/sort-linked-list_920517?leftPanelTabValue=SUBMISSION


## 🔥 Problem Statement

Hume ek **singly linked list** di gayi hai, aur hume usse **sort** karna hai efficiently.

👉 Best approach: **Merge Sort**
Kyuki linked list me random access nahi hota, isliye quicksort efficient nahi hota.

---

## 🧠 Approach (High Level)

Merge Sort me 3 steps hote hai:

1. **Find Middle** → list ko 2 parts me todna
2. **Recursively Sort** → dono parts ko sort karna
3. **Merge** → dono sorted lists ko combine karna

---

## 🧩 Code Breakdown (Hinglish)

### 1️⃣ `findMiddle()` function

```java
public ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}
```

### 💡 Explanation:

* `slow` ek-ek step move karta hai
* `fast` do-do step move karta hai
* Jab `fast` end tak pahuchta hai → `slow` middle pe hota hai

👉 Isse hum list ko 2 equal parts me divide kar sakte hai

---

### 2️⃣ `merge2()` function (Merge two sorted lists)

```java
public ListNode merge2(ListNode list1 , ListNode list2) {
    ListNode dummyNode = new ListNode(-1);
    ListNode temp = dummyNode;

    while(list1 != null && list2 != null){
        if(list1.val < list2.val){
            temp.next = list1;
            list1 = list1.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
        }
        temp = temp.next;
    }

    if(list1 != null) temp.next = list1;
    else temp.next = list2;

    return dummyNode.next;
}
```

### 💡 Explanation:

* Dummy node use kiya for easy handling
* Dono lists compare karke chhota element add karte hai
* End me jo list bachti hai usko directly attach kar dete hai

---

### 3️⃣ `sortList()` function (Main Logic)

```java
public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) return head;

    ListNode middle = findMiddle(head);
    ListNode rightHead = middle.next;
    middle.next = null;
    ListNode leftHead = head;

    leftHead = sortList(leftHead);
    rightHead = sortList(rightHead);

    return merge2(leftHead , rightHead);
}
```

### 💡 Explanation:

1. **Base Case**

   * Agar list empty hai ya ek hi node hai → already sorted

2. **Divide**

   * Middle find karo
   * List ko 2 parts me tod do

3. **Recursion**

   * Left aur right dono ko separately sort karo

4. **Merge**

   * Dono sorted lists ko merge karo

---

## 🔁 Dry Run Example

Input:

```
4 → 2 → 1 → 3
```

Steps:

```
Split → [4,2] & [1,3]
Split → [4] [2] [1] [3]
Merge → [2,4] & [1,3]
Final Merge → [1,2,3,4]
```

---

## ⏱ Complexity

| Type  | Value                      |
| ----- | -------------------------- |
| Time  | O(n log n)                 |
| Space | O(log n) (recursion stack) |

---

## ⚡ Important Interview Points

* Linked List me Merge Sort best hai
* Fast & Slow pointer concept 🔥
* Dummy node trick useful hota hai
* Stable sorting algorithm hai

---

## ✅ Summary

✔ Divide list using middle
✔ Recursively sort both halves
✔ Merge sorted lists

👉 Ye pattern bahut common hai interviews me!

---

## 🚀 Bonus Tip

Agar interviewer bole:

> "Without recursion karo"

👉 Tab **iterative bottom-up merge sort** use karna hota hai (advanced level)

---

Agar chaho to next step me:

* Step-by-step dry run with pointers
* Interview questions simulation
* Ya iska iterative version bhi sikha deta hoon 💯
