<h2><a href="https://leetcode.com/problems/koko-eating-bananas">907. Koko Eating Bananas</a></h2><h3>Medium</h3><hr><p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>

<p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>

<p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>

<p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
</ul>
# 🍌 875. Koko Eating Bananas (Binary Search)

## 💡 Problem Samjho

Koko ke paas bahut saare banana piles hain.

Har hour Koko sirf **ek pile** choose karti hai aur **k bananas** khati hai.

Agar pile me `k` se kam bananas bache hain to wo saare kha leti hai aur us hour me aur kuch nahi khati.

Hume **minimum eating speed (k)** find karni hai jisse Koko `h` hours ke andar saare bananas finish kar de.

---

## 🤔 Brute Force Idea

Hum `k = 1` se lekar `max(pile)` tak har speed try kar sakte hain aur check kar sakte hain ki kitne hours lagenge.

Lekin maximum pile bahut bada ho sakta hai (`10^9`), isliye ye approach bahut slow ho jayegi.

---

# 🔥 Binary Search Lagao

Yaha answer ek range me exist karta hai.

### Lowest Speed

Sabse slow speed hogi:

```java
low = 1;
```

Matlab Koko har hour sirf **1 banana** khayegi.

---

### Highest Speed

Sabse fast speed largest pile ke equal hogi.

```java
high = max(piles);
```

Agar kisi pile me 30 bananas hain aur speed bhi 30 hai, to wo pile sirf **1 hour** me finish ho jayega.

---

## 🎯 Binary Search

Har baar ek speed (`mid`) assume karenge.

```java
mid = low + (high - low) / 2;
```

Ab check karenge ki kya Koko is speed se `h` hours ke andar saare bananas finish kar sakti hai.

---

## ✅ canEat() Function

Ye function calculate karta hai ki given speed `k` par saare piles finish karne me kitne hours lagenge.

Har pile ke liye:

```java
hours += (pile + k - 1) / k;
```

Ye formula exactly same hai:

```java
Math.ceil((double)pile / k)
```

Example:

```
Pile = 10
Speed = 3

10 / 3 = 3.33

Ceil = 4 hours
```

Integer formula:

```
(10 + 3 - 1) / 3
= 12 / 3
= 4
```

Sab piles ke hours add karte hain.

Agar

```java
hours <= h
```

to ye speed possible hai.

---

## Binary Search Decision

### Agar Possible Hai

```java
canEat == true
```

Matlab Koko aur bhi slow speed try kar sakti hai.

```java
high = mid - 1;
```

---

### Agar Possible Nahi Hai

```java
canEat == false
```

Matlab speed increase karni padegi.

```java
low = mid + 1;
```

---

# Dry Run

```
piles = [3,6,7,11]
h = 8
```

Initial values:

```
low = 1
high = 11
```

### mid = 6

```
3  -> 1 hour
6  -> 1 hour
7  -> 2 hours
11 -> 2 hours

Total = 6 hours
```

✅ Possible

Try smaller speed.

---

### mid = 3

```
3  -> 1
6  -> 2
7  -> 3
11 -> 4

Total = 10 hours
```

❌ Not Possible

Increase speed.

---

### mid = 4

```
3  -> 1
6  -> 2
7  -> 2
11 -> 3

Total = 8 hours
```

✅ Possible

Answer = **4**

---

# Time Complexity

Finding maximum pile:

```
O(N)
```

Binary Search:

```
O(log(maxPile))
```

Checking each speed:

```
O(N)
```

Overall:

```
O(N × log(maxPile))
```

---

# Space Complexity

```
O(1)
```

---

# ⭐ Key Observation

- Minimum speed = **1**
- Maximum speed = **Maximum pile**
- Answer ek range me exist karta hai, isliye **Binary Search on Answer** use kiya.
- Har speed ko `canEat()` function se verify kiya.
- Agar speed possible hai to aur chhoti speed search ki.
- Agar possible nahi hai to speed increase ki.

## 💯 Interview Trick

Ye formula yaad rakhna:

```java
hours += (pile + k - 1) / k;
```

Ye integer version hai:

```java
Math.ceil((double)pile / k)
```

Aur Binary Search on Answer wale questions me bahut baar use hota hai.
