# 🔁 Find Cycle Starting Node in Linked List

## 📌 Problem Statement
Ek linked list diya hai. Hume check karna hai:
- Kya usme **cycle (loop)** hai?
- Agar hai, to **cycle ka starting node return karo**
- Agar cycle nahi hai, to `null` return karo

---
codestudio - https://www.naukri.com/code360/problems/detect-the-first-node-of-the-loop_1112628?leftPanelTabValue=SUBMISSION

gfg - https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1

leetcode - https://leetcode.com/problems/linked-list-cycle-ii/

## 🚀 Approach 1: Optimal (Floyd’s Cycle Detection / Tortoise & Hare)

### 💡 Intuition (Simple Hinglish)
Hum 2 pointers use karte hain:
- **Slow pointer** → 1 step move karta hai  
- **Fast pointer** → 2 step move karta hai  

### 🔍 Logic:
- Agar cycle hai → slow aur fast **kabhi na kabhi milenge**
- Jab dono mil jaye:
  - Slow ko wapas `head` pe le aao
  - Ab slow aur fast dono ko **1 step** move karo
  - Jaha dono dubara milte hain → wahi **cycle ka starting node hai**

---

### 🧠 Ye kaam kaise karta hai?
Thoda maths hai but easy samajh lo:

- Head se cycle start tak distance = `L`
- Cycle ke andar meeting point tak distance = `X`
- Total cycle length = `C`

Jab slow aur fast milte hain, tab relation banta hai:

👉 `L = C - X`

Isliye jab hum slow ko head pe le jaate hain aur dono ko same speed se chalate hain, wo **exact cycle ke starting point pe milte hain**

---

### ✅ Code (Optimal)
```java
public static Node firstNode(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }

    return null;
} 
```

⏱️ Complexity
Time: O(N)
Space: O(1) (best part 🔥)

## 🐢 Approach 2: Brute Force (HashSet Use karke)

💡 Intuition (Hinglish)

Ek HashSet lo
Linked list traverse karo
Har node ko set me daalte jao
Agar koi node already set me mil gaya → wahi cycle start hai

✅ Code (Brute Force)

```java
import java.util.HashSet;

public static Node firstNodeBrute(Node head) {
    HashSet<Node> visited = new HashSet<>();

    Node temp = head;

    while (temp != null) {
        if (visited.contains(temp)) {
            return temp;
        }

        visited.add(temp);
        temp = temp.next;
    }

    return null;
}

```

### ⏱️ Complexity
Time: O(N)
Space: O(N) (extra memory lagta hai)

### ⚖️ Comparison
Approach	Time	Space	Easy?	Best Use
Floyd Algo	O(N)	O(1)	Medium	Interviews 🔥
HashSet	O(N)	O(N)	Easy	Beginners

🎯 Final Summary
Agar interview hai → Floyd’s Algorithm use karo (most expected)
Agar simple solution chahiye → HashSet wala approach

Trick yaad rakhna:

"Meeting point ke baad slow ko head pe le jao, fir dono ek step chalenge → cycle start mil jayega"

