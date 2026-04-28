# Linked List Loop Detection (Floyd’s Cycle Detection Algorithm)

## 📌 Problem

Check whether a given singly linked list contains a loop (cycle) or not.

---

## 🚀 Approach

We use **Floyd’s Cycle Detection Algorithm**, also known as the **Tortoise and Hare algorithm**.

### 🔑 Idea:

* Use two pointers:

  * **Slow pointer** → moves 1 step at a time
  * **Fast pointer** → moves 2 steps at a time

---

## ⚙️ Algorithm Steps

1. Initialize both `slow` and `fast` to head.
2. Traverse the list:

   * Move `slow` by 1 step.
   * Move `fast` by 2 steps.
3. If `slow == fast` at any point:

   * Loop exists → return `true`
4. If `fast` reaches `null`:

   * No loop → return `false`

---

## 💻 Code

```java
private static boolean isLoop(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast)
            return true;
    }

    return false;
}
```

---

## ⏱ Time & Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## ✅ Advantages

* No extra memory required
* Efficient for large linked lists

---

## ❗ Important Note

* Repeating values in a linked list **do NOT mean a loop**
* Loop only exists if a node points back to a previous node

---

## 🧪 Example

### No Loop:

```
1 → 2 → 3 → 4 → null
```

### Loop:

```
1 → 2 → 3 → 4
      ↑     ↓
      ← ← ←
```

---

## 📚 Use Cases

* Detect infinite loops in linked lists
* Memory structure validation
* Interview questions (very common)

---

## 🏁 Conclusion

Floyd’s algorithm is the most optimal way to detect a loop in a linked list using constant space and linear time.
