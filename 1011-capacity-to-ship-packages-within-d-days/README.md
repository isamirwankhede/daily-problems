<h2><a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days">1056. Capacity To Ship Packages Within D Days</a></h2><h3>Medium</h3><hr><p>A conveyor belt has packages that must be shipped from one port to another within <code>days</code> days.</p>

<p>The <code>i<sup>th</sup></code> package on the conveyor belt has a weight of <code>weights[i]</code>. Each day, we load the ship with packages on the conveyor belt (in the order given by <code>weights</code>). We may not load more weight than the maximum weight capacity of the ship.</p>

<p>Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within <code>days</code> days.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> weights = [1,2,3,4,5,6,7,8,9,10], days = 5
<strong>Output:</strong> 15
<strong>Explanation:</strong> A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> weights = [3,2,2,4,1,4], days = 3
<strong>Output:</strong> 6
<strong>Explanation:</strong> A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> weights = [1,2,3,1,1], days = 4
<strong>Output:</strong> 3
<strong>Explanation:</strong>
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= days &lt;= weights.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= weights[i] &lt;= 500</code></li>
</ul>
🚢 1011. Capacity To Ship Packages Within D Days (Binary Search)
💡 Problem Samjho

Hume ek weights[] array diya hai jisme har package ka weight hai.

Ek ship hai jiska fixed capacity hoga. Har din hum packages order maintain karke ship me load karenge.

Hume minimum capacity find karni hai jisse saare packages days ke andar ship ho jaye.

🤔 Brute Force Idea

Hum har possible capacity try kar sakte the aur check karte ki packages given days me ship hote hain ya nahi.

Lekin capacity bahut badi ho sakti hai (max weight se sum of weights tak), isliye ye approach slow ho jayegi.

🔥 Binary Search Lagao

Yaha answer ek range me exist karta hai.

Lowest Capacity

Ship ki capacity kam se kam largest package ke equal honi chahiye.

low = max(weights)

Example:

weights = [1,2,3,4,5]

low = 5

Agar capacity 4 hui to weight 5 wala package kabhi ship hi nahi hoga.

Highest Capacity

Agar ship ki capacity sab packages ke total weight ke equal ho,

high = sum(weights)

to saare packages ek hi din me chale jayenge.

Example:

weights = [1,2,3,4]

high = 10
🎯 Binary Search

Ab har baar ek capacity (mid) assume karenge.

mid = (low + high) / 2

Aur check karenge ki kya is capacity me packages given days ke andar ship ho sakte hain.

✅ canShip() Function

Ye function sirf simulation karta hai.

Start with

day = 1
currentWeight = 0

Har package ke liye:

Case 1

Agar package add karne se capacity exceed nahi hoti

currentWeight += weight;
Case 2

Agar exceed ho jati hai

day++;
currentWeight = weight;

Matlab naya din start kar diya.

End me check karenge

day <= days

Agar true hai to ye capacity sufficient hai.

Binary Search Decision
Agar ship ho gaya
canShip == true

Matlab aur bhi chhoti capacity try kar sakte hain.

high = mid - 1;
Agar ship nahi hua
canShip == false

Capacity badhani padegi.

low = mid + 1;
Dry Run
weights = [3,2,2,4,1,4]

days = 3
low = 4
high = 16
mid = 10
Day1 -> 3+2+2 = 7
+4 = 11 (Not Possible)

Day2 -> 4+1+4 = 9

Total Days = 2

Possible

Try smaller capacity.

mid = 6
Day1 -> 3+2 = 5

Day2 -> 2+4 = 6

Day3 -> 1+4 = 5

Total Days = 3

Possible

Try even smaller.

mid = 5
Need 4 days

Not Possible

So answer becomes

6
Time Complexity

Finding low & high

O(N)

Binary Search

log(sum(weights))

Checking each capacity

O(N)

Overall

O(N × log(sum(weights)))
Space Complexity
O(1)
⭐ Key Observation
Minimum answer = Maximum element
Maximum answer = Sum of all elements
Answer range me hai, isliye Binary Search on Answer use kiya.
Har mid capacity ko canShip() function se verify kiya.
Agar possible hai to aur chhoti capacity search ki, warna capacity increase ki.

Yahi pattern bahut saare Binary Search on Answer questions me use hota hai.

