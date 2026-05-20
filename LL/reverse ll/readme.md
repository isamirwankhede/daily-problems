# 🔁 Reverse Linked List (Java)
https://leetcode.com/problems/reverse-linked-list/
## 📌 Problem
Given a singly linked list, reverse it and print the updated list.

---

## 💡 Approach

We reverse the linked list using **three pointers**:

- `temp` → current node
- `prev` → previous node
- `front` → next node (to avoid losing connection)

### Steps:
1. Traverse the list using `temp`
2. Store next node in `front`
3. Reverse the link → `temp.next = prev`
4. Move `prev` and `temp` one step forward
5. Repeat until list ends
6. Return `prev` as new head

---

## 🧠 Logic (Core Code)

```java
private static Node reverseList(Node head) {
    Node temp = head;
    Node prev = null;

    while (temp != null) {
        Node front = temp.next;
        temp.next = prev;
        prev = temp;
        temp = front;
    }

    return prev;
}
```

📥 Input
12 → 5 → 7 → 8
📤 Output
8 → 7 → 5 → 12
⚡ Time & Space Complexity
Time Complexity: O(N)
Space Complexity: O(1)
🧩 Key Insight

Reverse links one by one using pointer manipulation without using extra space.
