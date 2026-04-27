# 🔁 Reverse Linked List (Java)

## 📌 Description
This program reverses a singly linked list using an iterative approach.

---

## 💡 Approach (Hinglish)

Hum 3 pointers use karte hain:

- `temp` → current node
- `prev` → previous node
- `front` → next node store karne ke liye

### Steps:
1. Next node ko `front` me store karo
2. Current node ka link reverse karo (`temp.next = prev`)
3. `prev` aur `temp` ko aage badhao
4. Jab tak list khatam na ho, repeat karo
5. End me `prev` new head hota hai

---

## 🧠 Code

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

📥 Example Input
12 → 5 → 7 → 8
📤 Output
8 → 7 → 5 → 12
⚡ Complexity
Time Complexity: O(N)
Space Complexity: O(1)
🚀 Key Idea

Reverse the links one by one without using extra space.

✍️ Author

Sameer Wankhede