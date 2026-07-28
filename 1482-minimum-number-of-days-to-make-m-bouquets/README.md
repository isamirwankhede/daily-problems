<h2><a href="https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets">1605. Minimum Number of Days to Make m Bouquets</a></h2><h3>Medium</h3><hr><p>You are given an integer array <code>bloomDay</code>, an integer <code>m</code> and an integer <code>k</code>.</p>

<p>You want to make <code>m</code> bouquets. To make a bouquet, you need to use <code>k</code> <strong>adjacent flowers</strong> from the garden.</p>

<p>The garden consists of <code>n</code> flowers, the <code>i<sup>th</sup></code> flower will bloom in the <code>bloomDay[i]</code> and then can be used in <strong>exactly one</strong> bouquet.</p>

<p>Return <em>the minimum number of days you need to wait to be able to make </em><code>m</code><em> bouquets from the garden</em>. If it is impossible to make m bouquets return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> bloomDay = [1,10,3,10,2], m = 3, k = 1
<strong>Output:</strong> 3
<strong>Explanation:</strong> Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> bloomDay = [1,10,3,10,2], m = 3, k = 2
<strong>Output:</strong> -1
<strong>Explanation:</strong> We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
<strong>Output:</strong> 12
<strong>Explanation:</strong> We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>bloomDay.length == n</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= bloomDay[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= m &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
</ul>
# 🌸 1482. Minimum Number of Days to Make m Bouquets

## 📝 Problem Statement

Hume `m` bouquets banane hai aur har bouquet ke liye `k` **adjacent flowers** chahiye.

Har flower kisi specific day (`bloomDay[i]`) par bloom hota hai.

Hume **minimum day** return karna hai jisme hum `m` bouquets bana sake.

Agar possible hi nahi hai, to `-1` return karo.

---

## 💡 Intuition

Question minimum day puch raha hai.

Brute force kya hota?

Har day check karo ki bouquet ban sakte hai ya nahi.

Lekin `bloomDay[i]` ki value `10^9` tak ho sakti hai.

Isliye har day iterate karna impossible hai.

Yaha **Binary Search on Answer** use karenge.

---

# 🎯 Binary Search on Answer

Hum binary search **array par nahi**, **answer (days)** par laga rahe hain.

Search Space:

```
Minimum bloom day  -> low
Maximum bloom day  -> high
```

Example:

```
Bloom Days

[1,10,3,10,2]

low = 1
high = 10
```

Ab binary search karege.

```
mid = (low + high)/2
```

Check karenge:

👉 Kya `mid` days ke andar `m` bouquets ban sakte hain?

Agar **haan**

To aur chhota answer bhi ho sakta hai.

```
high = mid - 1
```

Agar **nahi**

To aur days wait karna padega.

```
low = mid + 1
```

---

# 🔍 isPossible() Function

Ye function check karta hai ki kisi particular day tak bouquet banana possible hai ya nahi.

Hum array traverse karte hain.

### Rule

Agar flower bloom ho gaya hai

```
bloomDay[i] <= day
```

To usko count karenge.

```
cnt++
```

Jab

```
cnt == k
```

matlab ek bouquet ban gaya.

```
bouquets++
cnt = 0
```

Fir next bouquet banana start karenge.

---

## ❌ Agar flower bloom nahi hua

```
bloomDay[i] > day
```

To adjacency break ho gayi.

Isliye

```
cnt = 0
```

---

# 📌 Dry Run

```
bloomDay = [7,7,7,7,12,7,7]

m = 2
k = 3
```

Suppose

```
day = 7
```

Bloomed flowers

```
✔ ✔ ✔ ✔ ✖ ✔ ✔
```

Traversal

```
cnt=1
cnt=2
cnt=3

Bouquet = 1

cnt=1

Flower not bloomed

cnt=0

cnt=1
cnt=2
```

Only

```
1 Bouquet
```

Possible?

```
No
```

---

Now

```
day = 12
```

```
✔ ✔ ✔ ✔ ✔ ✔ ✔
```

Traversal

```
cnt=3

Bouquet=1

cnt=3

Bouquet=2
```

Possible?

```
Yes
```

---

# 🧠 Why Binary Search Works?

Jaise-jaise day increase hota hai,

Bloom hone wale flowers kabhi kam nahi hote.

Matlab

```
Day 5  ->  Possible ❌

Day 6  ->  Possible ❌

Day 7  ->  Possible ✔

Day 8  ->  Possible ✔

Day 9  ->  Possible ✔
```

Ye ek **Monotonic Property** hai.

Isi wajah se Binary Search apply hoti hai.

---

# ⚠️ Edge Case

Sabse pehle check karte hain

```java
if (n < (long)m * k)
    return -1;
```

Agar total flowers hi kam hain,

to bouquet banana impossible hai.

Example

```
Flowers = 5

Need

m = 3
k = 2

Required Flowers = 6

Available = 5
```

Answer

```
-1
```

---

# ⏱️ Time Complexity

Finding min and max

```
O(n)
```

Binary Search

```
log(MaxDay)
```

Each binary search iteration

```
O(n)
```

Overall

```
O(n × log(MaxBloomDay))
```

---

# 📦 Space Complexity

```
O(1)
```

No extra space is used.

---

# ✅ Key Takeaways

- Binary Search **answer par** lag rahi hai, array par nahi.
- `isPossible()` sirf check karta hai ki given day tak bouquet ban sakte hain ya nahi.
- Adjacent flowers mandatory hain.
- Flower bloom na ho to adjacency break ho jati hai (`cnt = 0`).
- Monotonic property ki wajah se Binary Search perfectly work karti hai.
