# Add Two Numbers (Linked List)

## 📌 Problem Statement

You are given two **non-empty linked lists** representing two non-negative integers. The digits are stored in **reverse order**, and each node contains a single digit. Add the two numbers and return the result as a linked list.

---

## 🧠 Example

```
Input:
l1 = 2 → 4 → 3   (represents 342)
l2 = 5 → 6 → 4   (represents 465)

Output:
7 → 0 → 8   (represents 807)
```

---

## ⚙️ Approach (Hinglish Explanation)

* Hum dono linked lists ko ek saath traverse karte hain
* Har step par digits ka **sum + carry** calculate karte hain
* Agar sum 10 se bada ho jaye, to carry next step me use hota hai
* Result ke liye ek nayi linked list banate hain

---

## 💻 Code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            temp = temp.next;
        }

        return dummy.next;
    }
}
```

---

## 🔍 Step-by-Step Dry Run

| Step | l1 | l2 | Sum | Carry | Result Node |
| ---- | -- | -- | --- | ----- | ----------- |
| 1    | 2  | 5  | 7   | 0     | 7           |
| 2    | 4  | 6  | 10  | 1     | 0           |
| 3    | 3  | 4  | 8   | 0     | 8           |

Final Output:

```
7 → 0 → 8
```

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** O(max(n, m))
* **Space Complexity:** O(max(n, m))

---

## 🔑 Key Points

* Dummy node use karne se implementation easy ho jata hai
* Carry ko properly handle karna important hai
* Loop tab tak chalta hai jab tak dono lists aur carry khatam na ho jaye

---

## 🚀 Summary

* Traverse both linked lists
* Add digits + carry
* Create new node with last digit
* Update carry
* Return result list

---

## 🧾 Author
SAM

Prepared for interview & DSA practice 🚀
