<h2><a href="https://leetcode.com/problems/magnetic-force-between-two-balls">Magnetic Force Between Two Balls</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has <code>n</code> empty baskets, the <code>i<sup>th</sup></code> basket is at <code>position[i]</code>, Morty has <code>m</code> balls and needs to distribute the balls into the baskets such that the <strong>minimum magnetic force</strong> between any two balls is <strong>maximum</strong>.</p>

<p>Rick stated that magnetic force between two different balls at positions <code>x</code> and <code>y</code> is <code>|x - y|</code>.</p>

<p>Given the integer array <code>position</code> and the integer <code>m</code>. Return <em>the required force</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/11/q3v1.jpg" style="width: 562px; height: 195px;" />
<pre>
<strong>Input:</strong> position = [1,2,3,4,7], m = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> position = [5,4,3,2,1,1000000000], m = 2
<strong>Output:</strong> 999999999
<strong>Explanation:</strong> We can use baskets 1 and 1000000000.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == position.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= position[i] &lt;= 10<sup>9</sup></code></li>
	<li>All integers in <code>position</code> are <strong>distinct</strong>.</li>
	<li><code>2 &lt;= m &lt;= position.length</code></li>
</ul>


# 🧲 1552. Magnetic Force Between Two Balls

## 📝 Problem Statement

Hume `m` balls ko baskets me place karna hai.

Har basket ki position `position[i]` di hui hai.

Goal hai ki **minimum distance (magnetic force)** between any two balls **maximum** ho.

Return the maximum possible minimum distance.

---

# 💡 Intuition

Question bol raha hai:

> **Minimum distance ko maximum karo.**

Ye ek classic **Binary Search on Answer** problem hai.

Hum directly answer calculate nahi kar sakte.

Instead, hum ek distance assume karte hain aur check karte hain ki kya us distance ke saath sabhi balls place ho sakti hain.

---

# 🎯 Binary Search on Answer

Sabse pehle basket positions ko sort karenge.

```java
Arrays.sort(position);
```

Kyun?

Taaki left se right greedy placement kar sake.

---

## Search Space

Minimum possible distance

```
low = 1
```

Maximum possible distance

```
high = lastPosition - firstPosition
```

Example

```
position = [1,2,3,4,7]

low = 1
high = 6
```

Ab Binary Search chalegi.

```
mid = (low + high) / 2
```

Question:

👉 Kya har do balls ke beech **minimum gap = mid** rakhte hue `m` balls place kar sakte hain?

---

## Agar Possible Hai

Matlab aur bada distance bhi try kar sakte hain.

```
ans = mid
low = mid + 1
```

---

## Agar Possible Nahi Hai

Distance bahut bada hai.

Usko chhota karna padega.

```
high = mid - 1
```

---

# 🔍 canPlace() Function

Ye function check karta hai ki given minimum gap ke saath `m` balls place ho sakti hain ya nahi.

---

## Step 1

Pehli ball hamesha first basket me rakh do.

```
last = position[0]
count = 1
```

---

## Step 2

Remaining baskets traverse karo.

Har basket ke liye check karo

```
position[i] - last >= gap
```

Agar condition true hai,

to yaha ball place kar sakte hain.

```
count++
last = position[i]
```

---

## Step 3

Agar

```
count >= m
```

Matlab successfully saari balls place ho gayi.

Return

```
true
```

Otherwise

```
false
```

---

# 📌 Dry Run

```
position = [1,2,3,4,7]

m = 3
```

Suppose

```
gap = 3
```

First ball

```
1
```

Second ball

```
4
```

Distance

```
4 - 1 = 3 ✔
```

Third ball

```
7
```

Distance

```
7 - 4 = 3 ✔
```

Placed

```
1 → 4 → 7
```

Total Balls

```
3
```

Possible?

```
Yes
```

---

Suppose

```
gap = 4
```

First ball

```
1
```

Second ball

```
7
```

Distance

```
6 ✔
```

Ab teesri ball place nahi ho sakti.

Only

```
2 Balls
```

Possible?

```
No
```

---

# 🧠 Why Greedy Works?

Hum hamesha ball ko **leftmost possible basket** me place karte hain.

Isse future baskets ke liye maximum space bachti hai.

Agar greedy placement se bhi `m` balls place nahi ho pa rahi,

to kisi aur placement se bhi nahi hogi.

Isliye greedy checking correct hai.

---

# 🧠 Why Binary Search Works?

Distance badhne par balls place karna mushkil hota jata hai.

Example

```
Gap = 2  ✔ Possible

Gap = 3  ✔ Possible

Gap = 4  ✖ Not Possible

Gap = 5  ✖ Not Possible
```

Ye ek **Monotonic Property** hai.

Isi wajah se Binary Search apply hoti hai.

---

# ⏱️ Time Complexity

Sorting

```
O(n log n)
```

Binary Search

```
log(MaxDistance)
```

Har iteration me

```
O(n)
```

Overall

```
O(n log n + n × log(MaxDistance))
```

---

# 📦 Space Complexity

```
O(1)
```

Sorting ke alawa koi extra space use nahi hota.

---

# ✅ Key Takeaways

- Ye **Binary Search on Answer** problem hai.
- Answer search space `1` se `maxPosition - minPosition` tak hoti hai.
- `canPlace()` greedy approach use karta hai.
- Hamesha first basket se placement start karte hain.
- Agar current gap possible hai, to aur bada gap try karte hain.
- Agar possible nahi hai, to gap reduce karte hain.
- Monotonic property ki wajah se Binary Search perfectly work karti hai.
```
